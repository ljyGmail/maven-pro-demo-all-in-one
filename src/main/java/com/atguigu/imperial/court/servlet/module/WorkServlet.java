package com.atguigu.imperial.court.servlet.module;

import com.atguigu.imperial.court.service.api.MemorialsService;
import com.atguigu.imperial.court.service.impl.MemorialsServiceImpl;
import com.atguigu.imperial.court.servlet.base.ModuleBaseServlet;

/**
 * ClassName: WorkServlet
 * Package: com.atguigu.imperial.court.servlet.module
 * Description:
 *
 * @Author ljy
 * @Create 2025. 4. 29. 오후 2:58
 * @Version 1.0
 */
public class WorkServlet extends ModuleBaseServlet {

    private MemorialsService memorialsService = new MemorialsServiceImpl();
}
