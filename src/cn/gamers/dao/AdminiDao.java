package cn.gamers.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.gamers.domain.Admini;
import cn.gamers.utils.DataSourceUtils;

public class AdminiDao {
	//查找所有行政数据库
	public List<Admini> FindAllAdmini() throws SQLException{
		String sql = "select * from adminis";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Admini>(Admini.class));
	}
	
	//添加行政信息
	public void AddAdmini(Admini admini) throws SQLException{
		String sql = "insert into adminis(con,date,name,xcjl,htje) values(?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, admini.getCon(), admini.getDate(), admini.getName()
				, admini.getXcjl(), admini.getHtje());
		System.out.println(row);
	}
	
	//删除行政信息
	public void DeleteAdmini(Admini admini) throws SQLException{
		String sql = "delete from adminis where con=? and name=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		qr.update(sql, admini.getCon(), admini.getName());
	}
	
	//更新行政信息
	public void UpdateAdmini(Admini admini, int id) throws SQLException{
		String sql = "update adminis set con=?,date=?,name=?,xcjl=?,htje=? where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, admini.getCon(), admini.getDate(), admini.getName()
				, admini.getXcjl(), admini.getHtje(), id);
		System.out.println(row);
	}
	
	//根据时间查找行政信息
	public List<Admini> FindAdminiByDate(String date1, String date2) throws SQLException{
		String sql = "select * from adminis where date >= ? and date <= ?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Admini>(Admini.class), date1, date2);
	}
	
	//根据课程顾问查询行政信息
	public List<Admini> FindAdminiByCon(String con) throws SQLException{
		String sql = "select * from adminis where con=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Admini>(Admini.class), con);
	}
	//根据Id查询行政信息
	public Admini FindAdminiById(int id) throws SQLException{
		String sql = "select * from adminis where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Admini>(Admini.class), id);
	}
}
