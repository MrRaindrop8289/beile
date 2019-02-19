package cn.gamers.test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.gamers.dao.CommunicateDao;
import cn.gamers.domain.C_Content;

public class CommunicateDB {
	 public static void main(String[] args) {  
			C_Content c = new C_Content();
			SimpleDateFormat newday1 = new SimpleDateFormat("yyyy-MM-dd");
	    	String newday = newday1.format(new Date());
	    	System.out.println(newday);
			c.setId(1);
			c.setDate(newday);
			c.setContent("123456789");
			CommunicateDao dao = new CommunicateDao();
			try{
				dao.DeleteCommunicate(1);
			}catch(SQLException e){
				e.printStackTrace();
			}
	 }  
}
