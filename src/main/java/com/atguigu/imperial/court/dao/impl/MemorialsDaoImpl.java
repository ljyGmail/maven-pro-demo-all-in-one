package com.atguigu.imperial.court.dao.impl;

import com.atguigu.imperial.court.dao.BaseDao;
import com.atguigu.imperial.court.dao.api.MemorialsDao;
import com.atguigu.imperial.court.entity.Memorials;

import java.util.Collections;
import java.util.List;

/**
 * ClassName: MemorialsDaoImpl
 * Package: com.atguigu.imperial.court.dao.impl
 * Description:
 *
 * @Author ljy
 * @Create 2025-04-28 오후 3:30
 * @Version 1.0
 */
public class MemorialsDaoImpl extends BaseDao<Memorials> implements MemorialsDao {
    @Override
    public List<Memorials> selectAllMemorialsDigest() {

        String sql = "select memorials_id                               memorialsId,\n" +
                "       memorials_title                            memorialsTitle,\n" +
                "       concat(left(memorials_content, 10), '...') memorialsContentDigest,\n" +
                "       emp_name                                   memorialsEmpName,\n" +
                "       memorials_create_time                      memorialsCreateTime,\n" +
                "       memorials_status                           memorialsStatus\n" +
                "from t_memorials m\n" +
                "         left join t_emp e on m.memorials_emp = e.emp_id";

        return getBeanList(sql, Memorials.class);
    }
}
