package com.atguigu.imperial.court.servlet.module;

import com.atguigu.imperial.court.entity.Emp;
import com.atguigu.imperial.court.exception.LoginFailedException;
import com.atguigu.imperial.court.service.api.EmpService;
import com.atguigu.imperial.court.service.impl.EmpServiceImpl;
import com.atguigu.imperial.court.servlet.base.ModuleBaseServlet;
import com.atguigu.imperial.court.util.ImperialCourtConst;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    private EmpService empService = new EmpServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 1. 获取请求参数
            String loginAccount = request.getParameter("loginAccount");
            String loginPassword = request.getParameter("loginPassword");

            // 2. 调用EmpService方法执行登录逻辑
            Emp emp = empService.getEmpLoginAccount(loginAccount, loginPassword);

            // 3. 调用EmpService方法执行登录逻辑
            HttpSession session = request.getSession();

            // 4. 将查询到的Emp对象存入Session域
            session.setAttribute(ImperialCourtConst.LOGIN_EMP_ATTR_NAME, emp);

            // 5. 前往指定页面视图
            String templateName = "temp";
            processTemplate(templateName, request, response);

        } catch (Exception e) {
            // 6. 判断此处捕获到的异常是否是登录失败异常
            if (e instanceof LoginFailedException) {
                // 7. 如果是登录失败异常则跳转回登录页面
                // ① 将异常信息存入请求域
                request.setAttribute("message", e.getMessage());

                // ② 处理视图: index
                processTemplate("index",request,response);
            } else{
                // 8. 如果不是登录异常则封装为运行时异常继续抛出
                throw new RuntimeException(e);
            }
        }
    }
}
