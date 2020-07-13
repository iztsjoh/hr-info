package com.ibiz.api.dao;

import com.ibiz.api.model.EmployeeChangeIFVO;
import com.ibiz.api.model.EmployeeResultIFVO;
import com.ibiz.api.model.EmployeeIFVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="hrIFDAO")
public class HrIFDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    /**
     * select
     */

    public List<EmployeeResultIFVO> selectApiUserInfo() {
        return mybatis.selectList("HrIFMapper.selectApiUserInfo");
    }

    public EmployeeResultIFVO selectIsValidUserInfo(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.selectOne("HrIFMapper.selectIsValidUserInfo", ifEmployeeInfo);
    }

    public EmployeeResultIFVO selectCreateCustomerID(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.selectOne("HrIFMapper.selectCreateCustomerID", ifEmployeeInfo);
    }


    /**
     * insert
     */

    public int insertApiUserInfo(EmployeeIFVO ifEmployeeInfo) {
        return mybatis.insert("HrIFMapper.insertApiUserInfo", ifEmployeeInfo);
    }

    public int insertUserInfo(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.insert("HrIFMapper.insertUserInfo", ifEmployeeInfo);
    }

    public int insertApiHRChgInfo(EmployeeChangeIFVO hrchginfo) {
        return mybatis.insert("HrIFMapper.insertApiHRChgInfo", hrchginfo);
    }

    public int insertUserAuthForDept(EmployeeResultIFVO ifEmployeeInfo){
        return mybatis.insert("HrIFMapper.insertUserAuthForDept", ifEmployeeInfo);
    }

    public int insertUserSystem(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.insert("HrIFMapper.insertUserSystem", ifEmployeeInfo);
    }

    public int insertCustomerHistory(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.insert("HrIFMapper.insertCustomerHistory", ifEmployeeInfo);
    }

    public int insertCustomerInfo(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.insert("HrIFMapper.insertCustomerInfo", ifEmployeeInfo);
    }

    public int insertCustomerRole(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.insert("HrIFMapper.insertCustomerRole", ifEmployeeInfo);
    }

    public int insertCustomerContactNumber(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.insert("HrIFMapper.insertCustomerContactNumber", ifEmployeeInfo);
    }

    public int insertCustomerContactMobileNumber(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.insert("HrIFMapper.insertCustomerContactMobileNumber", ifEmployeeInfo);
    }

    public int insertCustomerContactEmlAdrs(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.insert("HrIFMapper.insertCustomerContactEmlAdrs", ifEmployeeInfo);
    }

    public int insertCustomerRelation(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.insert("HrIFMapper.insertCustomerRelation", ifEmployeeInfo);
    }

    /**
     * update
     */

    public int updateApiUserInfo(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.update("HrIFMapper.updateApiUserInfo", ifEmployeeInfo);
    }

    public int updateUserInfo(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.update("HrIFMapper.updateUserInfo", ifEmployeeInfo);
    }

    public int updateUserAuthForDept(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.update("HrIFMapper.updateUserAuthForDept", ifEmployeeInfo);
    }

    public int updateUserSystem(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.update("HrIFMapper.updateUserSystem", ifEmployeeInfo);
    }

    public int updateCustomerInfo(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.update("HrIFMapper.updateCustomerInfo", ifEmployeeInfo);
    }

    public int updateCustomerRole(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.update("HrIFMapper.updateCustomerRole", ifEmployeeInfo);
    }

    public int updateCustomerContactNumber(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.update("HrIFMapper.updateCustomerContactNumber", ifEmployeeInfo);
    }

    public int updateCustomerContactMobileNumber(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.update("HrIFMapper.updateCustomerContactMobileNumber", ifEmployeeInfo);
    }

    public int updateCustomerContactEmlAdrs(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.update("HrIFMapper.updateCustomerContactEmlAdrs", ifEmployeeInfo);
    }

    public int updateCustomerRelation(EmployeeResultIFVO ifEmployeeInfo) {
        return mybatis.update("HrIFMapper.updateCustomerRelation", ifEmployeeInfo);
    }
}
