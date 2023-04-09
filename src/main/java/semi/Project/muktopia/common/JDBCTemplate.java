package semi.Project.muktopia.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCTemplate {
	private static Connection conn = null;
	public static Connection getConnection() {
		try {
			//JNDI(Java Naming and Directory Interface API)
			//- 디렉토리에 접근하는데 사용하는 JAVA API
			// - 애플리케이션(프로그램, 웹앱)은 JNDI를 이용해서 파일 또는 서버 Resouce를 찾을 수 있음.
			Context initContext = new InitialContext();
			
			//servers-> context.xml파일을 찾을 것이다.
			Context envContext = (Context)initContext.lookup("java:/comp/env");//디렉토리에서 찾는다.
			
			//DBCP 세팅의 <Resource>태그를 찾아서 DataSource형식의 객체로 얻어오기.
			//DataSource:Connection Pool을 구현하는 객체(만들어둔 Connection 얻어오기 가능)
			DataSource ds = (DataSource)envContext.lookup("jdbc/oracle");//이건 server context에 작성된 내용들임.
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Statement stmt) {
		try {
			if(stmt!= null && stmt.isClosed()) {
				stmt.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void close(Connection conn) {
		try {
			if(conn!= null && conn.isClosed()) {
				conn.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs!= null && rs.isClosed()) {
				rs.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/** 트랜잭션 Commit 메서드
	 * @param conn
	 */
	public static void commit(Connection conn) {
		try {
			// 연결되어 Connection 객체일 경우에만 Commit 진행
			if(conn != null && !conn.isClosed())  conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/** 트랜잭션 Rollback 메서드
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			// 연결되어 Connection 객체일 경우에만 rollback 진행
			if(conn != null && !conn.isClosed())  conn.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
