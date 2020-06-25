package com.gugong.controller;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gugong.dao.firstDao;
import com.gugong.model.seasonModel;
import com.gugong.model.wordModel;
@Controller
@RequestMapping(value="/frist")
public class firstController {
	@RequestMapping(value="/year.do")
	@ResponseBody
	public int getYear(){
		firstDao gg=new firstDao();
		int year = gg.getYear();
		return year;
	}
	
	@RequestMapping(value="/month.do")
	@ResponseBody
	public int getMonth(){
		firstDao gg=new firstDao();
		int month = gg.getMonth();
		return month;
	}
	@RequestMapping(value="/forecast.do")
	@ResponseBody
	public int getForecast(){
		firstDao gg=new firstDao();
		int  month = gg.forecast();
		return month;
	}
	@RequestMapping(value="/getbusyseason.do",method=RequestMethod.POST)//����
	@ResponseBody
	public JSONObject getBusyseason(){
		firstDao fd=new firstDao();
		  List<seasonModel> bs = fd.getBusyseason();
		  ArrayList<Integer>  month=new ArrayList<Integer>();
		  ArrayList<Double>  num=new ArrayList<Double>();
		  JSONObject json=new JSONObject();
		  for(int i=0;i<bs.size();i++){
			  month.add(bs.get(i).getMonth());
			  double num1;
			  num1=bs.get(i).getNum()/55692;
			  BigDecimal b = new BigDecimal(num1);
			  num1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();    
			  num.add(num1);
		  }
		  json.put("month", month);
		  json.put("num", num);
		return json;
		
	}
	@RequestMapping(value="/getlowseason.do",method=RequestMethod.POST)//����
	@ResponseBody
	public JSONObject getLowseason(){
		firstDao fd=new firstDao();
		  List<seasonModel> ls = fd.getLowseason();
		  ArrayList<Integer>  month=new ArrayList<Integer>();
		  ArrayList<Double>  num=new ArrayList<Double>();
		  JSONObject json=new JSONObject();
		  for(int i=0;i<ls.size();i++){
			  month.add(ls.get(i).getMonth());
			  double num1;
			  num1=ls.get(i).getNum()/55692;
			  BigDecimal b = new BigDecimal(num1);
			  num1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();    
			  num.add(num1);
		  }
		  json.put("month", month);
		  json.put("num", num);
		return json;
	}
	@RequestMapping(value="/getimpression.do",method=RequestMethod.POST)//
	@ResponseBody
	public JSONObject getImpression(){
		firstDao fd=new firstDao();
		  List<wordModel> ls = fd.getImpression();
		  List<String>  word=new ArrayList<String>();
		  List<Integer>  num=new ArrayList<Integer>();
		  JSONObject json=new JSONObject();
		  for(int i=0;i<ls.size();i++){
			  word.add(ls.get(i).getWord());
			  num.add(ls.get(i).getNum());
			  //System.out.print(ls.get(i).getNum());
		  }
		  json.put("word", word);
		  json.put("num", num);
		return json;
	}
}
