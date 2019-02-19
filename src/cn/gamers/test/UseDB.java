package cn.gamers.test;

import java.sql.SQLException;

import cn.gamers.dao.UserDao;
import cn.gamers.domain.User;

public class UseDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u = new User();
		u.setUsername("12");
		u.setPassword("1");
		u.setYonghu_jb(4);
		UserDao dao = new UserDao();
		try{
			dao.AddUser(u);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
