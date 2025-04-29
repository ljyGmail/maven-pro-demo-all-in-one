package com.atguigu.imperial.court.service.api;

import com.atguigu.imperial.court.entity.Emp;

/**
 * ClassName: EmpService
 * Package: com.atguigu.imperial.court.service.api
 * Description:
 *
 * @Author ljy
 * @Create 2025-04-29 오전 10:11
 * @Version 1.0
 */
public interface EmpService {
    Emp getEmpByLoginAccount(String loginAccount, String loginPassword);
}
