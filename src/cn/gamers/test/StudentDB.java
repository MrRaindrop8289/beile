package cn.gamers.test;

import java.sql.SQLException;
import java.util.List;

import cn.gamers.dao.StudentDao;
import cn.gamers.domain.Student;

public class StudentDB {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Student s = new Student();
			s.setShuju_ly("1");
			s.setName("张三");
			s.setGrade("小班");
			s.setPhone("1351695654");
			s.setNext_time("2017-04-04");
			s.setPoint(true);
			s.setIs_payment(true);
			s.setKecheng_gw("1.1");
			
			StudentDao dao = new StudentDao();
			try{
//				dao.AddStudent(s);
//				List<Student> sl = dao.FindAllStudent();
//				for (Student s1:sl){
//					System.out.println(s1.getGrade() + " " + s1.getKecheng_gw() + " " + s1.getName() + " " + s1.getNext_time() + " " + s1.getPhone() + " " + s1.getShuju_ly() + " " + s1.isIs_kecheng() + " " + s1.isIs_payment() + " " + s1.isPoint());
//				}
				System.out.println(dao.FindMaxId());
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
}
