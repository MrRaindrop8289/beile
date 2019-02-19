package cn.gamers.test;

import java.sql.SQLException;
import java.util.List;

import cn.gamers.dao.ContractDao;
import cn.gamers.domain.Contract;

public class ContractDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contract c = new Contract();
		c.setCmoney("1");
		c.setCon("12");
		c.setDate("2018-03-04");
		c.setIsnow(true);
		c.setIsprincipal(true);
		c.setLevel("PK6");
		c.setTclass("123");
		c.setType("1234");
		ContractDao dao = new ContractDao();
		try{
//			dao.AddContract(c);		添加合同
			List<Contract> cl = dao.FindAllContract();
			for (Contract c1:cl){
				System.out.println(c.getType()+" "+ c.getTclass()+" "+ c.getLevel()+" "+ c.getCmoney()+" "+ c.getDate()+" "+ c.isIsnow()+" "+ c.getCon()+" "+ c.isIsprincipal());
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
