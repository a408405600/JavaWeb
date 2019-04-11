package example;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class BDS {
    public static DataSource ds = null;
    static {
        BasicDataSource bds = new BasicDataSource();
        //数据库连接信息
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/javaweb");
        bds.setUsername("root");
        bds.setPassword("123456789");
        //设置连接池的参数
        bds.setInitialSize(5);

        ds = bds;
    }

    public static  void main(String[] args) throws SQLException {
        Connection connection = ds.getConnection();
        DatabaseMetaData metaData = connection.getMetaData();

        System.out.println(metaData.getURL()+metaData.getUserName()+metaData.getDriverName());
    }
}
