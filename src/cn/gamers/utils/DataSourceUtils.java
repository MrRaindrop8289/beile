package cn.gamers.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	private static DataSource datasource = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl = new ThreadLocal();
	
	public static DataSource getDataSource(){
		return datasource;
	}
	
	public static Connection getConnection() throws SQLException{
		Connection con = tl.get();
		if (con == null){
			con = datasource.getConnection();
			tl.set(con);
		}
		return con;
	}
	
	public static void startTransaction() throws SQLException{
		Connection con = getConnection();
		if (con != null){
			con.setAutoCommit(false);
		}
	}
	
	public static void releaseAndCloseConnection() throws SQLException{
		Connection con = getConnection();
		if (con != null){
			con.commit();
			tl.remove();
			con.close();
		}
	}
	
	public static void rollback() throws SQLException{
		Connection con = getConnection();
		if (con != null){
			con.rollback();
		}
	}
}
