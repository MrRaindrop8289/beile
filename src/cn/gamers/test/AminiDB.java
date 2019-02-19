package cn.gamers.test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.gamers.dao.AdminiDao;
import cn.gamers.domain.Admini;

public class AminiDB {
    public static void main(String[] args) {
    	
    	SimpleDateFormat newday1 = new SimpleDateFormat("yyyy-MM-dd");
    	String newday = newday1.format(new Date());
    	System.out.println(newday);
    	Admini a = new Admini();
    	a.setCon("Tesla");
    	a.setXcjl("1234");
    	a.setDate(newday);
    	a.setName("李四");
    	a.setHtje("123");
    	
    	AdminiDao dao = new AdminiDao();
    	try{
//    		dao.UpdateAdmini(a, "李四", "尼古拉斯赵四");	//更新数据		OK
//    		dao.AddAdmini(a);   		//添加数据		OK
//    		dao.DeleteAdmini(a);		//删除数据		OK
//			System.out.println("1.1");
    		List<Admini> Al = dao.FindAllAdmini();		//查询所有数据		OK
//    		List<Admini> Al = dao.FindAdminiByCon("张三")	;	//查询课程顾问数据		OK
//    		List<Admini> Al = dao.FindAdminiByDate("2017-12-09", "2018-03-06");		//根据时间来查询数据		//OK
    		
    		for (Admini l:Al){
    			System.out.println(l.getCon() + " " + l.getXcjl() + " " + l.getDate() + " " + l.getName() + " " + l.getHtje());
    		}
//    		if (Al == null){
//    			System.out.println("0.0");
//    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    }  
}
