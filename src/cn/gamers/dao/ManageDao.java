package cn.gamers.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.gamers.domain.Manage;
import cn.gamers.utils.DataSourceUtils;

public class ManageDao {
	
	//查询所有试听课
	public List<Manage> FindAllManage() throws SQLException{
		String sql = "select * from managetc";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Manage>(Manage.class));
	}
	
	//添加试听课
	public void AddT_Class(Manage m) throws SQLException{
		String sql = "insert into managetc(date,jb) values(?,?)";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, m.getDate(), m.getJb());
		System.out.println(row);
	}
	
	//删除试听课
	public void DeleteT_Class(int id) throws SQLException{
		String sql = "delete from managetc where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, id);
		System.out.println(row);
	}
	
	//修改试听课
	public void Update_Class(Manage m) throws SQLException{
		String sql = "update managetc set date=?,jb=? where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, m.getDate(), m.getJb(), m.getId());
		System.out.println(row);
	}
	
	//根据Id查询试听课
	public Manage FindManageById(int id) throws SQLException{
		String sql = "select * from managetc where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Manage>(Manage.class), id);
	}
}
