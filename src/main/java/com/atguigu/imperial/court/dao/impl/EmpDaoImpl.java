package com.atguigu.imperial.court.dao.impl;

import com.atguigu.imperial.court.dao.BaseDao;
import com.atguigu.imperial.court.dao.api.EmpDao;
import com.atguigu.imperial.court.entity.Emp;

/**
 * ClassName: EmpDaoImpl
 * Package: com.atguigu.imperial.court.dao.impl
 * Description:
 *
 * @Author ljy
 * @Create 2025-04-28 오후 3:29
 * @Version 1.0
 */
public class EmpDaoImpl extends BaseDao<Emp> implements EmpDao {

    @Override
    public Emp selectEmpByLoginAccount(String loginAccount, String encodedLoginPassword) {
        // 1. 编写SQL语句
        String sql = "select emp_id empId, " +
                "emp_name empName, " +
                "emp_position empPosition, " +
                "login_account loginAccount, " +
                "login_password loginPassword " +
                "FROM t_emp WHERE login_account = ? and login_password = ?";

        // 2. 调用父类方法查询单个对象
        return getSingleBean(sql, Emp.class, loginAccount, encodedLoginPassword);
    }
}
