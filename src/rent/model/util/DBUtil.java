package rent.model.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static Properties dbInfo = new Properties();
	private static Properties sql = new Properties();
	
	static {
		try {
			dbInfo.load(new FileInputStream("db.properties"));
			sql.load(new FileInputStream("sql.properties"));
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public static Properties getSql() {
		return sql;
	}
	
	
	public static Connection getConnection() throws SQLException {  
		return DriverManager.getConnection(dbInfo.getProperty("jdbc.url"), dbInfo.getProperty("jdbc.id"), dbInfo.getProperty("jdbc.pw"));	
	}
	
	public static void close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
}
