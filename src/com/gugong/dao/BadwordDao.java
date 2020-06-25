package com.gugong.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.gugong.util.MysqlDataBase;
import java.sql.Statement;


public class BadwordDao {
	public static Map<String, Integer> getdata() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		try {
			Connection connenct = MysqlDataBase.getConnct();
			String sql="select * from badword";
			Statement statement =connenct.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String word=rs.getString(1);
				Integer num=rs.getInt(2);
				map.put(word, num);
			}
			MysqlDataBase.getClose(connenct, statement, rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
