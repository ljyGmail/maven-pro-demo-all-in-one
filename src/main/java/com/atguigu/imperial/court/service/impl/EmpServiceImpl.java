package com.atguigu.imperial.court.service.impl;

import com.atguigu.imperial.court.dao.api.EmpDao;
import com.atguigu.imperial.court.dao.impl.EmpDaoImpl;
import com.atguigu.imperial.court.service.api.EmpService;

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

}
