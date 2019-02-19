package cn.gamers.domain;

import java.util.Date;

//行政信息
public class Admini {
	private int id;					//编号
	private String con;				//课程顾问
	private String date;			//日期
	private String name;			//学生名字
	private String xcjl;			//现场奖励
	private String htje;			//合同金额
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getXcjl() {
		return xcjl;
	}
	public void setXcjl(String Xcjl) {
		this.xcjl = Xcjl;
	}
	public String getHtje() {
		return htje;
	}
	public void setHtje(String htje) {
		this.htje = htje;
	}
}
