package com.longhui.vo;

import org.json.JSONException;
import org.json.JSONObject;

public class Shop {
	
	private int sid;
	private int iid;
	private String	sname;
	private String	stype;
	private String  saddress;
	private String  snear;
	private String	stel;
	private String	stime;
	private String	szhekou;
	private String	smembercard;
	private String  sper;
	private String	smoney;
	private String  snum;
	private String  slevel;
	private String  sflag_tuan;
	private String  sflag_quan;
	private String  sflag_ding;
	private String  sflag_ka;
	private String  longitude;
	private String  latitude;
	private String  sintroduction;
	private String  sdetails;
	private String  stips;
	private String  sflag_promise;
	private String  iname;	// = phone.iname 图片名字

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JSONObject writeToJson(){
		JSONObject jObject = new JSONObject();
		try {
			jObject.put("sid", sid);
			jObject.put("iid", iid);
			jObject.put("sname", sname);
			jObject.put("stype", stype);
			jObject.put("saddress", saddress);
			jObject.put("snear", snear);
			jObject.put("stel", stel);
			jObject.put("stime", stime);
			jObject.put("szhekou", szhekou);
			jObject.put("smembercard", smembercard);
			jObject.put("sper", sper);
			jObject.put("smoney", smoney);
			jObject.put("snum", snum);
			jObject.put("slevel", slevel);
			jObject.put("sflag_tuan", sflag_tuan);
			jObject.put("sflag_quan", sflag_quan);
			jObject.put("sflag_ding", sflag_ding);
			jObject.put("sflag_ka", sflag_ka);
			jObject.put("longitude", longitude);
			jObject.put("latitude", latitude);
			jObject.put("sintroduction", sintroduction);
			jObject.put("sdetails", sdetails);
			jObject.put("stips", stips);
			jObject.put("sflag_promise", sflag_promise);
			jObject.put("iname", iname);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jObject;

	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getSnear() {
		return snear;
	}

	public void setSnear(String snear) {
		this.snear = snear;
	}

	public String getStel() {
		return stel;
	}

	public void setStel(String stel) {
		this.stel = stel;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getSzhekou() {
		return szhekou;
	}

	public void setSzhekou(String szhekou) {
		this.szhekou = szhekou;
	}

	public String getSmembercard() {
		return smembercard;
	}

	public void setSmembercard(String smembercard) {
		this.smembercard = smembercard;
	}

	public String getSper() {
		return sper;
	}

	public void setSper(String sper) {
		this.sper = sper;
	}

	public String getSmoney() {
		return smoney;
	}

	public void setSmoney(String smoney) {
		this.smoney = smoney;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getSlevel() {
		return slevel;
	}

	public void setSlevel(String slevel) {
		this.slevel = slevel;
	}

	public String getSflag_tuan() {
		return sflag_tuan;
	}

	public void setSflag_tuan(String sflag_tuan) {
		this.sflag_tuan = sflag_tuan;
	}

	public String getSflag_quan() {
		return sflag_quan;
	}

	public void setSflag_quan(String sflag_quan) {
		this.sflag_quan = sflag_quan;
	}

	public String getSflag_ding() {
		return sflag_ding;
	}

	public void setSflag_ding(String sflag_ding) {
		this.sflag_ding = sflag_ding;
	}

	public String getSflag_ka() {
		return sflag_ka;
	}

	public void setSflag_ka(String sflag_ka) {
		this.sflag_ka = sflag_ka;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getSintroduction() {
		return sintroduction;
	}

	public void setSintroduction(String sintroduction) {
		this.sintroduction = sintroduction;
	}

	public String getSdetails() {
		return sdetails;
	}

	public void setSdetails(String sdetails) {
		this.sdetails = sdetails;
	}

	public String getStips() {
		return stips;
	}

	public void setStips(String stips) {
		this.stips = stips;
	}

	public String getSflag_promise() {
		return sflag_promise;
	}

	public void setSflag_promise(String sflag_promise) {
		this.sflag_promise = sflag_promise;
	}
	
	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}
}
