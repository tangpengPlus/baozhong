package com.bz.manage.model.test;


public class Select {
	
	private String id;
	private String name;
	private String shopname;
	private String start;
	private String end;
	private String mstart;
	private String mend;
	public Select() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Select(String id, String name, String shopname, String start, String end, String mstart, String mend) {
		super();
		this.id = id;
		this.name = name;
		this.shopname = shopname;
		this.start = start;
		this.end = end;
		this.mstart = mstart;
		this.mend = mend;
	}
	@Override
	public String toString() {
		return "Select [id=" + id + ", name=" + name + ", shopname=" + shopname + ", start=" + start + ", end=" + end
				+ ", mstart=" + mstart + ", mend=" + mend + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getMstart() {
		return mstart;
	}
	public void setMstart(String mstart) {
		this.mstart = mstart;
	}
	public String getMend() {
		return mend;
	}
	public void setMend(String mend) {
		this.mend = mend;
	}
	
}
