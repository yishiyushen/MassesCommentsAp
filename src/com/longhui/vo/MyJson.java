package com.longhui.vo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;


public class MyJson {
	private ArrayList<Sign> SignList = new ArrayList<Sign>();
	private ArrayList<Comments> CommentsList = new ArrayList<Comments>();
	private ArrayList<Food> FoodList = new ArrayList<Food>();

	
	public List<Shop> getShopList(String value) {
		List<Shop> list = null;
		try {
			JSONObject jObject = new JSONObject(value);
			JSONObject jdata = jObject.getJSONObject("data");
			JSONArray jay = jdata.getJSONArray("shop");
			list = new ArrayList<Shop>();
			for (int i = 0; i < jay.length(); i++) {
				JSONObject job = jay.getJSONObject(i);
				Shop info = new Shop();
				info.setSid(job.getInt("sid"));
				info.setSname(job.getString("sname"));
				info.setStype(job.getString("stype"));
				info.setSaddress(job.getString("saddress"));
				info.setSnear(job.getString("snear"));
				info.setStel(job.getString("stel"));
				info.setStime(job.getString("stime"));
				info.setSzhekou(job.getString("szhekou"));
				info.setSmembercard(job.getString("smembercard"));
				info.setSper(job.getString("sper"));
				info.setSmoney(job.getString("smoney"));
				info.setSnum(job.getString("snum"));
				info.setSlevel(job.getString("slevel"));
				info.setSflag_tuan(job.getString("sflag_tuan"));
				info.setSflag_quan(job.getString("sflag_quan"));
				info.setSflag_ding(job.getString("sflag_ding"));
				info.setSflag_ka(job.getString("sflag_ka"));
				info.setLongitude(job.getString("longitude"));
				info.setLatitude(job.getString("latitude"));
				info.setSintroduction(job.getString("sintroduction"));
				info.setSdetails(job.getString("sdetails"));
				info.setStips(job.getString("stips"));
				info.setSflag_promise(job.getString("sflag_promise"));
				info.setIname(job.getString("iname"));
				list.add(info);
			}
		} catch (JSONException e) {
		}
		return list;
	}

	public void getShopDetail(String mJson, DetailCallBack callback) {
		try {
			JSONObject jobs = new JSONObject(mJson);
			String result = jobs.getString("msg");
			Log.e("result", "result:" + result);
			if (result.equalsIgnoreCase("ok")) {
				Log.e("result", "result:" + result);
				JSONObject jdata = jobs.getJSONObject("data");
				
//				String signValue = job.getString("sign");
//				String commentsValue = job.getString("comments");
//				String foodValue = job.getString("food");
				JSONArray signArray = jdata.getJSONArray("sign");//new JSONArray(signValue);
				JSONArray commentsArray = jdata.getJSONArray("comments");//new JSONArray(commentsValue);
				JSONArray foodArray = jdata.getJSONArray("food");//new JSONArray(foodValue);
				for (int i = 0; i < foodArray.length(); i++) {
					JSONObject sJob = foodArray.getJSONObject(i);
					Food info = new Food();
					info.setFoodid(sJob.getInt("foodid"));
					info.setSid(sJob.getInt("sid"));
					info.setFoodname(sJob.getString("foodname"));
					info.setFoodphotoid(sJob.getString("foodphotoid"));
					FoodList.add(info);
				}
				for (int i = 0; i < commentsArray.length(); i++) {
					JSONObject sJob = commentsArray.getJSONObject(i);
					Comments info = new Comments();
					info.setCid(sJob.getInt("cid"));
					info.setSid(sJob.getInt("sid"));
					info.setPid(sJob.getInt("pid"));
					info.setName(sJob.getString("name"));
					info.setTime(sJob.getString("time"));
					info.setComments(sJob.getString("comments"));
					info.setClevel(sJob.getString("clevel"));
					info.setKouweilevel(sJob.getString("kouweilevel"));
					info.setHuanjinglevel(sJob.getString("huanjinglevel"));
					info.setFuwulevel(sJob.getString("fuwulevel"));
					info.setCpermoney(sJob.getString("cpermoney"));
					CommentsList.add(info);
				}
				for (int i = 0; i < signArray.length(); i++) {
					JSONObject sJob = signArray.getJSONObject(i);
					Sign info = new Sign();
					info.setSignid(sJob.getInt("signid"));
					info.setSid(sJob.getInt("sid"));
					info.setPid(sJob.getInt("pid"));
					info.setName(sJob.getString("name"));
					info.setSigncontent(sJob.getString("signcontent"));
					info.setSignlevel(sJob.getString("signlevel"));
					info.setSignimg(sJob.getString("signimage"));
					info.setSigntime(sJob.getString("signtime"));
					SignList.add(info);
				}
				Log.e("result", "SignList:" + SignList.size() + " CommentsList"
						+ CommentsList.size() + " FoodList" + FoodList.size());
				callback.getList(SignList, CommentsList, FoodList);
			} else {
				callback.getList(SignList, CommentsList, FoodList);
			}
		} catch (JSONException e) {
			callback.getList(SignList, CommentsList, FoodList);
		}
	}

	public List<Sign> getSignList(String value) {
		List<Sign> list = new ArrayList<Sign>();
		try {
			JSONObject job1 = new JSONObject(value);
			JSONObject jdata = job1.getJSONObject("data");
			JSONArray jay = jdata.getJSONArray("shop");
			for (int i = 0; i < jay.length(); i++) {
				JSONObject job = jay.getJSONObject(i);
				Sign info = new Sign();
				info.setName(job.getString("name"));
				info.setSigncontent(job.getString("signcontent"));
				info.setSignimg(job.getString("signimage"));
				info.setSignlevel(job.getString("signlevel"));
				info.setSigntime(job.getString("signtime"));
				list.add(info);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public interface DetailCallBack {
		public void getList(ArrayList<Sign> SignList,
				ArrayList<Comments> CommentsList,
				ArrayList<Food> FoodList);
	}
}
