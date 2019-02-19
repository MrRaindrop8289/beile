package cn.gamers.domain;

import java.util.Date;

//学生信息
public class Student {
	private int id;					//学号
	private String shuju_ly;		//数据来源
	private String name;			//学员姓名
	private String grade;			//年级
	private String phone; 			//联系方式
	private String next_time;		//下次联系时间
	private String content;			//沟通内容
	private boolean point;			//重点
	private String kecheng_gw;		//课程顾问
	private int tsum;				//试听课总节数
	private boolean is_payment;		//是否缴费
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShuju_ly() {
		return shuju_ly;
	}
	public void setShuju_ly(String shuju_ly) {
		this.shuju_ly = shuju_ly;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNext_time() {
		return next_time;
	}
	public void setNext_time(String next_time) {
		this.next_time = next_time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isPoint() {
		return point;
	}
	public boolean getPoint() {
		return point;
	}
	public void setPoint(boolean point) {
		this.point = point;
	}
	public boolean isIs_payment() {
		return is_payment;
	}
	public void setIs_payment(boolean is_payment) {
		this.is_payment = is_payment;
	}
	public String getKecheng_gw() {
		return kecheng_gw;
	}
	public void setKecheng_gw(String kecheng_gw) {
		this.kecheng_gw = kecheng_gw;
	}
	public int getTsum() {
		return tsum;
	}
	public void setTsum(int tsum) {
		this.tsum = tsum;
	}

}
