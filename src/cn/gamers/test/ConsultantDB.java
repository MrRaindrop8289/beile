package cn.gamers.test;

import java.sql.SQLException;
import java.util.List;

import cn.gamers.dao.ConsultantDao;
import cn.gamers.domain.Consultant;

public class ConsultantDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Consultant c = new Consultant();
			c.setGjjj("1asd");
			c.setGwqr(false);
			c.setHtgs(2);
			c.setKcgw("12");
			c.setSssj("1234asd");
			c.setTcbl("123");
			c.setXcqy(3);
			c.setXzqr(false);
			ConsultantDao dao = new ConsultantDao();
			
			try{
				dao.AddConsultant(c);	//Success_Add
//				dao.DeleteConsultant(c);//Success_Deete
//				List<Consultant> cl = dao.FindConsultantByCon("12");
//				for (Consultant c1:cl){
//					System.out.println(c1.getTcbl() + " " + c.getKcgw());
//				}
			}catch(SQLException e){
				e.printStackTrace();
			}
	}

}
