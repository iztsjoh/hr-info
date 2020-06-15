package com.ibiz.api.service;

import com.ibiz.api.dao.HrIfDao;
import com.ibiz.api.dao.UserBaseInfoDao;
import com.ibiz.api.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ibiz.api.cmnUtil.SecurityUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
@Configuration
@ComponentScan
@EnableAutoConfiguration
@PropertySource("classpath:/properties/if.properties")
public class UserBaseInfoService {

    @Resource(name = "userBaseInfoDao")
    private UserBaseInfoDao userBaseInfoDao;

    @Resource(name = "hrIfDao")
    private HrIfDao hrIfDao;

    @Value("${if.account.empid}") private String strIfAccountEmpId;
    @Value("${if.account.pw}") private String strIfAccountPw;
    @Value("${if.requestUri.publicKey}") private String publicKey;
    @Value("${if.requestUri.deptChangeInfo}") private String changeDeptInfo;
    @Value("${if.requestUri.userInfo}") private String userInfoURI;
    @Value("${if.requestUri.returnResponse}") private String returnResponse;
    @Value("${if.requestUri.costCenterChangeInfo}") private String costCenterChangeInfo;
    @Value("${if.requestUri.positionChangeInfo}") private String positionChangeInfo;
    @Value("${if.requestUri.responsibilityChangeInfo}") private String responsibilityChangeInfo;
    @Value("${if.requestUri.recruitChangeInfo}") private String recruitChangeInfo;
    @Value("${if.requestUri.empStatusInfo}") private String empStatusInfo;
    @Value("${if.requestUri.contDateChangeInfo}") private String contDateChangeInfo;

    public JsonObject<List<UserBaseInfoVO>, Object> selectUserBaseInfo(Payload<UserBaseInfoVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".selectDeptTree");

        JsonObject<List<UserBaseInfoVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        UserBaseInfoVO userBaseInfoVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + userBaseInfoVO);

        List<UserBaseInfoVO> list = userBaseInfoDao.selectUserBaseInfo(userBaseInfoVO);

        jsonObject.Data = list;
        jsonObject.TotalSize = userBaseInfoDao.selectUserBaseInfoCount(userBaseInfoVO);
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    public JsonObject<Object, Object> updateHRIfInfo(Payload<DeptChgHisVO> requestPayload) throws Exception {
        log.info("call Service : " + this.getClass().getName() + ".updateHRIfInfo");

        JsonObject<Object, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> parameterMap = new HashMap<String, String>();

        SecurityUtil secu = new SecurityUtil();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c1 = Calendar.getInstance();

        String strPublickKey = "";
        String strSymmetricKey = "";
        int nResult = 0;




        //1.publicKey 요청
        log.info("API call Start: publicKey");

        String requestUri = publicKey;

        parameterMap.put("SND_STAT_CD", "1");
        parameterMap.put("SND_STAT_MSG", "SUCCESS");
        parameterMap.put("SND_JOB_CD", "");
        parameterMap.put("SND_DATE", sdf.format(c1.getTime()));
        parameterMap.put("SND_SEQ", "1");
        parameterMap.put("SND_SYS_DST_CD", "IBIZ");
        parameterMap.put("DATA_CHG_DST_CD", "C");

        IFPublicKeyVO[]  publickeyArry = restTemplate.postForObject(requestUri, parameterMap, IFPublicKeyVO[].class);



        strPublickKey = publickeyArry[0].getPUBLICK_KEY();
        strSymmetricKey = "0192837465hfyrnvpqlamzut";

        log.info("API call End: publicKey");


        //2.유저정보
        //2.1유저정보 요청
        log.info("API call Start: userInfo");

        parameterMap = new HashMap<String, String>();
        requestUri = userInfoURI;

        parameterMap.put("SND_STAT_CD", "1");
        parameterMap.put("SND_STAT_MSG", "SUCCESS");
        parameterMap.put("SND_JOB_CD", "H01");
        parameterMap.put("SND_DATE", sdf.format(c1.getTime()));
        parameterMap.put("SND_SEQ", "1");
        parameterMap.put("SND_SYS_DST_CD", "IBIZ");
        parameterMap.put("DATA_CHG_DST_CD", "C");
        parameterMap.put("EMP_ID", strIfAccountEmpId);
        parameterMap.put("PASSWD", secu.RSAEncrypt(strIfAccountPw, strPublickKey));
        parameterMap.put("SYMMETRIC_KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

        log.info("PASSWD : " + secu.RSAEncrypt(strIfAccountPw, strPublickKey));
        log.info("SYMMETRIC_KEY : " + secu.RSAEncrypt(strSymmetricKey, strPublickKey));

        IFUserInfoVO[] userInfoArry = restTemplate.postForObject(requestUri, parameterMap, IFUserInfoVO[].class);
        //2.2리턴결과 송신
        if(userInfoArry[0].getSND_STAT_CD().trim().equals("1"))
        {
            nResult = 0;

            for(IFUserInfoVO user : userInfoArry)
            {
                IFUserInfoVO userTmp = new IFUserInfoVO();

                try {
                    //수신테이블 입력
                    userTmp.setSND_JOB_CD(user.getSND_JOB_CD() == null || user.getSND_JOB_CD().length() == 0 ? "" : user.getSND_JOB_CD());
                    userTmp.setSND_DATE(user.getSND_DATE() == null || user.getSND_DATE().length() == 0 ? "" : user.getSND_DATE());
                    userTmp.setSND_SEQ(user.getSND_SEQ() == null || user.getSND_SEQ().length() == 0 ? "" : user.getSND_SEQ());
                    userTmp.setDATA_CHG_DST_CD(user.getDATA_CHG_DST_CD() == null || user.getDATA_CHG_DST_CD().length() == 0 ? "" : user.getDATA_CHG_DST_CD());
                    userTmp.setSND_SYS_DST_CD(user.getSND_SYS_DST_CD() == null || user.getSND_SYS_DST_CD().length() == 0 ? "" : user.getSND_SYS_DST_CD());

                    userTmp.setEMP_ID(user.getEMP_ID() == null || user.getEMP_ID().length() == 0 ? "" : secu.TripleDESDescrypt(user.getEMP_ID(), strSymmetricKey));
                    userTmp.setEMP_NM(user.getEMP_NM() == null || user.getEMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(user.getEMP_NM(), strSymmetricKey));
                    userTmp.setSSRG_NO(user.getSSRG_NO() == null || user.getSSRG_NO().length() == 0 ? "" : secu.TripleDESDescrypt(user.getSSRG_NO(), strSymmetricKey));
                    userTmp.setBLTO_DEPT_ID(user.getBLTO_DEPT_ID() == null || user.getBLTO_DEPT_ID().length() == 0 ? "" : secu.TripleDESDescrypt(user.getBLTO_DEPT_ID(), strSymmetricKey));
                    userTmp.setBLTO_DEPT_NM(user.getBLTO_DEPT_NM() == null || user.getBLTO_DEPT_NM().length() == 0 ? "" : secu.TripleDESDescrypt(user.getBLTO_DEPT_NM(), strSymmetricKey));
                    userTmp.setCC_ID(user.getCC_ID() == null || user.getCC_ID().length() == 0 ? "" : secu.TripleDESDescrypt(user.getCC_ID(), strSymmetricKey));
                    userTmp.setCC_NM(user.getCC_NM() == null || user.getCC_NM().length() == 0 ? "" : secu.TripleDESDescrypt(user.getCC_NM(), strSymmetricKey));
                    userTmp.setBLTO_COMP_CD(user.getBLTO_COMP_CD() == null || user.getBLTO_COMP_CD().length() == 0 ? "" : secu.TripleDESDescrypt(user.getBLTO_COMP_CD(), strSymmetricKey));
                    userTmp.setBLTO_COMP_NM(user.getBLTO_COMP_NM() == null || user.getBLTO_COMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(user.getBLTO_COMP_NM(), strSymmetricKey));
                    userTmp.setOFPS_CD(user.getOFPS_CD() == null || user.getOFPS_CD().length() == 0 ? "" : secu.TripleDESDescrypt(user.getOFPS_CD(), strSymmetricKey));
                    userTmp.setOFPS_CD_NM(user.getOFPS_CD_NM() == null || user.getOFPS_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(user.getOFPS_CD_NM(), strSymmetricKey));
                    userTmp.setOFPS_YRVC_COUNT(user.getOFPS_YRVC_COUNT() == null || user.getOFPS_YRVC_COUNT().length() == 0 ? "" : secu.TripleDESDescrypt(user.getOFPS_YRVC_COUNT(), strSymmetricKey));
                    userTmp.setRESO_CD(user.getRESO_CD() == null || user.getRESO_CD().length() == 0 ? "" : secu.TripleDESDescrypt(user.getRESO_CD(), strSymmetricKey));
                    userTmp.setRESO_CD_NM(user.getRESO_CD_NM() == null || user.getRESO_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(user.getRESO_CD_NM(), strSymmetricKey));
                    userTmp.setRECRT_DST_CD(user.getRECRT_DST_CD() == null || user.getRECRT_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(user.getRECRT_DST_CD(), strSymmetricKey));
                    userTmp.setRECRT_DST_CD_NM(user.getRECRT_DST_CD_NM() == null || user.getRECRT_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(user.getRECRT_DST_CD_NM(), strSymmetricKey));
                    userTmp.setCNTR_START_DATE(user.getCNTR_START_DATE() == null || user.getCNTR_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(user.getCNTR_START_DATE(), strSymmetricKey));
                    userTmp.setCNTR_END_DATE(user.getCNTR_END_DATE() == null || user.getCNTR_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(user.getCNTR_END_DATE(), strSymmetricKey));
                    userTmp.setHDOC_STAT_DTL_CD(user.getHDOC_STAT_DTL_CD() == null || user.getHDOC_STAT_DTL_CD().length() == 0 ? "" : secu.TripleDESDescrypt(user.getHDOC_STAT_DTL_CD(), strSymmetricKey));
                    userTmp.setHDOC_STAT_DTL_CD_NM(user.getHDOC_STAT_DTL_CD_NM() == null || user.getHDOC_STAT_DTL_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(user.getHDOC_STAT_DTL_CD_NM(), strSymmetricKey));
                    userTmp.setCOMP_TEL_NO(user.getCOMP_TEL_NO() == null || user.getCOMP_TEL_NO().length() == 0 ? "" : secu.TripleDESDescrypt(user.getCOMP_TEL_NO(), strSymmetricKey));
                    userTmp.setMBPH_NO(user.getMBPH_NO() == null || user.getMBPH_NO().length() == 0 ? "" : secu.TripleDESDescrypt(user.getMBPH_NO(), strSymmetricKey));
                    userTmp.setEML_ADRS(user.getEML_ADRS() == null || user.getEML_ADRS().length() == 0 ? "" : secu.TripleDESDescrypt(user.getEML_ADRS(), strSymmetricKey));
                    userTmp.setCOMP_ENCM_DATE(user.getCOMP_ENCM_DATE() == null || user.getCOMP_ENCM_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(user.getCOMP_ENCM_DATE(), strSymmetricKey));
                    userTmp.setGRP_ENCM_DATE(user.getGRP_ENCM_DATE() == null || user.getGRP_ENCM_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(user.getGRP_ENCM_DATE(), strSymmetricKey));
                    userTmp.setLVAB_START_DATE(user.getLVAB_START_DATE() == null || user.getLVAB_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(user.getLVAB_START_DATE(), strSymmetricKey));
                    userTmp.setLVAB_END_DATE(user.getLVAB_END_DATE() == null || user.getLVAB_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(user.getLVAB_END_DATE(), strSymmetricKey));
                    userTmp.setRET_DATE(user.getRET_DATE() == null || user.getRET_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(user.getRET_DATE(), strSymmetricKey));
                    userTmp.setJBEF_EMP_ID(user.getJBEF_EMP_ID() == null || user.getJBEF_EMP_ID().length() == 0 ? "" : secu.TripleDESDescrypt(user.getJBEF_EMP_ID(), strSymmetricKey));
                    userTmp.setSEX_CD(user.getSEX_CD() == null || user.getSEX_CD().length() == 0 ? "" : secu.TripleDESDescrypt(user.getSEX_CD(), strSymmetricKey));

                    nResult = hrIfDao.insertApiUserInfo(userTmp);


                    //전송결과 결과 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", nResult > 0 ? "1" : "2" );
                    parameterMap.put("SND_STAT_MSG", nResult > 0 ? "SUCCESS" : "FAIL");
                    parameterMap.put("SND_JOB_CD", userTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(userTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(userTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);

                }catch (Exception e) {

                    //전송결과 에러 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", "2" );
                    parameterMap.put("SND_STAT_MSG", e.getMessage());
                    parameterMap.put("SND_JOB_CD", userTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(userTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(userTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);
                }
            }
        }


        //2.3운영테이블 저장

        //운영테이블 입력  (사원기본 + 사용자 권한)
        List<IFUserInfoResultVO> userlist = new ArrayList<IFUserInfoResultVO>();
        userlist = hrIfDao.selectApiUserInfo();

        for(IFUserInfoResultVO user : userlist)
        {
            user.setEmpId(user.getEmpId() == null || user.getEmpId().length() == 0 ? "" : user.getEmpId());
            user.setEmpNm(user.getEmpNm() == null || user.getEmpNm().length() == 0 ? "" : user.getEmpNm());
            user.setSsrgNo(user.getSsrgNo() == null || user.getSsrgNo().length() == 0 ? "" : user.getSsrgNo());
            user.setBltoDeptId(user.getBltoDeptId() == null || user.getBltoDeptId().length() == 0 ? "" : user.getBltoDeptId());
            user.setBltoDeptNm(user.getBltoDeptNm() == null || user.getBltoDeptNm().length() == 0 ? "" : user.getBltoDeptNm());
            user.setOfpsCd(user.getOfpsCd() == null || user.getOfpsCd().length() == 0 ? "" : user.getOfpsCd());
            user.setOfpsCdNm(user.getOfpsCdNm() == null || user.getOfpsCdNm().length() == 0 ? "" : user.getOfpsCdNm());
            user.setOfpsYrvcCount(user.getOfpsYrvcCount() == null || user.getOfpsYrvcCount().length() == 0 ? "" : user.getOfpsYrvcCount());
            user.setResoCd(user.getResoCd() == null || user.getResoCd().length() == 0 ? "" : user.getResoCd());
            user.setResoCdNm(user.getResoCdNm() == null || user.getResoCdNm().length() == 0 ? "" : user.getResoCdNm());
            user.setCompEncmDate(user.getCompEncmDate() == null || user.getCompEncmDate().length() == 0 ? "" : user.getCompEncmDate());
            user.setGrpEncmDate(user.getGrpEncmDate() == null || user.getGrpEncmDate().length() == 0 ? "" : user.getGrpEncmDate());
            user.setRetDate(user.getRetDate() == null || user.getRetDate().length() == 0 ? "" : user.getRetDate());
            user.setRecrtDstCd(user.getRecrtDstCd() == null || user.getRecrtDstCd().length() == 0 ? "" : user.getRecrtDstCd());
            user.setCntrStartDate(user.getCntrStartDate() == null || user.getCntrStartDate().length() == 0 ? "" : user.getCntrStartDate());
            user.setCntrEndDate(user.getCntrEndDate() == null || user.getCntrEndDate().length() == 0 ? "" : user.getCntrEndDate());
            user.setHdocStatCd(user.getHdocStatCd() == null || user.getHdocStatCd().length() == 0 ? "" : user.getHdocStatCd());
            user.setHdocStatDtlCd(user.getHdocStatDtlCd() == null || user.getHdocStatDtlCd().length() == 0 ? "" : user.getHdocStatDtlCd());
            user.setLvabStartDate(user.getLvabStartDate() == null || user.getLvabStartDate().length() == 0 ? "" : user.getLvabStartDate());
            user.setLvabEndDate(user.getLvabEndDate() == null || user.getLvabEndDate().length() == 0 ? "" : user.getLvabEndDate());
            user.setBltoCompCd(user.getBltoCompCd() == null || user.getBltoCompCd().length() == 0 ? "" : user.getBltoCompCd());
            user.setBltoCompNm(user.getBltoCompNm() == null || user.getBltoCompNm().length() == 0 ? "" : user.getBltoCompNm());
            user.setCompTelNo(user.getCompTelNo() == null || user.getCompTelNo().length() == 0 ? "" : user.getCompTelNo());
            user.setMbphNo(user.getMbphNo() == null || user.getMbphNo().length() == 0 ? "" : user.getMbphNo());
            user.setEmlAdrs(user.getEmlAdrs() == null || user.getEmlAdrs().length() == 0 ? "" : user.getEmlAdrs());
            user.setSexCd(user.getSexCd() == null || user.getSexCd().length() == 0 ? "" : user.getSexCd());

            //@SuppressWarnings("deprecation")
            //ShaPasswordEncoder encoder = new ShaPasswordEncoder(512);	// 암호화 방식인 sha-256 객체구함
            //user.setDefaultGWPW(encoder.encodePassword("chrlqlqjs@#!8", null));

            user.setDefaultGWPW(secu.TripleDESEncrypt("chrlqlqjs@#!8", strSymmetricKey));

            IFUserInfoResultVO userTmp = hrIfDao.selectRunUserInfoYN(user);

            try {

                //1.사원기본
                if(!userTmp.getValChk().trim().equals("0"))
                    nResult = hrIfDao.updateRunUserInfo(user);
                else
                    nResult = hrIfDao.insertRunUserInfo(user);

                //2.고객관련

                //2.1고객ID 가져오기
                userTmp = hrIfDao.selectRunCustomerID(user);
                user.setCustId(userTmp.getCustId() == null || userTmp.getCustId().length() == 0 ? "" : userTmp.getCustId());

                //2.2고객기본
                nResult = hrIfDao.insertRunCustomerBaseHistroy(user);

                nResult = hrIfDao.updateRunCustomerBase(user);
                if(nResult < 1)
                    nResult = hrIfDao.insertRunCustomerBase(user);

                //2.3고객역활
                nResult = hrIfDao.updateRunCustomerRole(user);
                if(nResult < 1)
                    nResult = hrIfDao.insertRunCustomerRole(user);

                //2.4고객연락처(사내전화)
                nResult = hrIfDao.updateRunCustomerContactForCompTelNo(user);
                if(nResult < 1 && user.getCompTelNo() != null && user.getCompTelNo().length() > 0 )
                    nResult = hrIfDao.insertRunCustomerContactForCompTelNo(user);

                //2.5고객연락처(모바일)
                nResult = hrIfDao.updateRunCustomerContactForMbphNo(user);
                if(nResult < 1 && user.getMbphNo() != null && user.getMbphNo().length() > 0)
                    nResult = hrIfDao.insertRunCustomerContactForMbphNo(user);

                //2.6고객연락처(이메일)
                nResult = hrIfDao.updateRunCustomerContactForEmlAdrs(user);
                if(nResult < 1 && user.getEmlAdrs() != null && user.getEmlAdrs().length() > 0)
                    nResult = hrIfDao.insertRunCustomerContactForEmlAdrs(user);

                //2.7고객관계
                nResult = hrIfDao.updateRunCustomerRelation(user);
                if(nResult < 1)
                    nResult = hrIfDao.insertRunCustomerRelation(user);

                //3.시스템 관리

                //3.1 시스템 사용자 정보
                nResult = hrIfDao.updateUserSystem(user);

                if(nResult < 1)
                    nResult = hrIfDao.insesrtUserSystem(user);

                //3.2 사용자 권한
                nResult = hrIfDao.updateUserAuthForDept(user);

                if(nResult < 1)
                    nResult = hrIfDao.insertUserAuthForDept(user);

                //hrIfDao.updateUserAuthForAll(user);  기능 제거


                //결과처리
                user.setBtjbRstCd(nResult > 0 ? "1" : "2");
                user.setBtjbMsgCont("SUCESS");

            } catch(Exception e) {
                user.setBtjbRstCd("2");
                user.setBtjbMsgCont(e.getMessage());
            }

            hrIfDao.updateApiUserInfo(user);
        }

        log.info("API call End: userInfo");


        //3. 변경이력 저장
        IFHRChangeInfoVO[] ifhrChangeArry;

        //3.1부서이동이력 요청
        log.info("API call Start: Dept Change History");

        parameterMap = new HashMap<String, String>();
        requestUri = changeDeptInfo;

        parameterMap.put("SND_STAT_CD", "1");
        parameterMap.put("SND_STAT_MSG", "SUCCESS");
        parameterMap.put("SND_JOB_CD", "H01");
        parameterMap.put("SND_DATE", sdf.format(c1.getTime()));
        parameterMap.put("SND_SEQ", "1");
        parameterMap.put("SND_SYS_DST_CD", "IBIZ");
        parameterMap.put("DATA_CHG_DST_CD", "C");
        parameterMap.put("EMP_ID", strIfAccountEmpId);
        parameterMap.put("PASSWD", secu.RSAEncrypt(strIfAccountPw, strPublickKey));
        parameterMap.put("SYMMETRIC_KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

        ifhrChangeArry  = restTemplate.postForObject(requestUri, parameterMap, IFHRChangeInfoVO[].class);

        if(ifhrChangeArry[0].getSND_STAT_CD().trim().equals("1"))
        {
            nResult = 0;

            for(IFHRChangeInfoVO hrchg : ifhrChangeArry)
            {
                IFHRChangeInfoVO hrchgTmp = new IFHRChangeInfoVO();

                try {
                    //수신테이블 입력
                    hrchgTmp.setSND_JOB_CD(hrchg.getSND_JOB_CD() == null || hrchg.getSND_JOB_CD().length() == 0 ? "" : hrchg.getSND_JOB_CD());
                    hrchgTmp.setSND_DATE(hrchg.getSND_DATE() == null || hrchg.getSND_DATE().length() == 0 ? "" : hrchg.getSND_DATE());
                    hrchgTmp.setSND_SEQ(hrchg.getSND_SEQ() == null || hrchg.getSND_SEQ().length() == 0 ? "" : hrchg.getSND_SEQ());
                    hrchgTmp.setDATA_CHG_DST_CD(hrchg.getDATA_CHG_DST_CD() == null || hrchg.getDATA_CHG_DST_CD().length() == 0 ? "" : hrchg.getDATA_CHG_DST_CD());
                    hrchgTmp.setSND_SYS_DST_CD(hrchg.getSND_SYS_DST_CD() == null || hrchg.getSND_SYS_DST_CD().length() == 0 ? "" : hrchg.getSND_SYS_DST_CD());

                    hrchgTmp.setEMP_ID(hrchg.getEMP_ID() == null || hrchg.getEMP_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getEMP_ID(), strSymmetricKey));
                    hrchgTmp.setEMP_NM(hrchg.getEMP_NM() == null || hrchg.getEMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getEMP_NM(), strSymmetricKey));
                    hrchgTmp.setAVL_START_DATE(hrchg.getAVL_START_DATE() == null || hrchg.getAVL_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getAVL_START_DATE(), strSymmetricKey));
                    hrchgTmp.setAVL_END_DATE(hrchg.getAVL_END_DATE() == null || hrchg.getAVL_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getAVL_END_DATE(), strSymmetricKey));
                    hrchgTmp.setBLTO_DEPT_ID(hrchg.getBLTO_DEPT_ID() == null || hrchg.getBLTO_DEPT_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_DEPT_ID(), strSymmetricKey));
                    hrchgTmp.setBLTO_DEPT_NM(hrchg.getBLTO_DEPT_NM() == null || hrchg.getBLTO_DEPT_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_DEPT_NM(), strSymmetricKey));
                    hrchgTmp.setCNPS_DST_CD(hrchg.getCNPS_DST_CD() == null || hrchg.getCNPS_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNPS_DST_CD(), strSymmetricKey));
                    hrchgTmp.setCNPS_DST_CD_NM(hrchg.getCNPS_DST_CD_NM() == null || hrchg.getCNPS_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNPS_DST_CD_NM(), strSymmetricKey));
                    hrchgTmp.setCC_ID(hrchg.getCC_ID() == null || hrchg.getCC_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCC_ID(), strSymmetricKey));
                    hrchgTmp.setCC_NM(hrchg.getCC_NM() == null || hrchg.getCC_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCC_NM(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_CD(hrchg.getBLTO_COMP_CD() == null || hrchg.getBLTO_COMP_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_CD(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_NM(hrchg.getBLTO_COMP_NM() == null || hrchg.getBLTO_COMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_NM(), strSymmetricKey));
                    hrchgTmp.setOFPS_CD(hrchg.getOFPS_CD() == null || hrchg.getOFPS_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getOFPS_CD(), strSymmetricKey));
                    hrchgTmp.setOFPS_CD_NM(hrchg.getOFPS_CD_NM() == null || hrchg.getOFPS_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getOFPS_CD_NM(), strSymmetricKey));
                    hrchgTmp.setRESO_CD(hrchg.getRESO_CD() == null || hrchg.getRESO_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRESO_CD(), strSymmetricKey));
                    hrchgTmp.setRESO_CD_NM(hrchg.getRESO_CD_NM() == null || hrchg.getRESO_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRESO_CD_NM(), strSymmetricKey));
                    hrchgTmp.setRECRT_DST_CD(hrchg.getRECRT_DST_CD() == null || hrchg.getRECRT_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRECRT_DST_CD(), strSymmetricKey));
                    hrchgTmp.setRECRT_DST_CD_NM(hrchg.getRECRT_DST_CD_NM() == null || hrchg.getRECRT_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRECRT_DST_CD_NM(), strSymmetricKey));
                    hrchgTmp.setHDOC_STAT_DTL_CD(hrchg.getHDOC_STAT_DTL_CD() == null || hrchg.getHDOC_STAT_DTL_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getHDOC_STAT_DTL_CD(), strSymmetricKey));
                    hrchgTmp.setHDOC_STAT_DTL_CD_NM(hrchg.getHDOC_STAT_DTL_CD_NM() == null || hrchg.getHDOC_STAT_DTL_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getHDOC_STAT_DTL_CD_NM(), strSymmetricKey));
                    hrchgTmp.setCNTR_START_DATE(hrchg.getCNTR_START_DATE() == null || hrchg.getCNTR_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNTR_START_DATE(), strSymmetricKey));
                    hrchgTmp.setCNTR_END_DATE(hrchg.getCNTR_END_DATE() == null || hrchg.getCNTR_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNTR_END_DATE(), strSymmetricKey));

                    hrchgTmp.setBLTO_COMP_CD(hrchg.getBLTO_COMP_CD() == null || hrchg.getBLTO_COMP_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_CD(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_NM(hrchg.getBLTO_COMP_NM() == null || hrchg.getBLTO_COMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_NM(), strSymmetricKey));

                    nResult = hrIfDao.insertApiHRChgInfo (hrchgTmp);

                    //전송결과 결과 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", nResult > 0 ? "1" : "2" );
                    parameterMap.put("SND_STAT_MSG", nResult > 0 ? "SUCCESS" : "FAIL");
                    parameterMap.put("SND_JOB_CD", hrchgTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(hrchgTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(hrchgTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);

                }catch (Exception e) {

                    //전송결과 에러 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", "2" );
                    parameterMap.put("SND_STAT_MSG", e.getMessage());
                    parameterMap.put("SND_JOB_CD", hrchgTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(hrchgTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(hrchgTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);
                }

            }
        }
        log.info("API call End: Dept Change History");

        //3.2.코스트센터 변경이력 요청
        log.info("API call Start: CostCenter Change History");

        parameterMap = new HashMap<String, String>();
        requestUri = costCenterChangeInfo;

        parameterMap.put("SND_STAT_CD", "1");
        parameterMap.put("SND_STAT_MSG", "SUCCESS");
        parameterMap.put("SND_JOB_CD", "H01");
        parameterMap.put("SND_DATE", sdf.format(c1.getTime()));
        parameterMap.put("SND_SEQ", "1");
        parameterMap.put("SND_SYS_DST_CD", "IBIZ");
        parameterMap.put("DATA_CHG_DST_CD", "C");
        parameterMap.put("EMP_ID", strIfAccountEmpId);
        parameterMap.put("PASSWD", secu.RSAEncrypt(strIfAccountPw, strPublickKey));
        parameterMap.put("SYMMETRIC_KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

        ifhrChangeArry  = restTemplate.postForObject(requestUri, parameterMap, IFHRChangeInfoVO[].class);

        if(ifhrChangeArry[0].getSND_STAT_CD().trim().equals("1"))
        {
            nResult = 0;

            for(IFHRChangeInfoVO hrchg : ifhrChangeArry)
            {
                IFHRChangeInfoVO hrchgTmp = new IFHRChangeInfoVO();

                try {
                    //수신테이블 입력
                    hrchgTmp.setSND_JOB_CD(hrchg.getSND_JOB_CD() == null || hrchg.getSND_JOB_CD().length() == 0 ? "" : hrchg.getSND_JOB_CD());
                    hrchgTmp.setSND_DATE(hrchg.getSND_DATE() == null || hrchg.getSND_DATE().length() == 0 ? "" : hrchg.getSND_DATE());
                    hrchgTmp.setSND_SEQ(hrchg.getSND_SEQ() == null || hrchg.getSND_SEQ().length() == 0 ? "" : hrchg.getSND_SEQ());
                    hrchgTmp.setDATA_CHG_DST_CD(hrchg.getDATA_CHG_DST_CD() == null || hrchg.getDATA_CHG_DST_CD().length() == 0 ? "" : hrchg.getDATA_CHG_DST_CD());
                    hrchgTmp.setSND_SYS_DST_CD(hrchg.getSND_SYS_DST_CD() == null || hrchg.getSND_SYS_DST_CD().length() == 0 ? "" : hrchg.getSND_SYS_DST_CD());

                    hrchgTmp.setEMP_ID(hrchg.getEMP_ID() == null || hrchg.getEMP_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getEMP_ID(), strSymmetricKey));
                    hrchgTmp.setEMP_NM(hrchg.getEMP_NM() == null || hrchg.getEMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getEMP_NM(), strSymmetricKey));
                    hrchgTmp.setAVL_START_DATE(hrchg.getAVL_START_DATE() == null || hrchg.getAVL_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getAVL_START_DATE(), strSymmetricKey));
                    hrchgTmp.setAVL_END_DATE(hrchg.getAVL_END_DATE() == null || hrchg.getAVL_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getAVL_END_DATE(), strSymmetricKey));
                    hrchgTmp.setBLTO_DEPT_ID(hrchg.getBLTO_DEPT_ID() == null || hrchg.getBLTO_DEPT_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_DEPT_ID(), strSymmetricKey));
                    hrchgTmp.setBLTO_DEPT_NM(hrchg.getBLTO_DEPT_NM() == null || hrchg.getBLTO_DEPT_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_DEPT_NM(), strSymmetricKey));
                    hrchgTmp.setCNPS_DST_CD(hrchg.getCNPS_DST_CD() == null || hrchg.getCNPS_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNPS_DST_CD(), strSymmetricKey));
                    hrchgTmp.setCNPS_DST_CD_NM(hrchg.getCNPS_DST_CD_NM() == null || hrchg.getCNPS_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNPS_DST_CD_NM(), strSymmetricKey));
                    hrchgTmp.setCC_ID(hrchg.getCC_ID() == null || hrchg.getCC_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCC_ID(), strSymmetricKey));
                    hrchgTmp.setCC_NM(hrchg.getCC_NM() == null || hrchg.getCC_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCC_NM(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_CD(hrchg.getBLTO_COMP_CD() == null || hrchg.getBLTO_COMP_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_CD(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_NM(hrchg.getBLTO_COMP_NM() == null || hrchg.getBLTO_COMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_NM(), strSymmetricKey));
                    hrchgTmp.setOFPS_CD(hrchg.getOFPS_CD() == null || hrchg.getOFPS_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getOFPS_CD(), strSymmetricKey));
                    hrchgTmp.setOFPS_CD_NM(hrchg.getOFPS_CD_NM() == null || hrchg.getOFPS_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getOFPS_CD_NM(), strSymmetricKey));
                    hrchgTmp.setRESO_CD(hrchg.getRESO_CD() == null || hrchg.getRESO_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRESO_CD(), strSymmetricKey));
                    hrchgTmp.setRESO_CD_NM(hrchg.getRESO_CD_NM() == null || hrchg.getRESO_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRESO_CD_NM(), strSymmetricKey));
                    hrchgTmp.setRECRT_DST_CD(hrchg.getRECRT_DST_CD() == null || hrchg.getRECRT_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRECRT_DST_CD(), strSymmetricKey));
                    hrchgTmp.setRECRT_DST_CD_NM(hrchg.getRECRT_DST_CD_NM() == null || hrchg.getRECRT_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRECRT_DST_CD_NM(), strSymmetricKey));
                    hrchgTmp.setHDOC_STAT_DTL_CD(hrchg.getHDOC_STAT_DTL_CD() == null || hrchg.getHDOC_STAT_DTL_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getHDOC_STAT_DTL_CD(), strSymmetricKey));
                    hrchgTmp.setHDOC_STAT_DTL_CD_NM(hrchg.getHDOC_STAT_DTL_CD_NM() == null || hrchg.getHDOC_STAT_DTL_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getHDOC_STAT_DTL_CD_NM(), strSymmetricKey));
                    hrchgTmp.setCNTR_START_DATE(hrchg.getCNTR_START_DATE() == null || hrchg.getCNTR_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNTR_START_DATE(), strSymmetricKey));
                    hrchgTmp.setCNTR_END_DATE(hrchg.getCNTR_END_DATE() == null || hrchg.getCNTR_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNTR_END_DATE(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_CD(hrchg.getBLTO_COMP_CD() == null || hrchg.getBLTO_COMP_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_CD(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_NM(hrchg.getBLTO_COMP_NM() == null || hrchg.getBLTO_COMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_NM(), strSymmetricKey));


                    nResult = hrIfDao.insertApiHRChgInfo (hrchgTmp);

                    //전송결과 결과 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", nResult > 0 ? "1" : "2" );
                    parameterMap.put("SND_STAT_MSG", nResult > 0 ? "SUCCESS" : "FAIL");
                    parameterMap.put("SND_JOB_CD", hrchgTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(hrchgTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(hrchgTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);

                }catch (Exception e) {

                    //전송결과 에러 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", "2" );
                    parameterMap.put("SND_STAT_MSG", e.getMessage());
                    parameterMap.put("SND_JOB_CD", hrchgTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(hrchgTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(hrchgTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);
                }

            }
        }
        log.info("API call End: CostCenter Change History");

        //3.3.직위변경정보 요청
        log.info("API call Start: OfficePostion Change History");

        parameterMap = new HashMap<String, String>();
        requestUri = positionChangeInfo;

        parameterMap.put("SND_STAT_CD", "1");
        parameterMap.put("SND_STAT_MSG", "SUCCESS");
        parameterMap.put("SND_JOB_CD", "H01");
        parameterMap.put("SND_DATE", sdf.format(c1.getTime()));
        parameterMap.put("SND_SEQ", "1");
        parameterMap.put("SND_SYS_DST_CD", "IBIZ");
        parameterMap.put("DATA_CHG_DST_CD", "C");
        parameterMap.put("EMP_ID", strIfAccountEmpId);
        parameterMap.put("PASSWD", secu.RSAEncrypt(strIfAccountPw, strPublickKey));
        parameterMap.put("SYMMETRIC_KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

        ifhrChangeArry  = restTemplate.postForObject(requestUri, parameterMap, IFHRChangeInfoVO[].class);

        if(ifhrChangeArry[0].getSND_STAT_CD().trim().equals("1"))
        {
            nResult = 0;

            for(IFHRChangeInfoVO hrchg : ifhrChangeArry)
            {
                IFHRChangeInfoVO hrchgTmp = new IFHRChangeInfoVO();

                try {
                    //수신테이블 입력
                    hrchgTmp.setSND_JOB_CD(hrchg.getSND_JOB_CD() == null || hrchg.getSND_JOB_CD().length() == 0 ? "" : hrchg.getSND_JOB_CD());
                    hrchgTmp.setSND_DATE(hrchg.getSND_DATE() == null || hrchg.getSND_DATE().length() == 0 ? "" : hrchg.getSND_DATE());
                    hrchgTmp.setSND_SEQ(hrchg.getSND_SEQ() == null || hrchg.getSND_SEQ().length() == 0 ? "" : hrchg.getSND_SEQ());
                    hrchgTmp.setDATA_CHG_DST_CD(hrchg.getDATA_CHG_DST_CD() == null || hrchg.getDATA_CHG_DST_CD().length() == 0 ? "" : hrchg.getDATA_CHG_DST_CD());
                    hrchgTmp.setSND_SYS_DST_CD(hrchg.getSND_SYS_DST_CD() == null || hrchg.getSND_SYS_DST_CD().length() == 0 ? "" : hrchg.getSND_SYS_DST_CD());

                    hrchgTmp.setEMP_ID(hrchg.getEMP_ID() == null || hrchg.getEMP_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getEMP_ID(), strSymmetricKey));
                    hrchgTmp.setEMP_NM(hrchg.getEMP_NM() == null || hrchg.getEMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getEMP_NM(), strSymmetricKey));
                    hrchgTmp.setAVL_START_DATE(hrchg.getAVL_START_DATE() == null || hrchg.getAVL_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getAVL_START_DATE(), strSymmetricKey));
                    hrchgTmp.setAVL_END_DATE(hrchg.getAVL_END_DATE() == null || hrchg.getAVL_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getAVL_END_DATE(), strSymmetricKey));
                    hrchgTmp.setBLTO_DEPT_ID(hrchg.getBLTO_DEPT_ID() == null || hrchg.getBLTO_DEPT_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_DEPT_ID(), strSymmetricKey));
                    hrchgTmp.setBLTO_DEPT_NM(hrchg.getBLTO_DEPT_NM() == null || hrchg.getBLTO_DEPT_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_DEPT_NM(), strSymmetricKey));
                    hrchgTmp.setCNPS_DST_CD(hrchg.getCNPS_DST_CD() == null || hrchg.getCNPS_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNPS_DST_CD(), strSymmetricKey));
                    hrchgTmp.setCNPS_DST_CD_NM(hrchg.getCNPS_DST_CD_NM() == null || hrchg.getCNPS_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNPS_DST_CD_NM(), strSymmetricKey));
                    hrchgTmp.setCC_ID(hrchg.getCC_ID() == null || hrchg.getCC_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCC_ID(), strSymmetricKey));
                    hrchgTmp.setCC_NM(hrchg.getCC_NM() == null || hrchg.getCC_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCC_NM(), strSymmetricKey));
                    hrchgTmp.setOFPS_CD(hrchg.getOFPS_CD() == null || hrchg.getOFPS_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getOFPS_CD(), strSymmetricKey));
                    hrchgTmp.setOFPS_CD_NM(hrchg.getOFPS_CD_NM() == null || hrchg.getOFPS_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getOFPS_CD_NM(), strSymmetricKey));
                    hrchgTmp.setRESO_CD(hrchg.getRESO_CD() == null || hrchg.getRESO_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRESO_CD(), strSymmetricKey));
                    hrchgTmp.setRESO_CD_NM(hrchg.getRESO_CD_NM() == null || hrchg.getRESO_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRESO_CD_NM(), strSymmetricKey));
                    hrchgTmp.setRECRT_DST_CD(hrchg.getRECRT_DST_CD() == null || hrchg.getRECRT_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRECRT_DST_CD(), strSymmetricKey));
                    hrchgTmp.setRECRT_DST_CD_NM(hrchg.getRECRT_DST_CD_NM() == null || hrchg.getRECRT_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRECRT_DST_CD_NM(), strSymmetricKey));
                    hrchgTmp.setHDOC_STAT_DTL_CD(hrchg.getHDOC_STAT_DTL_CD() == null || hrchg.getHDOC_STAT_DTL_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getHDOC_STAT_DTL_CD(), strSymmetricKey));
                    hrchgTmp.setHDOC_STAT_DTL_CD_NM(hrchg.getHDOC_STAT_DTL_CD_NM() == null || hrchg.getHDOC_STAT_DTL_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getHDOC_STAT_DTL_CD_NM(), strSymmetricKey));
                    hrchgTmp.setCNTR_START_DATE(hrchg.getCNTR_START_DATE() == null || hrchg.getCNTR_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNTR_START_DATE(), strSymmetricKey));
                    hrchgTmp.setCNTR_END_DATE(hrchg.getCNTR_END_DATE() == null || hrchg.getCNTR_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNTR_END_DATE(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_CD(hrchg.getBLTO_COMP_CD() == null || hrchg.getBLTO_COMP_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_CD(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_NM(hrchg.getBLTO_COMP_NM() == null || hrchg.getBLTO_COMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_NM(), strSymmetricKey));

                    nResult = hrIfDao.insertApiHRChgInfo (hrchgTmp);

                    //전송결과 결과 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", nResult > 0 ? "1" : "2" );
                    parameterMap.put("SND_STAT_MSG", nResult > 0 ? "SUCCESS" : "FAIL");
                    parameterMap.put("SND_JOB_CD", hrchgTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(hrchgTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(hrchgTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);

                }catch (Exception e) {

                    //전송결과 에러 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", "2" );
                    parameterMap.put("SND_STAT_MSG", e.getMessage());
                    parameterMap.put("SND_JOB_CD", hrchgTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(hrchgTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(hrchgTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);
                }

            }
        }
        log.info("API call End: OfficePostion Change History");

        //3.4.직책변경정보 요청
        log.info("API call Start: Responsibitity Change History");

        parameterMap = new HashMap<String, String>();
        requestUri = responsibilityChangeInfo;

        parameterMap.put("SND_STAT_CD", "1");
        parameterMap.put("SND_STAT_MSG", "SUCCESS");
        parameterMap.put("SND_JOB_CD", "H01");
        parameterMap.put("SND_DATE", sdf.format(c1.getTime()));
        parameterMap.put("SND_SEQ", "1");
        parameterMap.put("SND_SYS_DST_CD", "IBIZ");
        parameterMap.put("DATA_CHG_DST_CD", "C");
        parameterMap.put("EMP_ID", strIfAccountEmpId);
        parameterMap.put("PASSWD", secu.RSAEncrypt(strIfAccountPw, strPublickKey));
        parameterMap.put("SYMMETRIC_KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

        ifhrChangeArry  = restTemplate.postForObject(requestUri, parameterMap, IFHRChangeInfoVO[].class);

        if(ifhrChangeArry[0].getSND_STAT_CD().trim().equals("1"))
        {
            nResult = 0;

            for(IFHRChangeInfoVO hrchg : ifhrChangeArry)
            {
                IFHRChangeInfoVO hrchgTmp = new IFHRChangeInfoVO();

                try {
                    //수신테이블 입력
                    hrchgTmp.setSND_JOB_CD(hrchg.getSND_JOB_CD() == null || hrchg.getSND_JOB_CD().length() == 0 ? "" : hrchg.getSND_JOB_CD());
                    hrchgTmp.setSND_DATE(hrchg.getSND_DATE() == null || hrchg.getSND_DATE().length() == 0 ? "" : hrchg.getSND_DATE());
                    hrchgTmp.setSND_SEQ(hrchg.getSND_SEQ() == null || hrchg.getSND_SEQ().length() == 0 ? "" : hrchg.getSND_SEQ());
                    hrchgTmp.setDATA_CHG_DST_CD(hrchg.getDATA_CHG_DST_CD() == null || hrchg.getDATA_CHG_DST_CD().length() == 0 ? "" : hrchg.getDATA_CHG_DST_CD());
                    hrchgTmp.setSND_SYS_DST_CD(hrchg.getSND_SYS_DST_CD() == null || hrchg.getSND_SYS_DST_CD().length() == 0 ? "" : hrchg.getSND_SYS_DST_CD());

                    hrchgTmp.setEMP_ID(hrchg.getEMP_ID() == null || hrchg.getEMP_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getEMP_ID(), strSymmetricKey));
                    hrchgTmp.setEMP_NM(hrchg.getEMP_NM() == null || hrchg.getEMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getEMP_NM(), strSymmetricKey));
                    hrchgTmp.setAVL_START_DATE(hrchg.getAVL_START_DATE() == null || hrchg.getAVL_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getAVL_START_DATE(), strSymmetricKey));
                    hrchgTmp.setAVL_END_DATE(hrchg.getAVL_END_DATE() == null || hrchg.getAVL_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getAVL_END_DATE(), strSymmetricKey));
                    hrchgTmp.setBLTO_DEPT_ID(hrchg.getBLTO_DEPT_ID() == null || hrchg.getBLTO_DEPT_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_DEPT_ID(), strSymmetricKey));
                    hrchgTmp.setBLTO_DEPT_NM(hrchg.getBLTO_DEPT_NM() == null || hrchg.getBLTO_DEPT_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_DEPT_NM(), strSymmetricKey));
                    hrchgTmp.setCNPS_DST_CD(hrchg.getCNPS_DST_CD() == null || hrchg.getCNPS_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNPS_DST_CD(), strSymmetricKey));
                    hrchgTmp.setCNPS_DST_CD_NM(hrchg.getCNPS_DST_CD_NM() == null || hrchg.getCNPS_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNPS_DST_CD_NM(), strSymmetricKey));
                    hrchgTmp.setCC_ID(hrchg.getCC_ID() == null || hrchg.getCC_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCC_ID(), strSymmetricKey));
                    hrchgTmp.setCC_NM(hrchg.getCC_NM() == null || hrchg.getCC_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCC_NM(), strSymmetricKey));
                    hrchgTmp.setOFPS_CD(hrchg.getOFPS_CD() == null || hrchg.getOFPS_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getOFPS_CD(), strSymmetricKey));
                    hrchgTmp.setOFPS_CD_NM(hrchg.getOFPS_CD_NM() == null || hrchg.getOFPS_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getOFPS_CD_NM(), strSymmetricKey));
                    hrchgTmp.setRESO_CD(hrchg.getRESO_CD() == null || hrchg.getRESO_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRESO_CD(), strSymmetricKey));
                    hrchgTmp.setRESO_CD_NM(hrchg.getRESO_CD_NM() == null || hrchg.getRESO_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRESO_CD_NM(), strSymmetricKey));
                    hrchgTmp.setRECRT_DST_CD(hrchg.getRECRT_DST_CD() == null || hrchg.getRECRT_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRECRT_DST_CD(), strSymmetricKey));
                    hrchgTmp.setRECRT_DST_CD_NM(hrchg.getRECRT_DST_CD_NM() == null || hrchg.getRECRT_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRECRT_DST_CD_NM(), strSymmetricKey));
                    hrchgTmp.setHDOC_STAT_DTL_CD(hrchg.getHDOC_STAT_DTL_CD() == null || hrchg.getHDOC_STAT_DTL_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getHDOC_STAT_DTL_CD(), strSymmetricKey));
                    hrchgTmp.setHDOC_STAT_DTL_CD_NM(hrchg.getHDOC_STAT_DTL_CD_NM() == null || hrchg.getHDOC_STAT_DTL_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getHDOC_STAT_DTL_CD_NM(), strSymmetricKey));
                    hrchgTmp.setCNTR_START_DATE(hrchg.getCNTR_START_DATE() == null || hrchg.getCNTR_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNTR_START_DATE(), strSymmetricKey));
                    hrchgTmp.setCNTR_END_DATE(hrchg.getCNTR_END_DATE() == null || hrchg.getCNTR_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNTR_END_DATE(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_CD(hrchg.getBLTO_COMP_CD() == null || hrchg.getBLTO_COMP_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_CD(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_NM(hrchg.getBLTO_COMP_NM() == null || hrchg.getBLTO_COMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_NM(), strSymmetricKey));

                    nResult = hrIfDao.insertApiHRChgInfo (hrchgTmp);

                    //전송결과 결과 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", nResult > 0 ? "1" : "2" );
                    parameterMap.put("SND_STAT_MSG", nResult > 0 ? "SUCCESS" : "FAIL");
                    parameterMap.put("SND_JOB_CD", hrchgTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(hrchgTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(hrchgTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);

                }catch (Exception e) {

                    //전송결과 에러 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", "2" );
                    parameterMap.put("SND_STAT_MSG", e.getMessage());
                    parameterMap.put("SND_JOB_CD", hrchgTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(hrchgTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(hrchgTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);
                }

            }
        }
        log.info("API call End: Responsibitity Change History");

        //3.5.재직상태변경 요청
        log.info("API call Start: Recruit Change History");

        parameterMap = new HashMap<String, String>();
        requestUri = recruitChangeInfo;

        parameterMap.put("SND_STAT_CD", "1");
        parameterMap.put("SND_STAT_MSG", "SUCCESS");
        parameterMap.put("SND_JOB_CD", "H01");
        parameterMap.put("SND_DATE", sdf.format(c1.getTime()));
        parameterMap.put("SND_SEQ", "1");
        parameterMap.put("SND_SYS_DST_CD", "IBIZ");
        parameterMap.put("DATA_CHG_DST_CD", "C");
        parameterMap.put("EMP_ID", strIfAccountEmpId);
        parameterMap.put("PASSWD", secu.RSAEncrypt(strIfAccountPw, strPublickKey));
        parameterMap.put("SYMMETRIC_KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

        ifhrChangeArry  = restTemplate.postForObject(requestUri, parameterMap, IFHRChangeInfoVO[].class);

        if(ifhrChangeArry[0].getSND_STAT_CD().trim().equals("1"))
        {
            nResult = 0;

            for(IFHRChangeInfoVO hrchg : ifhrChangeArry)
            {
                IFHRChangeInfoVO hrchgTmp = new IFHRChangeInfoVO();

                try {
                    //수신테이블 입력
                    hrchgTmp.setSND_JOB_CD(hrchg.getSND_JOB_CD() == null || hrchg.getSND_JOB_CD().length() == 0 ? "" : hrchg.getSND_JOB_CD());
                    hrchgTmp.setSND_DATE(hrchg.getSND_DATE() == null || hrchg.getSND_DATE().length() == 0 ? "" : hrchg.getSND_DATE());
                    hrchgTmp.setSND_SEQ(hrchg.getSND_SEQ() == null || hrchg.getSND_SEQ().length() == 0 ? "" : hrchg.getSND_SEQ());
                    hrchgTmp.setDATA_CHG_DST_CD(hrchg.getDATA_CHG_DST_CD() == null || hrchg.getDATA_CHG_DST_CD().length() == 0 ? "" : hrchg.getDATA_CHG_DST_CD());
                    hrchgTmp.setSND_SYS_DST_CD(hrchg.getSND_SYS_DST_CD() == null || hrchg.getSND_SYS_DST_CD().length() == 0 ? "" : hrchg.getSND_SYS_DST_CD());
                    hrchgTmp.setEMP_ID(hrchg.getEMP_ID() == null || hrchg.getEMP_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getEMP_ID(), strSymmetricKey));
                    hrchgTmp.setEMP_NM(hrchg.getEMP_NM() == null || hrchg.getEMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getEMP_NM(), strSymmetricKey));
                    hrchgTmp.setAVL_START_DATE(hrchg.getAVL_START_DATE() == null || hrchg.getAVL_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getAVL_START_DATE(), strSymmetricKey));
                    hrchgTmp.setAVL_END_DATE(hrchg.getAVL_END_DATE() == null || hrchg.getAVL_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getAVL_END_DATE(), strSymmetricKey));
                    hrchgTmp.setBLTO_DEPT_ID(hrchg.getBLTO_DEPT_ID() == null || hrchg.getBLTO_DEPT_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_DEPT_ID(), strSymmetricKey));
                    hrchgTmp.setBLTO_DEPT_NM(hrchg.getBLTO_DEPT_NM() == null || hrchg.getBLTO_DEPT_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_DEPT_NM(), strSymmetricKey));
                    hrchgTmp.setCNPS_DST_CD(hrchg.getCNPS_DST_CD() == null || hrchg.getCNPS_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNPS_DST_CD(), strSymmetricKey));
                    hrchgTmp.setCNPS_DST_CD_NM(hrchg.getCNPS_DST_CD_NM() == null || hrchg.getCNPS_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNPS_DST_CD_NM(), strSymmetricKey));
                    hrchgTmp.setCC_ID(hrchg.getCC_ID() == null || hrchg.getCC_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCC_ID(), strSymmetricKey));
                    hrchgTmp.setCC_NM(hrchg.getCC_NM() == null || hrchg.getCC_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCC_NM(), strSymmetricKey));
                    hrchgTmp.setOFPS_CD(hrchg.getOFPS_CD() == null || hrchg.getOFPS_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getOFPS_CD(), strSymmetricKey));
                    hrchgTmp.setOFPS_CD_NM(hrchg.getOFPS_CD_NM() == null || hrchg.getOFPS_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getOFPS_CD_NM(), strSymmetricKey));
                    hrchgTmp.setRESO_CD(hrchg.getRESO_CD() == null || hrchg.getRESO_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRESO_CD(), strSymmetricKey));
                    hrchgTmp.setRESO_CD_NM(hrchg.getRESO_CD_NM() == null || hrchg.getRESO_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRESO_CD_NM(), strSymmetricKey));
                    hrchgTmp.setRECRT_DST_CD(hrchg.getRECRT_DST_CD() == null || hrchg.getRECRT_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRECRT_DST_CD(), strSymmetricKey));
                    hrchgTmp.setRECRT_DST_CD_NM(hrchg.getRECRT_DST_CD_NM() == null || hrchg.getRECRT_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRECRT_DST_CD_NM(), strSymmetricKey));
                    hrchgTmp.setHDOC_STAT_DTL_CD(hrchg.getHDOC_STAT_DTL_CD() == null || hrchg.getHDOC_STAT_DTL_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getHDOC_STAT_DTL_CD(), strSymmetricKey));
                    hrchgTmp.setHDOC_STAT_DTL_CD_NM(hrchg.getHDOC_STAT_DTL_CD_NM() == null || hrchg.getHDOC_STAT_DTL_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getHDOC_STAT_DTL_CD_NM(), strSymmetricKey));
                    hrchgTmp.setCNTR_START_DATE(hrchg.getCNTR_START_DATE() == null || hrchg.getCNTR_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNTR_START_DATE(), strSymmetricKey));
                    hrchgTmp.setCNTR_END_DATE(hrchg.getCNTR_END_DATE() == null || hrchg.getCNTR_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNTR_END_DATE(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_CD(hrchg.getBLTO_COMP_CD() == null || hrchg.getBLTO_COMP_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_CD(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_NM(hrchg.getBLTO_COMP_NM() == null || hrchg.getBLTO_COMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_NM(), strSymmetricKey));

                    nResult = hrIfDao.insertApiHRChgInfo (hrchgTmp);

                    //전송결과 결과 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", nResult > 0 ? "1" : "2" );
                    parameterMap.put("SND_STAT_MSG", nResult > 0 ? "SUCCESS" : "FAIL");
                    parameterMap.put("SND_JOB_CD", hrchgTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(hrchgTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(hrchgTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);

                }catch (Exception e) {

                    //전송결과 에러 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", "2" );
                    parameterMap.put("SND_STAT_MSG", e.getMessage());
                    parameterMap.put("SND_JOB_CD", hrchgTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(hrchgTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(hrchgTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);
                }

            }
        }
        log.info("API call End: Recruit Change History");

        //3.6.고용상태변경 요청
        log.info("API call Start: Employment Status Change History");

        parameterMap = new HashMap<String, String>();
        requestUri = empStatusInfo;

        parameterMap.put("SND_STAT_CD", "1");
        parameterMap.put("SND_STAT_MSG", "SUCCESS");
        parameterMap.put("SND_JOB_CD", "H01");
        parameterMap.put("SND_DT", sdf.format(c1.getTime()));
        parameterMap.put("SND_SEQ", "1");
        parameterMap.put("SND_SYS_DST_CD", "IBIZ");
        parameterMap.put("DATA_CHG_DST_CD", "C");
        parameterMap.put("EMP_ID", strIfAccountEmpId);
        parameterMap.put("PASSWD", secu.RSAEncrypt(strIfAccountPw, strPublickKey));
        parameterMap.put("SYMMETRIC_KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

        ifhrChangeArry  = restTemplate.postForObject(requestUri, parameterMap, IFHRChangeInfoVO[].class);

        if(ifhrChangeArry[0].getSND_STAT_CD().trim().equals("1"))
        {
            nResult = 0;

            for(IFHRChangeInfoVO hrchg : ifhrChangeArry)
            {
                IFHRChangeInfoVO hrchgTmp = new IFHRChangeInfoVO();

                try {
                    //수신테이블 입력
                    hrchgTmp.setSND_JOB_CD(hrchg.getSND_JOB_CD() == null || hrchg.getSND_JOB_CD().length() == 0 ? "" : hrchg.getSND_JOB_CD());
                    hrchgTmp.setSND_DATE(hrchg.getSND_DATE() == null || hrchg.getSND_DATE().length() == 0 ? "" : hrchg.getSND_DATE());
                    hrchgTmp.setSND_SEQ(hrchg.getSND_SEQ() == null || hrchg.getSND_SEQ().length() == 0 ? "" : hrchg.getSND_SEQ());
                    hrchgTmp.setDATA_CHG_DST_CD(hrchg.getDATA_CHG_DST_CD() == null || hrchg.getDATA_CHG_DST_CD().length() == 0 ? "" : hrchg.getDATA_CHG_DST_CD());
                    hrchgTmp.setSND_SYS_DST_CD(hrchg.getSND_SYS_DST_CD() == null || hrchg.getSND_SYS_DST_CD().length() == 0 ? "" : hrchg.getSND_SYS_DST_CD());

                    hrchgTmp.setEMP_ID(hrchg.getEMP_ID() == null || hrchg.getEMP_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getEMP_ID(), strSymmetricKey));
                    hrchgTmp.setEMP_NM(hrchg.getEMP_NM() == null || hrchg.getEMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getEMP_NM(), strSymmetricKey));
                    hrchgTmp.setAVL_START_DATE(hrchg.getAVL_START_DATE() == null || hrchg.getAVL_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getAVL_START_DATE(), strSymmetricKey));
                    hrchgTmp.setAVL_END_DATE(hrchg.getAVL_END_DATE() == null || hrchg.getAVL_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getAVL_END_DATE(), strSymmetricKey));
                    hrchgTmp.setBLTO_DEPT_ID(hrchg.getBLTO_DEPT_ID() == null || hrchg.getBLTO_DEPT_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_DEPT_ID(), strSymmetricKey));
                    hrchgTmp.setBLTO_DEPT_NM(hrchg.getBLTO_DEPT_NM() == null || hrchg.getBLTO_DEPT_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_DEPT_NM(), strSymmetricKey));
                    hrchgTmp.setCNPS_DST_CD(hrchg.getCNPS_DST_CD() == null || hrchg.getCNPS_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNPS_DST_CD(), strSymmetricKey));
                    hrchgTmp.setCNPS_DST_CD_NM(hrchg.getCNPS_DST_CD_NM() == null || hrchg.getCNPS_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNPS_DST_CD_NM(), strSymmetricKey));
                    hrchgTmp.setCC_ID(hrchg.getCC_ID() == null || hrchg.getCC_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCC_ID(), strSymmetricKey));
                    hrchgTmp.setCC_NM(hrchg.getCC_NM() == null || hrchg.getCC_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCC_NM(), strSymmetricKey));
                    hrchgTmp.setOFPS_CD(hrchg.getOFPS_CD() == null || hrchg.getOFPS_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getOFPS_CD(), strSymmetricKey));
                    hrchgTmp.setOFPS_CD_NM(hrchg.getOFPS_CD_NM() == null || hrchg.getOFPS_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getOFPS_CD_NM(), strSymmetricKey));
                    hrchgTmp.setRESO_CD(hrchg.getRESO_CD() == null || hrchg.getRESO_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRESO_CD(), strSymmetricKey));
                    hrchgTmp.setRESO_CD_NM(hrchg.getRESO_CD_NM() == null || hrchg.getRESO_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRESO_CD_NM(), strSymmetricKey));
                    hrchgTmp.setRECRT_DST_CD(hrchg.getRECRT_DST_CD() == null || hrchg.getRECRT_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRECRT_DST_CD(), strSymmetricKey));
                    hrchgTmp.setRECRT_DST_CD_NM(hrchg.getRECRT_DST_CD_NM() == null || hrchg.getRECRT_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRECRT_DST_CD_NM(), strSymmetricKey));
                    hrchgTmp.setHDOC_STAT_DTL_CD(hrchg.getHDOC_STAT_DTL_CD() == null || hrchg.getHDOC_STAT_DTL_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getHDOC_STAT_DTL_CD(), strSymmetricKey));
                    hrchgTmp.setHDOC_STAT_DTL_CD_NM(hrchg.getHDOC_STAT_DTL_CD_NM() == null || hrchg.getHDOC_STAT_DTL_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getHDOC_STAT_DTL_CD_NM(), strSymmetricKey));
                    hrchgTmp.setCNTR_START_DATE(hrchg.getCNTR_START_DATE() == null || hrchg.getCNTR_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNTR_START_DATE(), strSymmetricKey));
                    hrchgTmp.setCNTR_END_DATE(hrchg.getCNTR_END_DATE() == null || hrchg.getCNTR_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNTR_END_DATE(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_CD(hrchg.getBLTO_COMP_CD() == null || hrchg.getBLTO_COMP_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_CD(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_NM(hrchg.getBLTO_COMP_NM() == null || hrchg.getBLTO_COMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_NM(), strSymmetricKey));

                    nResult = hrIfDao.insertApiHRChgInfo (hrchgTmp);

                    //전송결과 결과 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", nResult > 0 ? "1" : "2" );
                    parameterMap.put("SND_STAT_MSG", nResult > 0 ? "SUCCESS" : "FAIL");
                    parameterMap.put("SND_JOB_CD", hrchgTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(hrchgTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(hrchgTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);

                }catch (Exception e) {

                    //전송결과 에러 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", "2" );
                    parameterMap.put("SND_STAT_MSG", e.getMessage());
                    parameterMap.put("SND_JOB_CD", hrchgTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(hrchgTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(hrchgTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);
                }

            }
        }
        log.info("API call End: Employment Status Change History");

        //3.7.계약기간변경정보 요청
        log.info("API call Start: Contract Date Change History");

        parameterMap = new HashMap<String, String>();
        requestUri = contDateChangeInfo;

        parameterMap.put("SND_STAT_CD", "1");
        parameterMap.put("SND_STAT_MSG", "SUCCESS");
        parameterMap.put("SND_JOB_CD", "H01");
        parameterMap.put("SND_DATE", sdf.format(c1.getTime()));
        parameterMap.put("SND_SEQ", "1");
        parameterMap.put("SND_SYS_DST_CD", "IBIZ");
        parameterMap.put("DATA_CHG_DST_CD", "C");
        parameterMap.put("EMP_ID", strIfAccountEmpId);
        parameterMap.put("PASSWD", secu.RSAEncrypt(strIfAccountPw, strPublickKey));
        parameterMap.put("SYMMETRIC_KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

        ifhrChangeArry  = restTemplate.postForObject(requestUri, parameterMap, IFHRChangeInfoVO[].class);

        if(ifhrChangeArry[0].getSND_STAT_CD().trim().equals("1"))
        {
            nResult = 0;

            for(IFHRChangeInfoVO hrchg : ifhrChangeArry)
            {
                IFHRChangeInfoVO hrchgTmp = new IFHRChangeInfoVO();

                try {
                    //수신테이블 입력
                    hrchgTmp.setSND_JOB_CD(hrchg.getSND_JOB_CD() == null || hrchg.getSND_JOB_CD().length() == 0 ? "" : hrchg.getSND_JOB_CD());
                    hrchgTmp.setSND_DATE(hrchg.getSND_DATE() == null || hrchg.getSND_DATE().length() == 0 ? "" : hrchg.getSND_DATE());
                    hrchgTmp.setSND_SEQ(hrchg.getSND_SEQ() == null || hrchg.getSND_SEQ().length() == 0 ? "" : hrchg.getSND_SEQ());
                    hrchgTmp.setDATA_CHG_DST_CD(hrchg.getDATA_CHG_DST_CD() == null || hrchg.getDATA_CHG_DST_CD().length() == 0 ? "" : hrchg.getDATA_CHG_DST_CD());
                    hrchgTmp.setSND_SYS_DST_CD(hrchg.getSND_SYS_DST_CD() == null || hrchg.getSND_SYS_DST_CD().length() == 0 ? "" : hrchg.getSND_SYS_DST_CD());

                    hrchgTmp.setEMP_ID(hrchg.getEMP_ID() == null || hrchg.getEMP_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getEMP_ID(), strSymmetricKey));
                    hrchgTmp.setEMP_NM(hrchg.getEMP_NM() == null || hrchg.getEMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getEMP_NM(), strSymmetricKey));
                    hrchgTmp.setAVL_START_DATE(hrchg.getAVL_START_DATE() == null || hrchg.getAVL_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getAVL_START_DATE(), strSymmetricKey));
                    hrchgTmp.setAVL_END_DATE(hrchg.getAVL_END_DATE() == null || hrchg.getAVL_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getAVL_END_DATE(), strSymmetricKey));
                    hrchgTmp.setBLTO_DEPT_ID(hrchg.getBLTO_DEPT_ID() == null || hrchg.getBLTO_DEPT_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_DEPT_ID(), strSymmetricKey));
                    hrchgTmp.setBLTO_DEPT_NM(hrchg.getBLTO_DEPT_NM() == null || hrchg.getBLTO_DEPT_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_DEPT_NM(), strSymmetricKey));
                    hrchgTmp.setCNPS_DST_CD(hrchg.getCNPS_DST_CD() == null || hrchg.getCNPS_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNPS_DST_CD(), strSymmetricKey));
                    hrchgTmp.setCNPS_DST_CD_NM(hrchg.getCNPS_DST_CD_NM() == null || hrchg.getCNPS_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNPS_DST_CD_NM(), strSymmetricKey));
                    hrchgTmp.setCC_ID(hrchg.getCC_ID() == null || hrchg.getCC_ID().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCC_ID(), strSymmetricKey));
                    hrchgTmp.setCC_NM(hrchg.getCC_NM() == null || hrchg.getCC_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCC_NM(), strSymmetricKey));
                    hrchgTmp.setOFPS_CD(hrchg.getOFPS_CD() == null || hrchg.getOFPS_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getOFPS_CD(), strSymmetricKey));
                    hrchgTmp.setOFPS_CD_NM(hrchg.getOFPS_CD_NM() == null || hrchg.getOFPS_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getOFPS_CD_NM(), strSymmetricKey));
                    hrchgTmp.setRESO_CD(hrchg.getRESO_CD() == null || hrchg.getRESO_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRESO_CD(), strSymmetricKey));
                    hrchgTmp.setRESO_CD_NM(hrchg.getRESO_CD_NM() == null || hrchg.getRESO_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRESO_CD_NM(), strSymmetricKey));
                    hrchgTmp.setRECRT_DST_CD(hrchg.getRECRT_DST_CD() == null || hrchg.getRECRT_DST_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRECRT_DST_CD(), strSymmetricKey));
                    hrchgTmp.setRECRT_DST_CD_NM(hrchg.getRECRT_DST_CD_NM() == null || hrchg.getRECRT_DST_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getRECRT_DST_CD_NM(), strSymmetricKey));
                    hrchgTmp.setHDOC_STAT_DTL_CD(hrchg.getHDOC_STAT_DTL_CD() == null || hrchg.getHDOC_STAT_DTL_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getHDOC_STAT_DTL_CD(), strSymmetricKey));
                    hrchgTmp.setHDOC_STAT_DTL_CD_NM(hrchg.getHDOC_STAT_DTL_CD_NM() == null || hrchg.getHDOC_STAT_DTL_CD_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getHDOC_STAT_DTL_CD_NM(), strSymmetricKey));
                    hrchgTmp.setCNTR_START_DATE(hrchg.getCNTR_START_DATE() == null || hrchg.getCNTR_START_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNTR_START_DATE(), strSymmetricKey));
                    hrchgTmp.setCNTR_END_DATE(hrchg.getCNTR_END_DATE() == null || hrchg.getCNTR_END_DATE().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getCNTR_END_DATE(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_CD(hrchg.getBLTO_COMP_CD() == null || hrchg.getBLTO_COMP_CD().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_CD(), strSymmetricKey));
                    hrchgTmp.setBLTO_COMP_NM(hrchg.getBLTO_COMP_NM() == null || hrchg.getBLTO_COMP_NM().length() == 0 ? "" : secu.TripleDESDescrypt(hrchg.getBLTO_COMP_NM(), strSymmetricKey));

                    nResult = hrIfDao.insertApiHRChgInfo (hrchgTmp);

                    //전송결과 결과 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", nResult > 0 ? "1" : "2" );
                    parameterMap.put("SND_STAT_MSG", nResult > 0 ? "SUCCESS" : "FAIL");
                    parameterMap.put("SND_JOB_CD", hrchgTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(hrchgTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(hrchgTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);

                }catch (Exception e) {

                    //전송결과 에러 리턴
                    requestUri = returnResponse;

                    parameterMap = new HashMap<String, String>();

                    parameterMap.put("SND_STAT_CD", "2" );
                    parameterMap.put("SND_STAT_MSG", e.getMessage());
                    parameterMap.put("SND_JOB_CD", hrchgTmp.getSND_JOB_CD());
                    parameterMap.put("SND_DATE", secu.TripleDESEncrypt(hrchgTmp.getSND_DATE(), strSymmetricKey));
                    parameterMap.put("SND_SEQ", secu.TripleDESEncrypt(hrchgTmp.getSND_SEQ(), strSymmetricKey));
                    parameterMap.put("SND_SYS_DST_CD", "IBIZ");
                    parameterMap.put("DATA_CHG_DST_CD", "C");
                    parameterMap.put("REV_CD", secu.TripleDESEncrypt(nResult > 0 ? "1" : "2", strSymmetricKey) );
                    parameterMap.put("REV_MSG", secu.TripleDESEncrypt(nResult > 0 ? "SUCCESS" : "FAIL", strSymmetricKey));
                    parameterMap.put("KEY", secu.RSAEncrypt(strSymmetricKey, strPublickKey));

                    restTemplate.postForObject(requestUri, parameterMap, String.class);
                }

            }
        }

        log.info("API call End: Contract Date Change History");

        jsonObject.IsSucceed = true;

        return jsonObject;
    }
}
