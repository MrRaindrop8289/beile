package cn.gamers.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.gamers.domain.C_Content;
import cn.gamers.utils.DataSourceUtils;

public class CommunicateDao {
	
	//查找所有沟通数据
	public List<C_Content> FindAllCommunicate() throws SQLException{
		String sql = "select * from communicate";
		QueryRunner qr =new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<C_Content>(C_Content.class));
	}
	//添加沟通数据
	public void AddCommunicate(C_Content content) throws SQLException{
		String sql = "insert into communicate(id,day,content) values(?,?,?)";
		QueryRunner qr =new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, content.getId(), content.getDate(), content.getContent());
		System.out.println(row);
	}
	
	//修改沟通数据
	public void UpadteCommunicate(C_Content c) throws SQLException{
		String sql = "update communicate set day=?,content=? where id=?";
		QueryRunner qr =new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, c.getDate(), c.getContent(), c.getId());
		System.out.println(row);
	}
	
	//删除沟通数据
	public void DeleteCommunicate(int id) throws SQLException{
		String sql = "delete from communicate where id=?";
		QueryRunner qr =new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, id);
		System.out.println(row);
	}
	
	//根据ID查找沟通内容
	public C_Content FindCommunicateById(int id) throws SQLException{
		String sql = "select * from communicate where id=?";
		QueryRunner qr =new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanHandler<C_Content>(C_Content.class), id);
	}
}
