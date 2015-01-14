package com.longhui.vo;

import org.json.JSONException;
import org.json.JSONObject;

public class Sign {

	private int signid;
	private int sid;
	private int pid;
	private String name;
	private String signcontent;
	private String signlevel;
	private String signimg;
	private String signtime;
	
	public Sign() {
		// TODO Auto-generated constructor stub
	}
	
	public Sign(int signid, int sid, int pid, String name, String signcontent,
			String signlevel, String signimg, String signtime) {
		super();
		this.signid = signid;
		this.sid = sid;
		this.pid = pid;
		this.name = name;
		this.signcontent = signcontent;
		this.signlevel = signlevel;
		this.signimg = signimg;
		this.signtime = signtime;
	}
	
	public Sign(int sid, int pid, String name, String signcontent,
			String signlevel, String signimg, String signtime) {
		super();

		this.sid = sid;
		this.pid = pid;
		this.name = name;
		this.signcontent = signcontent;
		this.signlevel = signlevel;
		this.signimg = signimg;
		this.signtime = signtime;
	}
	public JSONObject writeToJson(){
		JSONObject json = new JSONObject();
		try {
			json.put("signid", signid);
			json.put("sid", sid);
			json.put("pid", pid);
			json.put("name", name);
			json.put("signcontent", signcontent);
			json.put("signlevel", signlevel);
			json.put("signimg", signimg);
			json.put("signtime", signtime);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	public int getSignid() {
		return signid;
	}

	public void setSignid(int signid) {
		this.signid = signid;
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

	public String getSigncontent() {
		return signcontent;
	}

	public void setSigncontent(String signcontent) {
		this.signcontent = signcontent;
	}

	public String getSignlevel() {
		return signlevel;
	}

	public void setSignlevel(String signlevel) {
		this.signlevel = signlevel;
	}

	public String getSignimg() {
		return signimg;
	}

	public void setSignimg(String signimg) {
		this.signimg = signimg;
	}

	public String getSigntime() {
		return signtime;
	}

	public void setSigntime(String signtime) {
		this.signtime = signtime;
	}
	
	
	
}
