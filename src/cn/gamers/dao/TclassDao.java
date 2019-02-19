package cn.gamers.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.gamers.domain.T_Class;
import cn.gamers.utils.DataSourceUtils;


public class TclassDao {
	//查询试听课 通过学号
	public List<T_Class> FindClassById(int id) throws SQLException{
		String sql = "select * from tclass where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<T_Class>(T_Class.class), id);
	}
	//添加试听课
	public void AddClass(T_Class t) throws SQLException{
		String sql = "insert into tclass(id,ttime,result,is_gw_change) values(?,?,?,?)";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		qr.update(sql, t.getId(), t.getTtime(), t.getResult(), t.isIs_gw_change());
	}
	//删除试听课
	public void DeleteClass(int id) throws SQLException{
		String sql = "delete from tclass where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, id);
		System.out.println(row);
	}
	//修改试听课
	public void UpdateClass(T_Class c) throws SQLException{
		String sql = "update tclass set ttime=?,result=?,is_gw_change=? where mid=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, c.getTtime(), c.getResult(), c.isIs_gw_change(), c.getMid());
		System.out.println(row);
	}
	//查询试听课 通过mid
	public T_Class FindClassBymId(int mid) throws SQLException{
		String sql = "select * from tclass where mid=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanHandler<T_Class>(T_Class.class), mid);
	}
}
