package cn.gamers.domain;


public class Consultant {
	private int id;				//编号
	private String sssj;		//搜索时间	
	private String kcgw;		//课程顾问
	private int htgs;			//合同个数
	private int qyzje;			//签约总金额
	private String tcbl;		//提成比例
	private int xcqy;			//现场签约个数
	private String gjjj;		//共计奖金
	private int mgjj;			//每个奖金
	private boolean gwqr;		//顾问确认
	private boolean xzqr;		//校长确认
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSssj() {
		return sssj;
	}
	public void setSssj(String sssj) {
		this.sssj = sssj;
	}
	public String getKcgw() {
		return kcgw;
	}
	public void setKcgw(String kcgw) {
		this.kcgw = kcgw;
	}
	public int getHtgs() {
		return htgs;
	}
	public void setHtgs(int htgs) {
		this.htgs = htgs;
	}
	public int getQyzje() {
		return qyzje;
	}
	public void setQyzje(int qyzje) {
		this.qyzje = qyzje;
	}
	public String getTcbl() {
		return tcbl;
	}
	public void setTcbl(String tcbl) {
		this.tcbl = tcbl;
	}
	public int getXcqy() {
		return xcqy;
	}
	public void setXcqy(int xcqy) {
		this.xcqy = xcqy;
	}
	public String getGjjj() {
		return gjjj;
	}
	public void setGjjj(String gjjj) {
		this.gjjj = gjjj;
	}
	public int getMgjj() {
		return mgjj;
	}
	public void setMgjj(int mgjj) {
		this.mgjj = mgjj;
	}
	public boolean isGwqr() {
		return gwqr;
	}
	public void setGwqr(boolean gwqr) {
		this.gwqr = gwqr;
	}
	public boolean isXzqr() {
		return xzqr;
	}
	public void setXzqr(boolean xzqr) {
		this.xzqr = xzqr;
	}
	
}
