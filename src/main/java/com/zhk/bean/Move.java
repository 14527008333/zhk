package com.zhk.bean;

import java.sql.Date;

public class Move {
	private Integer mid;
	
	private String mname;
	
	private String context;
	
	private String daoyan;
	
	private Date startdate;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getDaoyan() {
		return daoyan;
	}

	public void setDaoyan(String daoyan) {
		this.daoyan = daoyan;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Move(Integer mid, String mname, String context, String daoyan, Date startdate) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.context = context;
		this.daoyan = daoyan;
		this.startdate = startdate;
	}

	public Move() {
		super();
	}

	@Override
	public String toString() {
		return "Type [mid=" + mid + ", mname=" + mname + ", context=" + context + ", daoyan=" + daoyan + ", startdate="
				+ startdate + "]";
	}
	
	
}
