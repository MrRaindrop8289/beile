package cn.gamers.domain;

import java.util.Date;

//合同信息
public class Contract {
	private int id;					//学号
	private String name;			//姓名
	private String type;			//合同类型
	private String tclass;			//班级类型
	private String level;			//级别
	private String cmoney;			//合同金额
	private String date;			//合同时间
	private String con;				//签约顾问
	private boolean isprincipal;	//校长确认
	private boolean isnow;			//是否现场签约
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getTclass() {
		return tclass;
	}
	public void setTclass(String tclass) {
		this.tclass = tclass;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getCmoney() {
		return cmoney;
	}
	public void setCmoney(String cmoney) {
		this.cmoney = cmoney;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public boolean isIsprincipal() {
		return isprincipal;
	}
	public void setIsprincipal(boolean isprincipal) {
		this.isprincipal = isprincipal;
	}
	public boolean isIsnow() {
		return isnow;
	}
	public void setIsnow(boolean isnow) {
		this.isnow = isnow;
	}
	
	
}
