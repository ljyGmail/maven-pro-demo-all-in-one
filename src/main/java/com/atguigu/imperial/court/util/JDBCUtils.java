package com.atguigu.imperial.court.util;

/**
 * ClassName: JDBCUtils
 * Package: com.atguigu.imperial.court.util
 * Description:
 *
 * @Author ljy
 * @Create 2025-04-28 오후 1:40
 * @Version 1.0
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 功能1: 从数据库获取数据库连接
 * 功能2: 从数据库获取到数据库连接后，绑定到本地线程(借助ThreadLocal)
 * 功能3: 释放线程时和本地线程接触绑定
 */
public class JDBCUtils {

    // 数据源成员变量设置为静态资源，保证大对象的单例性，同时保证静态方法中可以访问
    private static DataSource dataSource;

    // 由于ThreadLocal对象需要作为绑定数据时k-v对中的key，所以要保证唯一性
    // 加static声明为静态资源即可保证唯一性
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    // 在静态代码块中初始化数据源
    static {
        // 1.创建一个用于存储外部属性文件信息的Properties对象
        Properties properties = new Properties();

        // 2.使用当前类的类加载器加载外部属性文件：jdbc.properties
        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

        try {
            // 3.将外部属性文件jdbc.properties中的数据加载到properties对象中
            properties.load(inputStream);
            // 4.创建数据源对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
            // 为了避免在真正抛出异常后，catch块捕获到异常从而掩盖问题，
            // 这里将所捕获到的异常封装为运行时异常继续抛出。
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 1. 尝试从当前线程检查是否存在已经绑定的Connection对象
            connection = threadLocal.get();

            // 2. 检查Connection对象是否为null
            if (connection == null) {
                // 3. 如果为null，则从数据源获取数据库连接
                connection = dataSource.getConnection();

                // 4. 获取到数据库连接后绑定到当前线程
                threadLocal.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
        return connection;
    }

    /**
     * 释放数据库连接
     */
    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                // 在数据库连接池中将当前连接对象标记为空闲
                connection.close();

                // 将当前数据库连接从当前线程上移出
                threadLocal.remove();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
