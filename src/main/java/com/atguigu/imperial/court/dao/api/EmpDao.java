package com.atguigu.imperial.court.dao.api;

import com.atguigu.imperial.court.entity.Emp;

/**
 * ClassName: EmpDao
 * Package: com.atguigu.imperial.court.dao.api
 * Description:
 *
 * @Author ljy
 * @Create 2025-04-28 오후 3:29
 * @Version 1.0
 */
public interface EmpDao {
    Emp selectEmpByLoginAccount(String loginAccount, String encodedLoginPassword);
}
