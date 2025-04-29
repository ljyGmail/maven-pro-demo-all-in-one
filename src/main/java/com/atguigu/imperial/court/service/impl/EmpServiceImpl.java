package com.atguigu.imperial.court.service.impl;

import com.atguigu.imperial.court.dao.api.EmpDao;
import com.atguigu.imperial.court.dao.impl.EmpDaoImpl;
import com.atguigu.imperial.court.entity.Emp;
import com.atguigu.imperial.court.exception.LoginFailedException;
import com.atguigu.imperial.court.service.api.EmpService;
import com.atguigu.imperial.court.util.ImperialCourtConst;
import com.atguigu.imperial.court.util.MD5Util;

/**
 * ClassName: EmpServiceImpl
 * Package: com.atguigu.imperial.court.service.impl
 * Description:
 *
 * @Author ljy
 * @Create 2025-04-29 오전 10:12
 * @Version 1.0
 */
public class EmpServiceImpl implements EmpService {

    private EmpDao empDao = new EmpDaoImpl();

    @Override
    public Emp getEmpByLoginAccount(String loginAccount, String loginPassword) {
        // 1. 对密码执行加密
        String encodedLoginPassword = MD5Util.encode(loginPassword);

        // 2. 根据账户和加密密码查询数据库
        Emp emp = empDao.selectEmpByLoginAccount(loginAccount, encodedLoginPassword);

        // 3. 检查Emp对象是否为null
        if (emp != null) {
            // ① 不为null: 返回Emp
            return emp;
        } else {
            // ② 为null: 抛登录失败异常
            throw new LoginFailedException(ImperialCourtConst.LOGIN_FAILED_MESSAGE);
        }
    }
}
