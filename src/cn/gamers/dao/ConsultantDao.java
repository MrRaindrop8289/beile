package cn.gamers.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import cn.gamers.domain.Consultant;
import cn.gamers.utils.DataSourceUtils;

public class ConsultantDao {
	//查找所有搜索合同数据
	public List<Consultant> FindAllConsultant() throws SQLException{
		String sql = "select * from consultant";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Consultant>(Consultant.class));
	}
	
	//添加搜索合同
	public void AddConsultant(Consultant c) throws SQLException{
		String sql = "insert into consultant(sssj,kcgw,htgs,qyzje,tcbl,xcqy,mgjj,gjjj,gwqr,xzqr) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, c.getSssj(), c.getKcgw(), c.getHtgs(), c.getQyzje(), c.getTcbl(), c.getXcqy(), c.getGjjj(), c.getMgjj(), c.isGwqr(), c.isXzqr());
		System.out.println(row);
	}
	
	//删除搜索合同
	public void DeleteConsultant(Consultant c) throws SQLException{
		String sql = "delete from consultant where sssj=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, c.getSssj());
		System.out.println(row);
	}
	
	//更新搜索合同
	public void UpdateConsultant(Consultant c) throws SQLException{
		String sql = "update consultant set sssj=?,kcgw=?,htgs=?,qyzje=?,tcbl=?,xcqy=?,gjjj=?,mgjj=?,gwqr=?,xzqr=? where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, c.getSssj(), c.getKcgw(), c.getHtgs(), c.getQyzje(), c.getTcbl(), c.getXcqy(), c.getGjjj(), c.getMgjj(),
						c.isGwqr(), c.isXzqr(), c.getId());
		System.out.println(row);
	}
	
	//清除所有搜索合同
	public void DeleteAllConsultant() throws SQLException{
		String sql = "truncate table consultant";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql);
		System.out.println(row);
	}
	
	//根据课程顾问查找搜索合同
	public List<Consultant> FindConsultantByCon(String con) throws SQLException{
		String sql = "select * from consultant where kcgw=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Consultant>(Consultant.class), con);
	}
	
	//根据课程顾问未确认查找搜索合同
	public List<Consultant> FindConsultantByConAndIsN(String con) throws SQLException{
		String sql = "select * from consultant where kcgw=? and gwqr=false";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Consultant>(Consultant.class), con);
	}
	//根据课程顾问未确认查找搜索合同
		public List<Consultant> FindConsultantByP() throws SQLException{
			String sql = "select * from consultant where xzqr=false";
			QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
			return qr.query(sql, new BeanListHandler<Consultant>(Consultant.class));
		}
	//根据Id查找搜索合同
	public Consultant FindConsultantById(int id) throws SQLException{
		String sql = "select * from consultant where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Consultant>(Consultant.class), id);
	}
	
	//根据日期和课程顾问查找合同
	public Consultant FindConsultantByConAndDate(String con , String date) throws SQLException{
		String sql = "select * from consultant where kcgw=? and sssj=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Consultant>(Consultant.class), con, date);
	}
	
	//根据日期查找合同
	public List<Consultant> FindConsultantByDate(String date) throws SQLException{
		String sql = "select * from consultant where sssj=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Consultant>(Consultant.class), date);
	}
	
	
}
