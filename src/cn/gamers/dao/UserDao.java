package cn.gamers.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.gamers.domain.User;
import cn.gamers.exception.CanNotDeleteException;
import cn.gamers.utils.DataSourceUtils;

public class UserDao {
	//查询所有用户
	public List<User> FindAllUsers() throws SQLException{
		String sql = "select * from users";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<User>(User.class));
	}
	//添加用户
	public void AddUser(User u) throws SQLException{
		String sql = "insert into users(username,password,yonghu_jb) values(?,?,?)";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, u.getUsername(), u.getPassword(), u.getYonghu_jb());
		System.out.println(row);
	}
	//删除用户
	public void DeleteUser(User u) throws SQLException,CanNotDeleteException{
		if (u.getYonghu_jb() != 0){
			String sql = "delete from users where username=?";
			QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
			int row = qr.update(sql, u.getUsername());
			System.out.println(row);
		}else{
			throw new CanNotDeleteException();
		}
	}
	//修改用户
	public void UpdateUser(User u) throws SQLException{
		String sql = "update users set username=?,password=?,yonghu_jb=? where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		qr.update(sql, u.getUsername(), u.getPassword(), u.getYonghu_jb(), u.getId());
	}
	//根据用户名查询用户
	public User FindUserByName(String userName) throws SQLException{
		String sql = "select * from users where username=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanHandler<User>(User.class),userName);		
	}

	//查询用户 根据级别
	public List<User> FindUserByLevel(int yonghu_jb) throws SQLException{
		String sql = "select * from users where yonghu_jb=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<User>(User.class), yonghu_jb);
	}
	//查询用户 根据Id
	public User FindUserById(int id) throws SQLException{
		String sql = "select * from users where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanHandler<User>(User.class), id);
	}
}
