package cn.gamers.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.gamers.domain.Student;
import cn.gamers.utils.DataSourceUtils;

public class StudentDao {
	
	//查询所有学生信息
	public List<Student> FindAllStudent() throws SQLException{
		String sql = "select * from students";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Student>(Student.class));
	}
	
	//添加学生数据
	public void AddStudent(Student s) throws SQLException{
		String sql = "insert into students(shuju_ly,name,grade,phone,next_time,content,point,is_payment,kecheng_gw) values(?,?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, s.getShuju_ly(), s.getName(), s.getGrade(), s.getPhone(), s.getNext_time(),
				s.getContent(), s.isPoint(), s.isIs_payment(), s.getKecheng_gw());
		System.out.println(row);
	}
	
	//删除学生数据
	public void DeleteStudentById(int id) throws SQLException{
		String sql = "delete from students where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, id);
		System.out.println(row);
	}
	
	//修改学生数据
	public void UpdateStudentById(Student s) throws SQLException{
		String sql = "update students set shuju_ly=?,name=?,grade=?,phone=?,next_time=?,content=?,point=?,is_payment=?,kecheng_gw=?"
				+ " where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		int row = qr.update(sql, s.getShuju_ly(), s.getName(), s.getGrade(), s.getPhone(), s.getNext_time(),s.getContent(),
				s.isPoint(), s.isIs_payment(), s.getKecheng_gw(), s.getId());
		System.out.println(row);
	}
	
	//返回最近的学生学号
	public int FindMaxId() throws SQLException{
		ResultSetHandler<Object[]> rsh = new ArrayHandler();
		String sql = "select max(id) from students";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		Object[] arr =  qr.query(sql, rsh);
		int m_id = Integer.parseInt(arr[0].toString());
		return m_id;
	}
	
	//根据ID查询学生
	public Student FindStudentById(int id) throws SQLException{
		String sql = "select * from students where id=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Student>(Student.class), id);
	}
	
}
