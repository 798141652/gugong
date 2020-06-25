package com.gugong.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONObject;

import com.gugong.model.seasonModel;
import com.gugong.model.wordModel;
import com.gugong.util.MysqlDataBase;
import java.util.Calendar;
public class fristDao {
	public int getYear() {
		/*int num = 0;
		try {

			Connection connct = MysqlDataBase.getConnct();
			String sql = "";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				num = executeQuery.getInt(1);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		int num=19336275;
		return num;
	}
	public int getMonth() {
		int num = 0;
		try {

			Connection connct = MysqlDataBase.getConnct();
			String sql = "select month from monthsum  order by num desc limit 1";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				num = executeQuery.getInt(1);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public int forecast(){//Ô¤²â
		Calendar cal = Calendar.getInstance();
	    int month = cal.get(Calendar.MONTH) + 1;
	    int num[] = new int[3];
	    int i=0;
	    int result=0;
	    try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select month from monthsum order by num desc limit 3";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				num[i]=executeQuery.getInt(1);
				i++;
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    if(month<num[0]&&month>num[1]){
	    	result=num[0];
	    }else if(month<num[2]&&month>num[0]){
	    	result=num[2];
	    }else if(month>num[2]||month<num[1]){
	    	result=num[1];
	    }
	    return result;
	}
	public List<seasonModel> getBusyseason() {//Íú¼¾
		ArrayList<seasonModel> arrayList = new ArrayList<seasonModel>();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select month,num from monthsum  order by num desc limit 3";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				seasonModel tm = new seasonModel();
				tm.setMonth(executeQuery.getInt(1));
				//System.out.print(executeQuery.getInt(1));
				tm.setNum(executeQuery.getInt(2));
				arrayList.add(tm);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrayList;
	}
	public List<seasonModel> getLowseason() {//µ­¼¾
		ArrayList<seasonModel> arrayList = new ArrayList<seasonModel>();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select month,num from monthsum  order by num asc limit 3";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				seasonModel tm = new seasonModel();
				tm.setMonth(executeQuery.getInt(1));
				tm.setNum(executeQuery.getInt(2));
				arrayList.add(tm);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}
	public List<wordModel> getImpression() {//´ÊÔÆ
		ArrayList<wordModel> arrayList = new ArrayList<wordModel>();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select word,num from impression";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				wordModel tm = new wordModel();
				tm.setWord(executeQuery.getString(1));
				tm.setNum(executeQuery.getInt(2));
				arrayList.add(tm);
			}
			MysqlDataBase.getClose(connct, createStatement, executeQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}
}

