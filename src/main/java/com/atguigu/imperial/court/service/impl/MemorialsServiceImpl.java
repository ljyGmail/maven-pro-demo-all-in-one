package com.atguigu.imperial.court.service.impl;

import com.atguigu.imperial.court.dao.api.MemorialsDao;
import com.atguigu.imperial.court.dao.impl.MemorialsDaoImpl;
import com.atguigu.imperial.court.entity.Memorials;
import com.atguigu.imperial.court.service.api.MemorialsService;

import java.util.Collections;
import java.util.List;

/**
 * ClassName: MemorialsServiceImpl
 * Package: com.atguigu.imperial.court.service.impl
 * Description:
 *
 * @Author ljy
 * @Create 2025. 4. 29. 오후 3:00
 * @Version 1.0
 */
public class MemorialsServiceImpl implements MemorialsService {

    private MemorialsDao memorialsDao = new MemorialsDaoImpl();

    @Override
    public List<Memorials> getAllMemorialsDigest() {
        return memorialsDao.selectAllMemorialsDigest();
    }

    @Override
    public Memorials getMemorialsDetailById(String memorialsId) {
        return memorialsDao.selectMemorialsById(memorialsId);
    }

    @Override
    public void updateMemorialsStatusToRead(String memorialsId) {
        memorialsDao.updateMemorialsStatusToRead(memorialsId);
    }
}
