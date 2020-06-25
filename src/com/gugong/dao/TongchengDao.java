package com.gugong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.gugong.model.ContextModel;
import com.gugong.util.MysqlDataBase;

public class TongchengDao {
	public static List<Integer> getdata() {
		List<Integer> l = new ArrayList<Integer>();
		try {

			Connection connenct = MysqlDataBase.getConnct();
			String sql1 = "select count(*) from bad_context where corporation like 'tongchen%'";
			String sql2 = "select count(*) from good_context where corporation like 'tongchen%'";
			PreparedStatement st1 = connenct.prepareStatement(sql1);
			PreparedStatement st2 = connenct.prepareStatement(sql2);
			ResultSet rs1 = st1.executeQuery();
			ResultSet rs2 = st2.executeQuery();
			Integer gnum = 0;
			Integer bnum = 0;
			if (rs1.next())
				bnum = rs1.getInt(1);
			if (rs2.next())
				gnum = rs2.getInt(1);
			l.add(gnum);
			l.add(bnum);
			MysqlDataBase.getClose(connenct, st1, rs1);
			MysqlDataBase.getClose(connenct, st2, rs2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	public List<ContextModel> getgoodcontext() throws SQLException{
		List<ContextModel> list=new ArrayList<ContextModel>();
		Connection connct = MysqlDataBase.getConnct();
		String sql = "select * from good_context  where corporation like 'tongchen%' LIMIT 50";
		Statement createStatement = connct.createStatement();
		ResultSet executeQuery = createStatement.executeQuery(sql);
		while (executeQuery.next()) {
			ContextModel cm=new ContextModel();
			cm.setUsername(executeQuery.getString(1));			
			cm.setContext(executeQuery.getString(2));
			cm.setTime(executeQuery.getString(3));
			cm.setCorporation(executeQuery.getString(4));
			list.add(cm);
		}
		
		MysqlDataBase.getClose(connct, createStatement, executeQuery);
		return list;
	}
	public List<ContextModel> getbadcontext() throws SQLException{
		List<ContextModel> list=new ArrayList<ContextModel>();
		Connection connct = MysqlDataBase.getConnct();
		String sql = "select * from bad_context where corporation like 'tongchen%' LIMIT 50";
		Statement createStatement = connct.createStatement();
		ResultSet executeQuery = createStatement.executeQuery(sql);
		while (executeQuery.next()) {
			ContextModel cm=new ContextModel();
			cm.setUsername(executeQuery.getString(1));			
			cm.setContext(executeQuery.getString(2));
			cm.setTime(executeQuery.getString(3));
			cm.setCorporation(executeQuery.getString(4));
			list.add(cm);
		}
		
		MysqlDataBase.getClose(connct, createStatement, executeQuery);
		return list;
	}
}
