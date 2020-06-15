package com.ibiz.api.dao;

import com.ibiz.api.model.DeptVO;
import com.ibiz.api.model.EmpVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="CmnDao")
public class CmnDao {
    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * 부서 관련 CRUD
     */

    /**
     * @return
     * @throws Exception
     * @description 부서명 조회 All
     */
    public List<DeptVO> selectAllDeptList(DeptVO deptVO) throws Exception {
        return mybatis.selectList("CmnMapper.Select_AllDeptList", deptVO);

    }

    /**
     * @return
     * @throws Exception
     * @description 권한별 부서 조회
     */
    // dept삭제코드
/*	public List<DeptVO> selectAuthDeptList(Map<String, Object> param) throws Exception {
		return mybatis.selectList(MAPPER_PATH + "CmnMapper.Select_AuthDeptList", param);
	}*/
    public List<DeptVO> selectAuthDeptList(DeptVO deptVO) throws Exception {
        return mybatis.selectList("CmnMapper.Select_AuthDeptList", deptVO);
    }

    /**
     * @return
     * @throws Exception
     * @description 부서명 검색조건에 따른 하위 부서 리스트(최상)
     */
    public List<DeptVO> selectDeptSearchMaxLowerList(DeptVO deptVO) throws Exception {
        return mybatis.selectList("CmnMapper.Select_DeptSearchMaxLowerList", deptVO);
    }

    /**
     * @return
     * @throws Exception
     * @description 부서명 검색조건에 따른 조회
     */
    public List<DeptVO> selectDeptSearchList(DeptVO deptVO) throws Exception {
        return mybatis.selectList("CmnMapper.Select_DeptSearchList", deptVO);
    }

    /**
     * @return
     * @throws Exception
     * @description 현 부서 하위부서 존재여부 조회
     */
    public DeptVO selectIsLowerDept(DeptVO deptVO) throws Exception {
        return mybatis.selectOne("CmnMapper.Select_IsLowerDept", deptVO);
    }


    /*
     * 임직원 관련 CRUD
     */

    public EmpVO selectHddpEmp(DeptVO deptVO) {
        return mybatis.selectOne("CmnMapper.Select_hddpEmp", deptVO);
    }

    /**
     * @return
     * @throws Exception
     * @description 임직원 검색조건에 따른 조회
     */
    public List<EmpVO> selectEMPSearchList(EmpVO empVO) throws Exception {
        return mybatis.selectList("CmnMapper.Select_EMPSearchList", empVO);
    }
    /**
     * @return
     * @throws Exception
     * @description 임직원 검색조건에 따른 조회 카운트
     */
    public EmpVO selectEMPSearchListCount(EmpVO empVO) throws Exception {
        return mybatis.selectOne("CmnMapper.Select_EMPSearchListCount", empVO);
    }

    /**
     * @return
     * @description  영업대표에 따른 수정삭제권한체크
     */
    public DeptVO selectIsAuthBySlsEmp(DeptVO deptVO) throws Exception{
        return mybatis.selectOne("CmnMapper.Select_IsAuthBySlsEmp",deptVO);
    }

    /**
     * @return
     * @description 고객 정보 조회
     */
    public EmpVO selectEmpInfo (EmpVO empVO) throws Exception{
        return mybatis.selectOne("CmnMapper.Select_EMPInfo",empVO);
    }


    /**
     * @return
     * @description  최상위 부서정보조회
     */
    public DeptVO selectHTRKDeptInfo(){
        return mybatis.selectOne("CmnMapper.Select_HTRKDeptInfo");
    }
}
