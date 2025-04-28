package com.atguigu.maven;

import com.atguigu.imperial.court.dao.BaseDao;
import com.atguigu.imperial.court.entity.Emp;
import com.atguigu.imperial.court.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * ClassName: ImperialCourtTest
 * Package: com.atguigu.maven
 * Description:
 *
 * @Author ljy
 * @Create 2025-04-28 오후 2:35
 * @Version 1.0
 */
public class ImperialCourtTest {

    private BaseDao<Emp> baseDao = new BaseDao<>();

    @Test
    public void testGetSingleBean() {
        String sql = "select emp_id empId, emp_name empName, emp_position empPosition, login_account loginAccount, login_password loginPassword FROM t_emp WHERE emp_id = ?";

        Emp emp = baseDao.getSingleBean(sql, Emp.class, 1);

        System.out.println("emp = " + emp);
    }

    @Test
    public void testGetBeanList() {

        String sql = "select emp_id empId, emp_name empName, emp_position empPosition, login_account loginAccount, login_password loginPassword FROM t_emp";

        List<Emp> empList = baseDao.getBeanList(sql, Emp.class);

        for (Emp emp : empList) {
            System.out.println("emp = " + emp);
        }
    }

    @Test
    public void testUpdate() {
        String sql = "update t_emp set emp_position = ? where emp_id = ?";

        String empPosition = "minister";
        String empId = "3";

        int affectedRowNumber = baseDao.update(sql, empPosition, empId);

        System.out.println("affectedRowNumber = " + affectedRowNumber);

    }

    @Test
    public void testGetConnection() {
        Connection connection = JDBCUtils.getConnection();
        System.out.println("connection = " + connection);

        JDBCUtils.releaseConnection(connection);
    }

    @Test
    public void testSubString() {
        String substring = "aaa.png".substring("aaa.png".lastIndexOf("."));
        System.out.println("substring = " + substring);
    }
}
