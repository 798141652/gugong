package com.gugong.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gugong.model.monthModel;
import com.gugong.util.MysqlDataBase;

public class secondDao {
	public List<monthModel> get17() {//17
		ArrayList<monthModel> arrayList = new ArrayList<monthModel>();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select month,num from c17";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				monthModel tm = new monthModel();
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
	public List<monthModel> get18() {//18
		ArrayList<monthModel> arrayList = new ArrayList<monthModel>();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select month,num from c18";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				monthModel tm = new monthModel();
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
	public List<monthModel> get19() {//19
		ArrayList<monthModel> arrayList = new ArrayList<monthModel>();
		try {
			Connection connct = MysqlDataBase.getConnct();
			String sql = "select month,num from c19";
			Statement createStatement = connct.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while (executeQuery.next()) {
				monthModel tm = new monthModel();
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
	

}
