package com.atguigu.imperial.court.servlet.module;

import com.atguigu.imperial.court.servlet.base.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: PortalServlet
 * Package: com.atguigu.imperial.court.servlet.module
 * Description:
 *
 * @Author ljy
 * @Create 2025-04-29 오전 9:37
 * @Version 1.0
 */
public class PortalServlet extends ViewBaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 声明要访问的首页的逻辑视图
        String templateName = "index";

        // 调用父类的方法，根据逻辑视图名称渲染视图
        processTemplate(templateName, req, resp);
    }
}
