package cn.gamers.domain;

import java.util.Date;

//试听课信息
public class T_Class {
	private int mid;				//试听课编号
	private int id;					//学号
	private String ttime;			//试听时间
	private String result;			//试听结果
	private boolean is_gw_change;	//课程顾问是否修改
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTtime() {
		return ttime;
	}
	public void setTtime(String ttime) {
		this.ttime = ttime;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public boolean isIs_gw_change() {
		return is_gw_change;
	}
	public void setIs_gw_change(boolean is_gw_change) {
		this.is_gw_change = is_gw_change;
	}


	
}
