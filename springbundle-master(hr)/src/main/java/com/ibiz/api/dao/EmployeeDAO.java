package com.ibiz.api.dao;

import com.ibiz.api.model.DeptHistoryVO;
import com.ibiz.api.model.EmployeeVO;
import com.ibiz.api.model.EmployeeVO;
import com.ibiz.api.model.ExcelEmployeeVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="employeeDAO")
public class EmployeeDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * SELECT : 사용자 기본정보 조회
     */
    public List<EmployeeVO> selectEmployeeInfo(EmployeeVO employeeVO) {
        return mybatis.selectList("EmployeeMapper.selectEmployeeInfo", employeeVO);
    }

    /**
     * @return
     * @throws Exception
     * @description 임직원 검색조건에 따른 조회
     */
    public List<EmployeeVO> selectEmployeeSearchList(EmployeeVO employeeVO) throws Exception {
        return mybatis.selectList("EmployeeMapper.selectEmployeeSearchList", employeeVO);
    }


    /*
     * SELECT : 사용자 기본정보 조회(엑셀)
     */
    public List<ExcelEmployeeVO> selectExcelDwnlEmployeeList(EmployeeVO employeeVO) throws Exception {
        return mybatis.selectList("EmployeeMapper.selectExcelDwnlEmployeeList", employeeVO);
    }


}
