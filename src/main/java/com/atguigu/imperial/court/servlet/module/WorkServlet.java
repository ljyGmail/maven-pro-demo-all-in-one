package com.atguigu.imperial.court.servlet.module;

import com.atguigu.imperial.court.entity.Memorials;
import com.atguigu.imperial.court.service.api.MemorialsService;
import com.atguigu.imperial.court.service.impl.MemorialsServiceImpl;
import com.atguigu.imperial.court.servlet.base.ModuleBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    protected void showMemorialsDigestList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 调用Service方法查询数据
        List<Memorials> memorialsList= memorialsService.getAllMemorialsDigest();

        // 2. 将查询得到的数据存入请求域
        request.setAttribute("memorialsList", memorialsList);

        // 3. 渲染视图
        String templateName = "memorials-list";
        processTemplate(templateName, request, response);
    }
}
