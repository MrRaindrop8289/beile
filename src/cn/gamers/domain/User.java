package cn.gamers.domain;

/**
 * @author 雨滴先生
 *
 */
//用户数据库
public class User {
	private int id;					//用户ID
	private String username;		//用户名
	private String password;		//密码
	private int yonghu_jb;			//用户级别		1-校长 	2-行政 	3-教务 	4-课程顾问		5-前台
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getYonghu_jb() {
		return yonghu_jb;
	}
	public void setYonghu_jb(int yonghu_jb) {
		this.yonghu_jb = yonghu_jb;
	}
	
}
