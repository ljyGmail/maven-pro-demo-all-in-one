package com.atguigu.imperial.court.servlet.module;

import com.atguigu.imperial.court.servlet.base.ModuleBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: AuthServlet
 * Package: com.atguigu.imperial.court.servlet.module
 * Description:
 *
 * @Author ljy
 * @Create 2025-04-29 오전 10:06
 * @Version 1.0
 */
public class AuthServlet extends ModuleBaseServlet {

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 1. 获取请求参数

            // 2. 调用EmpService方法执行登录逻辑

            // 3. 调用EmpService方法执行登录逻辑

            // 4. 将查询到的Emp对象存入Session域

            // 5. 前往指定页面视图

        } catch (Exception e) {
            // 6. 判断此处捕获到的异常是否是登录失败异常

            // 7. 如果是登录失败异常则跳转回登录页面
            // ① 将异常信息存入请求域

            // ② 处理视图: index

            // 8. 如果不是登录异常则封装为运行时异常继续抛出
        }
    }
}
