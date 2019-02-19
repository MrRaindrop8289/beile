package cn.gamers.domain;

import java.util.Date;

//沟通内容
public class C_Content {
	private int id;		//学号
	private String date;		//日期
	private String goutong_nr; //沟通内容
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
	public String getContent() {
		return goutong_nr;
	}
	public void setContent(String content) {
		this.goutong_nr = content;
	}
	
}
