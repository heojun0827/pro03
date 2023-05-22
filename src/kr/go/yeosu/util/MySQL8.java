package kr.go.yeosu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL8 {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/yeosu?serverTimezone=Asia/Seoul";
	static String user = "root";
	static String pass = "1234";
	
	public final static String SAMPLE_SELECT_ALL = "select * from sample1 order by item3 desc";
	public final static String SAMPLE_SELECT_ONE = "select * from sample1 where item1=?";
	public final static String SAMPLE_INSERT = "insert into sample1 values(?,?,default)";
	public final static String SAMPLE_UPDATE = "update sample1 set item2=? where item1=?";
	public final static String SAMPLE_DELETE = "delete from sample1 where item1=?";
	
	//회원 관련 SQL
	public final static String USER_SELECT_ALL = "select * from tbl_user order by regdate desc";
	public final static String USER_LOGIN =  "select * from tbl_user where id=?";
	public final static String INSERT_USER = "insert into tbl_user(id, pw, name, phone, addr, email) values (?,?,?,?,?,?)";
	public final static String UPDATE_USER = "update tbl_user set pw=?, name=?, phone=?, addr=?, email=? where id=?";
	public final static String UPDATE_USER2 = "update tbl_user set name=?, phone=?, addr=?, email=? where id=?";
	public final static String DELETE_USER = "delete from tbl_user where id=?";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}
	public static void close(PreparedStatement pstmt, Connection con){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
