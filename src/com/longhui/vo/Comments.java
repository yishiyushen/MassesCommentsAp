package com.longhui.vo;

import org.json.JSONException;
import org.json.JSONObject;

public class Comments {
	private int cid;
	private int sid;
	private int pid;
	private String name;
	private String comments;
	private String clevel;
	private String kouweilevel;
	private String huanjinglevel;
	private String fuwulevel;
	private String cpermoney;
	private String time;
	
	public Comments() {
		// TODO Auto-generated constructor stub
	}
	public Comments(int cid, int sid, int pid, String name, String comments,
			String clevel, String kouweilevel, String huanjinglevel,
			String fuwulevel, String cpermoney, String time) {
		super();
		this.cid = cid;
		this.sid = sid;
		this.pid = pid;
		this.name = name;
		this.comments = comments;
		this.clevel = clevel;
		this.kouweilevel = kouweilevel;
		this.huanjinglevel = huanjinglevel;
		this.fuwulevel = fuwulevel;
		this.cpermoney = cpermoney;
		this.time = time;
	}

	public JSONObject writeToJson(){
		JSONObject json = new JSONObject();
		try {
			json.put("cid", cid);
			json.put("sid",sid);
			json.put("pid", pid);
			json.put("name", name);
			json.put("comments", comments);
			json.put("kouweilevel", kouweilevel);
			json.put("huanjinglevel", huanjinglevel);
			json.put("fuwulevel", fuwulevel);
			json.put("cpermoney", cpermoney);
			json.put("time", time);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;
	}
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getClevel() {
		return clevel;
	}

	public void setClevel(String clevel) {
		this.clevel = clevel;
	}

	public String getKouweilevel() {
		return kouweilevel;
	}

	public void setKouweilevel(String kouweilevel) {
		this.kouweilevel = kouweilevel;
	}

	public String getHuanjinglevel() {
		return huanjinglevel;
	}

	public void setHuanjinglevel(String huanjinglevel) {
		this.huanjinglevel = huanjinglevel;
	}

	public String getFuwulevel() {
		return fuwulevel;
	}

	public void setFuwulevel(String fuwulevel) {
		this.fuwulevel = fuwulevel;
	}

	public String getCpermoney() {
		return cpermoney;
	}

	public void setCpermoney(String cpermoney) {
		this.cpermoney = cpermoney;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
