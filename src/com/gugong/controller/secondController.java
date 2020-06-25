package com.gugong.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gugong.dao.secondDao;
import com.gugong.model.monthModel;

import net.sf.json.JSONObject;
@Controller
@RequestMapping(value="/second")
public class secondController {
	@RequestMapping(value="/get17.do",method=RequestMethod.POST)//17
	@ResponseBody
	public JSONObject get17(){
		secondDao fd=new secondDao();
		  List<monthModel> bs = fd.get17();
		  ArrayList<Integer>  month=new ArrayList<Integer>();
		  ArrayList<Double>  num=new ArrayList<Double>();
		  JSONObject json=new JSONObject();
		  for(int i=0;i<bs.size();i++){
			  month.add(bs.get(i).getMonth());
			  double num1;
			  num1=bs.get(i).getNum()/7000;
			  BigDecimal b = new BigDecimal(num1);
			  num1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();    
			  num.add(num1);
		  }
		  json.put("month", month);
		  json.put("num", num);
		return json;
	}
	@RequestMapping(value="/get18.do",method=RequestMethod.POST)//18
	@ResponseBody
	public JSONObject get18(){
		secondDao fd=new secondDao();
		  List<monthModel> bs = fd.get18();
		  ArrayList<Integer>  month=new ArrayList<Integer>();
		  ArrayList<Double>  num=new ArrayList<Double>();
		  JSONObject json=new JSONObject();
		  for(int i=0;i<bs.size();i++){
			  month.add(bs.get(i).getMonth());
			  double num1;
			  num1=bs.get(i).getNum()/20081;
			  BigDecimal b = new BigDecimal(num1);
			  num1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();    
			  num.add(num1);
		  }
		  json.put("month", month);
		  json.put("num", num);
		return json;
	}
	@RequestMapping(value="/get19.do",method=RequestMethod.POST)//19
	@ResponseBody
	public JSONObject get19(){
		secondDao fd=new secondDao();
		  List<monthModel> bs = fd.get19();
		  ArrayList<Integer>  month=new ArrayList<Integer>();
		  ArrayList<Double>  num=new ArrayList<Double>();
		  JSONObject json=new JSONObject();
		  for(int i=0;i<bs.size();i++){
			  month.add(bs.get(i).getMonth());
			  double num1;
			  num1=bs.get(i).getNum()/18140;
			  BigDecimal b = new BigDecimal(num1);
			  num1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();    
			  num.add(num1);
		  }
		  json.put("month", month);
		  json.put("num", num);
		return json;
		
	}

}
