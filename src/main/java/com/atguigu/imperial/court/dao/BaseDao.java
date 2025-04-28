package com.atguigu.imperial.court.dao;

import com.atguigu.imperial.court.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * ClassName: BaseDao
 * Package: com.atguigu.imperial.court.dao
 * Description:
 * <p>
 * BaseDao类: 素有Dao实现类的基类
 *
 * @param <T> 实体类的类型
 * @Author ljy
 * @Create 2025-04-28 오후 2:56
 * @Version 1.0
 */
public class BaseDao<T> {

    // DBUtils工具包提供的数据库操作对象
    private QueryRunner runner = new QueryRunner();

    /**
     * 查询返回多个对象的方法
     *
     * @param sql         执行查询操作的SQL语句
     * @param entityClass 实体类的Class对象
     * @param parameters  SQL语句的参数
     * @return 查询结果
     */
    public List<T> getBeanList(String sql, Class<T> entityClass, Object... parameters) {
        try {
            // 获取数据库连接
            Connection connection = JDBCUtils.getConnection();

            return runner.query(connection, sql, new BeanListHandler<>(entityClass), parameters);
        } catch (SQLException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }

    /**
     * 查询单个对象
     *
     * @param sql         执行查询的SQL语句
     * @param entityClass 实体类对应的class对象
     * @param parameters  传给SQL语句的参数
     * @return 查询到的实体类对象
     */
    public T getSingleBean(String sql, Class<T> entityClass, Object... parameters) {
        try {
            // 获取数据库连接
            Connection connection = JDBCUtils.getConnection();

            return runner.query(connection, sql, new BeanHandler<>(entityClass), parameters);
        } catch (SQLException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }

    /**
     * 通用的增删改方法，insert、delete、update操作都可以用这个方法
     *
     * @param sql        执行操作的SQL语句
     * @param parameters SQL语句的参数
     * @return 受影响的行数
     * @throws SQLException
     */
    public int update(String sql, Object... parameters) {
        try {
            Connection connection = JDBCUtils.getConnection();

            int affectedRowNumbers = runner.update(connection, sql, parameters);

            return affectedRowNumbers;
        } catch (SQLException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }
}
