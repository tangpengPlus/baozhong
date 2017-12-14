package com.bz.manage.model.test;

public class SelectW {

	private String type;
	private String shopname;
	private String order;
	private String rtype;
	private String start;
	private String end;
	private String mstart;
	private String mend;
	public SelectW() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "SelectW [type=" + type + ", shopname=" + shopname + ", order=" + order + ", rtype=" + rtype + ", start="
				+ start + ", end=" + end + ", mstart=" + mstart + ", mend=" + mend + "]";
	}

	public SelectW(String type, String shopname, String order, String rtype, String start, String end, String mstart,
			String mend) {
		super();
		this.type = type;
		this.shopname = shopname;
		this.order = order;
		this.rtype = rtype;
		this.start = start;
		this.end = end;
		this.mstart = mstart;
		this.mend = mend;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
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
