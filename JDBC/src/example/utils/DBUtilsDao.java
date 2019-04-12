package example.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DBUtilsDao {
    //查询所有，返回List集合
    public List findAll() throws SQLException{
        //创建QueryRunner对象
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        //写SQL语句
        String sql = "select * from user";
        //调用方法
        List list = (List) runner.query(sql,new BeanListHandler(User.class));
        return list;
    }

    //查询单个，返回对象
    public User find(int id) throws SQLException{
        //创建QueryRunner对象
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        //写SQL语句
        String sql = "select * from user where id=?";
        //调用方法
        User user = (User) runner.query(sql,new BeanListHandler(User.class),new Object[] { id });
        return user;
    }

    //添加用户的操作
    public Boolean insert(User user) throws SQLException{
        //创建QueryRunner对象
        QueryRunner runner = new QueryRunner(C3p0Utils.getDataSource());
        //写SQL语句
        String sql = "insert into user (name,password) values (?,?)";
        //调用方法
        int num = runner.update()
    }
}
