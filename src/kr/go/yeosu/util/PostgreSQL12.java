package kr.go.yeosu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgreSQL12 {
	static String driver = "org.postgresql.Driver";
	static String url = "jdbc:postgresql://localhost/sample";
	static String user = "postgres";
	static String pass = "1234";
	
	//공지사항 관련 SQL
	final static String NOTICE_SELECT_ALL = "select * from notice order by idx desc";
	final static String NOTICE_SELECT_ONE = "select * from notice where idx=?";
	final static String NOTICE_READCOUNT_UPDATE = "update notice set readcnt=readcnt+1 where idx=?";
	final static String INSERT_NOTICE = "insert into notice values (noti_seq.nextval, ?, ?, ?, ?, default, default)";
	final static String UPDATE_NOTICE = "update notice set title=?, content=?, file1=?, resdate=sysdate where idx=?";
	final static String UPDATE_NOTICE2 = "update notice set title=?, content=?, resdate=sysdate where idx=?";
	final static String DELETE_NOTICE = "delete from notice where idx=?";
	
	//회원 관련 SQL
	final static String USER_SELECT_ALL = "select * from user order by regdate desc";
	final static String USER_LOGIN =  "select * from user1 where id=?";
	final static String USER_VISIT_COUNT =  "update user1 set visited=visited+1 where id=?";
	final static String INSERT_USER = "insert into user1(id, pw, name, tel, addr, email) values (?,?,?,?,?,?)";
	final static String UPDATE_USER = "update user1 set pw=?, name=?, tel=?, addr=?, email=? where id=?";
	final static String UPDATE_USER2 = "update user1 set name=?, tel=?, addr=?, email=? where id=?";
	final static String DELETE_USER = "delete from user1 where id=?";
	
	//QnA관련SQL
	final static String QNO_GENERATOR = "select qno from (select * from qna order by qno desc) where rownum = 1";
	final static String ADD_QNA = "insert into qna values (?,?,?,?,sysdate,1,?,0)";
	final static String ADD_REPLY = "insert into qna values (?,?,?,?,sysdate,2,?,0)";
	final static String QNA_LIST = "select * from qna order by parno desc, qno asc";
	final static String QNA_SELECT = "select * from qna where parno=? order by qno asc";
	final static String QNA_SELECT_ONE = "select * from qna where qno=?";
	final static String REPLY_LIST = "select * from qna where parno=? and lev=2 order by qno asc";
	final static String REPLY_SELECT = "select * from qna where parno=? and lev=2 order by qno asc";
	final static String REPLY_SELECT_ONE = "select * from qna where lev=2 and qno=? order by qno asc";
	final static String UPDATE_QNA = "update qna set title=?, content=? where qno=?";
	final static String DELETE_QNA = "delete from qna where parno=?";
	final static String DELETE_REPLY = "delete from qna where qno=?";
	
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
