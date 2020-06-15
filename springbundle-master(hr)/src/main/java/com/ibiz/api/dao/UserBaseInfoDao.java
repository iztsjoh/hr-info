package com.ibiz.api.dao;

import com.ibiz.api.model.DeptChgHisVO;
import com.ibiz.api.model.UserBaseInfoVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="userBaseInfoDao")
public class UserBaseInfoDao {

    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * SELECT : 사용자 기본정보 조회
     */
    public List<UserBaseInfoVO> selectUserBaseInfo(UserBaseInfoVO userbaseVo) {
        return mybatis.selectList("UserBaseInfoMapper.Select_userBaseInfoList", userbaseVo);
    }

    /*
     * SELECT : 사용자 기본정보 조회 카운트
     */
    public Integer selectUserBaseInfoCount(UserBaseInfoVO userbaseVo) {
        return mybatis.selectOne("UserBaseInfoMapper.Select_userBaseInfoListCount", userbaseVo);
    }


   /* *//*
     * SELECT : 사용자 기본정보 조회(엑셀)
     *//*
    public List<ExcelUserBaseInfoVO> selectExcelUserBaseInfo(UserBaseInfoVO userbaseVo) throws Exception {
        return mybatis.selectList(MAPPER_PATH + "UserBaseInfoMapper.Select_userExcelBaseInfoList", userbaseVo);
        //return null;
    }*/


    /*
     * SELECT : 인사조직 조회
     */
    public List<DeptChgHisVO> selectBltcDeptInfo(DeptChgHisVO deptchghisVo) throws Exception {
        return mybatis.selectList("UserBaseInfoMapper.Select_bltcDeptInfoList", deptchghisVo);
    }
}
