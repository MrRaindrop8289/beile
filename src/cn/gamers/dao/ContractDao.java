package cn.gamers.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import cn.gamers.domain.Contract;
import cn.gamers.utils.DataSourceUtils;

public class ContractDao {
	
	//查找所有合同
	public List<Contract> FindAllContract() throws SQLException{
		String sql = "select * from contracts";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Contract>(Contract.class));
	}
	
	//添加合同
	public void AddContract(Contract c) throws SQLException{
		String sql = "insert into contracts(type,name,tclass,level,cmoney,date,isnow,con,isprincipal) values(?,?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, c.getType(), c.getName(), c.getTclass(), c.getLevel(), c.getCmoney(), c.getDate(), c.isIsnow(), c.getCon(), c.isIsprincipal());
		System.out.println(row);
		
	}
	//删除合同
	public void DeleteContract(String id) throws SQLException{
		String sql = "delete from contracts where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, id);
		System.out.println(row);
	}
	
	//修改合同
	public void UpadteContract(Contract c) throws SQLException{
		String sql = "update contracts set type=?,name=?,tclass=?,level=?,cmoney=?,date=?,isnow=?,con=?,isprincipal=? where id=?";
		QueryRunner qr =new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, c.getType(), c.getName(), c.getTclass(), c.getLevel(), c.getCmoney(), c.getDate(), c.isIsnow(), c.getCon(), c.isIsprincipal(), c.getId());
		System.out.println(row);
	}
	//查询合同  时间
	public List<Contract> FindContractByDate(String date1, String date2) throws SQLException{
		String sql = "select * from contracts where date>=? and date<=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Contract>(Contract.class), date1, date2);
	}
	//查询合同 顾问
	public List<Contract> FindContractByCon(String con) throws SQLException{
		String sql = "select * from contracts where con=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Contract>(Contract.class), con);
	}
	//查询合同 校长未确认
	public List<Contract> FindContractByIsP() throws SQLException{
		String sql = "select * from contracts where isprincipal=false";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Contract>(Contract.class));
	}
	//根据id查找合同
	public Contract FindContractById(String id) throws SQLException{
		String sql = "select * from contracts where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Contract>(Contract.class), id);
	}
}
