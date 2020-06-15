package com.ibiz.api.dao;

import com.ibiz.api.model.IFHRChangeInfoVO;
import com.ibiz.api.model.IFUserInfoResultVO;
import com.ibiz.api.model.IFUserInfoVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value="hrIfDao")
public class HrIfDao {

    @Autowired
    private SqlSessionTemplate mybatis;

    /**
     * select
     */

    public List<IFUserInfoResultVO> selectApiUserInfo() {
        return mybatis.selectList("HRIfMapper.Select_APIUserInfo");
    }

    public IFUserInfoResultVO selectRunUserInfoYN(IFUserInfoResultVO userInfo) {
        return mybatis.selectOne("HRIfMapper.Select_RunUserInfoYN", userInfo);
    }

    public IFUserInfoResultVO selectRunCustomerID(IFUserInfoResultVO userInfo) {
        return mybatis.selectOne("HRIfMapper.Select_RunCustomerID", userInfo);
    }


    /**
     * insert
     */

    public int insertApiUserInfo(IFUserInfoVO userInfo) {
        return mybatis.insert("HRIfMapper.Insert_ApiUserInfo", userInfo);
    }

    public int insertRunUserInfo(IFUserInfoResultVO userInfo) {
        return mybatis.insert("HRIfMapper.Insert_RunUserInfo", userInfo);
    }

    public int insertApiHRChgInfo(IFHRChangeInfoVO hrchginfo) {
        return mybatis.insert("HRIfMapper.Insert_ApiHRChgInfo", hrchginfo);
    }

    public int insertUserAuthForDept(IFUserInfoResultVO userInfo){
        return mybatis.insert("HRIfMapper.Insert_UserAuthForDept", userInfo);
    }

    public int insesrtUserSystem(IFUserInfoResultVO userInfo) {
        return mybatis.insert("HRIfMapper.Insert_UserSystem", userInfo);
    }

    public int insertRunCustomerBaseHistroy(IFUserInfoResultVO userInfo) {
        return mybatis.insert("HRIfMapper.Insert_RunCustomerBaseHistory", userInfo);
    }

    public int insertRunCustomerBase(IFUserInfoResultVO userInfo) {
        return mybatis.insert("HRIfMapper.Insert_RunCustomerBase", userInfo);
    }

    public int insertRunCustomerRole(IFUserInfoResultVO userInfo) {
        return mybatis.insert("HRIfMapper.Insert_RunCustomerRole", userInfo);
    }

    public int insertRunCustomerContactForCompTelNo(IFUserInfoResultVO userInfo) {
        return mybatis.insert("HRIfMapper.Insert_RunCustomerContactForCompTelNo", userInfo);
    }

    public int insertRunCustomerContactForMbphNo(IFUserInfoResultVO userInfo) {
        return mybatis.insert("HRIfMapper.Insert_RunCustomerContactForMbphNo", userInfo);
    }

    public int insertRunCustomerContactForEmlAdrs(IFUserInfoResultVO userInfo) {
        return mybatis.insert("HRIfMapper.Insert_RunCustomerContactForEmlAdrs", userInfo);
    }

    public int insertRunCustomerRelation(IFUserInfoResultVO userInfo) {
        return mybatis.insert("HRIfMapper.Insert_RunCustomerRelation", userInfo);
    }

    /**
     * update
     */

    public int updateApiUserInfo(IFUserInfoResultVO userInfo) {
        return mybatis.update("HRIfMapper.Update_ApiUserInfo", userInfo);
    }

    public int updateRunUserInfo(IFUserInfoResultVO userInfo) {
        return mybatis.update("HRIfMapper.Update_RuniUserInfo", userInfo);
    }

    public int updateUserAuthForDept(IFUserInfoResultVO userInfo) {
        return mybatis.update("HRIfMapper.Update_UserAuthForDept", userInfo);
    }

    public int updateUserAuthForAll(IFUserInfoResultVO userInfo) {
        return mybatis.update("HRIfMapper.Update_UserAuthForAll", userInfo);
    }

    public int updateUserSystem(IFUserInfoResultVO userInfo) {
        return mybatis.update("HRIfMapper.Update_UserSystem", userInfo);
    }

    public int updateRunCustomerBase(IFUserInfoResultVO userInfo) {
        return mybatis.update("HRIfMapper.Update_RunCustomerBase", userInfo);
    }

    public int updateRunCustomerRole(IFUserInfoResultVO userInfo) {
        return mybatis.update("HRIfMapper.Update_RunCustomerRole", userInfo);
    }

    public int updateRunCustomerContactForCompTelNo(IFUserInfoResultVO userInfo) {
        return mybatis.update("HRIfMapper.Update_RunCustomerContactForCompTelNo", userInfo);
    }

    public int updateRunCustomerContactForMbphNo(IFUserInfoResultVO userInfo) {
        return mybatis.update("HRIfMapper.Update_RunCustomerContactForMbphNo", userInfo);
    }

    public int updateRunCustomerContactForEmlAdrs(IFUserInfoResultVO userInfo) {
        return mybatis.update("HRIfMapper.Update_RunCustomerContactForEmlAdrs", userInfo);
    }

    public int updateRunCustomerRelation(IFUserInfoResultVO userInfo) {
        return mybatis.update("HRIfMapper.Update_RunCustomerRelation", userInfo);
    }
}
