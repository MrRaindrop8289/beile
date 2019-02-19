package cn.gamers.domain;

import java.util.Date;

//试听课管理信息
public class Manage {
	private int id;			//编号
	private String date;	//听课时间
	private int jb;			//级别
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getJb() {
		return jb;
	}
	public void setJb(int jb) {
		this.jb = jb;
	}
	
}
