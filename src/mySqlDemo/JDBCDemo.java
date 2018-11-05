package mySqlDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1、加载和注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2、创建连接 con=DriverManager.getConnection(url,user,password)
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/xuqian?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT&useSSL=false",
					"root", "");
			// 3、得到执行sql语句的Statement对象
			stmt = con.createStatement();
			// 4、执行sql语句，并返回结果
			String sql = " select * from runoob_tbl";
			rs = stmt.executeQuery(sql);
			// 5、处理结果 从数据库demo01中的employee表查找id,name,password,email,birthday信息并输出
			while (rs.next()) {
				System.out.println(rs.getInt("runoob_id"));
				System.out.println(rs.getString("runoob_title"));
				System.out.println(rs.getString("runoob_author"));
				System.out.println(rs.getDate("submission_date"));
				System.out.println("--------------------");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			stmt.close();
			con.close();
		}
	}
}
