package com.atguigu.imperial.court.dao.api;

import com.atguigu.imperial.court.entity.Memorials;

import java.util.List;

/**
 * ClassName: MemorialsDao
 * Package: com.atguigu.imperial.court.dao.api
 * Description:
 *
 * @Author ljy
 * @Create 2025-04-28 오후 3:30
 * @Version 1.0f
 */
public interface MemorialsDao {
    List<Memorials> selectAllMemorialsDigest();

    Memorials selectMemorialsById(String memorialsId);

    void updateMemorialsStatusToRead(String memorialsId);

    void updateMemorialsFeedBack(String memorialsId, String feedbackContent);
}
