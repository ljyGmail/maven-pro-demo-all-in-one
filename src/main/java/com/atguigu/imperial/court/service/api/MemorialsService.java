package com.atguigu.imperial.court.service.api;

import com.atguigu.imperial.court.dao.api.MemorialsDao;
import com.atguigu.imperial.court.dao.impl.MemorialsDaoImpl;
import com.atguigu.imperial.court.entity.Memorials;

import java.util.List;

/**
 * ClassName: MemorialsService
 * Package: com.atguigu.imperial.court.service.api
 * Description:
 *
 * @Author ljy
 * @Create 2025. 4. 29. 오후 3:00
 * @Version 1.0
 */
public interface MemorialsService {
    List<Memorials> getAllMemorialsDigest();

    Memorials getMemorialsDetailById(String memorialsId);

    void updateMemorialsStatusToRead(String memorialsId);
}
