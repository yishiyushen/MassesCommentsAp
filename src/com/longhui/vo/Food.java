package com.longhui.vo;

import org.json.JSONException;
import org.json.JSONObject;

public class Food {
	private int foodid;
	private int sid;
	private String foodname;
	private String foodphotoid;
	public Food() {
		// TODO Auto-generated constructor stub
	}
	
	public Food(int foodid, int sid, String foodname, String foodphotoid) {
		super();
		this.foodid = foodid;
		this.sid = sid;
		this.foodname = foodname;
		this.foodphotoid = foodphotoid;
	}

	public JSONObject writoToJSon(){
		JSONObject json = new JSONObject();
		try {
			json.put("foodid", foodid);
			json.put("sid", sid);
			json.put("foodname", foodname);
			json.put("foodphotoid", foodphotoid);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
	}
	
	public int getFoodid() {
		return foodid;
	}

	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getFoodphotoid() {
		return foodphotoid;
	}

	public void setFoodphotoid(String foodphotoid) {
		this.foodphotoid = foodphotoid;
	}
	
	
}
