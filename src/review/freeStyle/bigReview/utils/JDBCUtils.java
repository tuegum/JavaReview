package review.freeStyle.bigReview.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类，使用Druid连接池
 */
public class JDBCUtils {
private static DataSource ds;
private static Properties prop;

static {

    try {
        //1.加载配置文件
        prop = new Properties();
        prop.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
        //2.获取数据库连接池对象
        ds = DruidDataSourceFactory.createDataSource(prop);

    } catch (IOException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

/**
 * 获取连接
 */
public static Connection getConnection() throws SQLException {
    return ds.getConnection();
}

/**
 * 获取连接池
 */

public static DataSource getDataSource() {
    return ds;
}

/**
 * 释放资源
 *
 * @param stat
 * @param coon
 */
public static void close(Statement stat, Connection coon) {
    if (stat != null) {
        try {
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if (coon != null) {
        try {
            coon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public static void close(ResultSet rs, Statement stat, Connection coon) {
    if (rs != null) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if (stat != null) {
        try {
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if (coon != null) {
        try {
            coon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
}
