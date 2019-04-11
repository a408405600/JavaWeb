package example;










import java.sql.*;

public class Example01 {
    public static  void main(String[] args) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn =null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //通过DriverManager获取数据库连接
            String url = "jdbc:mysql://localhost:3306/javaweb";
            String username = "root";
            String password = "123456789";
            conn = DriverManager.getConnection(url,username,password);
            stmt = conn.createStatement();
            String sql = "select * from users";
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String paw = rs.getString("password");
                String email = rs.getString("email");
                Date birthday = rs.getDate("birthday");
                System.out.println(id+"  "+name+"  "+paw+"  "+email+"  "+birthday);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }






}
