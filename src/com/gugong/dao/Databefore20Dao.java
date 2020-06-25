package com.gugong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gugong.util.MysqlDataBase;

public class Databefore20Dao {
	public List<Integer> getbefore2020data(){
		List<Integer> arraylist=new ArrayList<Integer>();
		try {
			
			Connection connct = MysqlDataBase.getConnct();
			String sql1="select count(*) from context_before20 where time like '%-1-%' or time like '%-01-%'";
			String sql2="select count(*) from context_before20 where time like '%-2-%' or time like '%-02-%'";
			String sql3="select count(*) from context_before20 where time like '%-3-%' or time like '%-03-%'";
			String sql4="select count(*) from context_before20 where time like '%-4-%' or time like '%-04-%'";
			String sql5="select count(*) from context_before20 where time like '%-5-%' or time like '%-05-%'";
			String sql6="select count(*) from context_before20 where time like '%-6-%' or time like '%-06-%'";
			
			PreparedStatement ps1 = connct.prepareStatement(sql1);
			PreparedStatement ps2 = connct.prepareStatement(sql2);
			PreparedStatement ps3 = connct.prepareStatement(sql3);
			PreparedStatement ps4 = connct.prepareStatement(sql4);
			PreparedStatement ps5 = connct.prepareStatement(sql5);
			PreparedStatement ps6 = connct.prepareStatement(sql6);
			
			ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
			ResultSet rs3 = ps3.executeQuery();
			ResultSet rs4 = ps4.executeQuery();
			ResultSet rs5 = ps5.executeQuery();
			ResultSet rs6 = ps6.executeQuery();
			
			if(rs1.next())
				arraylist.add(rs1.getInt(1));
			if(rs2.next())
				arraylist.add(rs2.getInt(1));
			if(rs3.next())
				arraylist.add(rs3.getInt(1));
			if(rs4.next())
				arraylist.add(rs4.getInt(1));
			if(rs5.next())
				arraylist.add(rs5.getInt(1));
			if(rs6.next())
				arraylist.add(rs6.getInt(1));
			
			MysqlDataBase.getClose(connct, ps1, rs1);
			MysqlDataBase.getClose(connct, ps2, rs2);
			MysqlDataBase.getClose(connct, ps3, rs3);
			MysqlDataBase.getClose(connct, ps4, rs4);
			MysqlDataBase.getClose(connct, ps5, rs5);
			MysqlDataBase.getClose(connct, ps6, rs6);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arraylist;
	}

}
