package cn.gamers.test;

import cn.gamers.domain.*;

import java.sql.SQLException;

import cn.gamers.dao.*;
public class ManagetcDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Manage m = new Manage();
			m.setDate("2014-02-28");
			m.setJb(2);
			ManageDao dao = new ManageDao();
//			try{
//				dao.AddT_Class(m);
//				dao.DeleteT_Class(m);
//			}catch(SQLException e){
//				e.printStackTrace();
//			}
	}

}
