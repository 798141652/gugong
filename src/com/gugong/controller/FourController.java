package com.gugong.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gugong.dao.BadwordDao;
import com.gugong.dao.GoodwordDao;
import com.gugong.dao.MeituanDao;
import com.gugong.dao.XiechengDao;
import com.gugong.model.ContextModel;
import com.gugong.dao.TongchengDao;
import com.gugong.dao.QunaerDao;
import com.gugong.dao.TuniuDao;


@Controller
@RequestMapping(value="/four")
public class FourController {
	
	@RequestMapping(value="/badcontext.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getbadcontext(){
		Map<String, Integer> map = BadwordDao.getdata();
		ArrayList<Integer> num = new ArrayList<Integer>();
		ArrayList<String> word = new ArrayList<String>();
		JSONObject jsob=new JSONObject();
		for (Entry<String, Integer> entry : map.entrySet()) {
			
			num.add(entry.getValue());
			word.add(entry.getKey());
		}
		jsob.put("word", word);
		jsob.put("num", num);
		return jsob;
	}
	
	@RequestMapping(value="/goodcontext.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getgoodcontext(){
		Map<String, Integer> map = GoodwordDao.getdata();
		ArrayList<Integer> num = new ArrayList<Integer>();
		ArrayList<String> word = new ArrayList<String>();
		JSONObject jsob=new JSONObject();
		for (Entry<String, Integer> entry : map.entrySet()) {
			
			num.add(entry.getValue());
			word.add(entry.getKey());
		}
		jsob.put("word", word);
		jsob.put("num", num);
		return jsob;
	}
	
	@RequestMapping(value="/meituan.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getmeituancontext(){
		List<Integer> l =MeituanDao.getdata();
		JSONObject jb=new JSONObject();
		jb.put("good", l.get(0));
		jb.put("bad", l.get(1));
		return jb;
	}
	
	@RequestMapping(value="/xiecheng.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getxiechengcontext(){
		List<Integer> l =XiechengDao.getdata();
		JSONObject jb=new JSONObject();
		jb.put("good", l.get(0));
		jb.put("bad", l.get(1));
		return jb;
	}
	
	@RequestMapping(value="/tongcheng.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject gettongchengcontext(){
		List<Integer> l =TongchengDao.getdata();
		JSONObject jb=new JSONObject();
		jb.put("good", l.get(0));
		jb.put("bad", l.get(1));
		return jb;
	}
	
	@RequestMapping(value="/qunaer.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getqunaercontext(){
		List<Integer> l =QunaerDao.getdata();
		JSONObject jb=new JSONObject();
		jb.put("good", l.get(0));
		jb.put("bad", l.get(1));
		return jb;
	}
	
	@RequestMapping(value="/tuniu.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject gettuniucontext(){
		List<Integer> l =TuniuDao.getdata();
		JSONObject jb=new JSONObject();
		jb.put("good", l.get(0));
		jb.put("bad", l.get(1));
		return jb;
	}
	
	@RequestMapping(value="/meituanbad.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getmeituanbad() throws SQLException {
		MeituanDao mt=new MeituanDao();
		List<ContextModel> list=mt.getbadcontext();
		JSONObject jObject=new JSONObject();
		jObject.put("list",list);
		return jObject;
	}
	
	@RequestMapping(value="/meituangood.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getmeituangood() throws SQLException {
		MeituanDao mt=new MeituanDao();
		List<ContextModel> list=mt.getgoodcontext();
		JSONObject jObject=new JSONObject();
		jObject.put("list",list);
		return jObject;
	}
	
	@RequestMapping(value="/tuniubad.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject gettuniubad() throws SQLException {
		TuniuDao  tn=new TuniuDao();
		List<ContextModel> list=tn.getbadcontext();
		JSONObject jObject=new JSONObject();
		jObject.put("list",list);
		return jObject;
	}
	
	@RequestMapping(value="/tuniugood.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject gettuniugood() throws SQLException {
		TuniuDao  tn=new TuniuDao();
		List<ContextModel> list=tn.getgoodcontext();
		JSONObject jObject=new JSONObject();
		jObject.put("list",list);
		return jObject;
	}
	
	@RequestMapping(value="/tongchengbad.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject gettongchengbad() throws SQLException {
		TongchengDao tc=new TongchengDao();
		List<ContextModel> list=tc.getbadcontext();
		JSONObject jObject=new JSONObject();
		jObject.put("list",list);
		return jObject;
	}
	
	@RequestMapping(value="/tongchenggood.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject gettongchenggood() throws SQLException {
		TongchengDao tc=new TongchengDao();
		List<ContextModel> list=tc.getgoodcontext();
		JSONObject jObject=new JSONObject();
		jObject.put("list",list);
		return jObject;
	}
	
	@RequestMapping(value="/xiechengbad.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getxiechengbad() throws SQLException {
		XiechengDao xc=new XiechengDao();
		List<ContextModel> list=xc.getbadcontext();
		JSONObject jObject=new JSONObject();
		jObject.put("list",list);
		return jObject;
	}
	
	@RequestMapping(value="/xiechenggood.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getxiechenggood() throws SQLException {
		XiechengDao xc=new XiechengDao();
		List<ContextModel> list=xc.getgoodcontext();
		JSONObject jObject=new JSONObject();
		jObject.put("list",list);
		return jObject;
	}
	
	@RequestMapping(value="/qunaerbad.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getqunaerbad() throws SQLException {
		QunaerDao qn=new QunaerDao();
		List<ContextModel> list=qn.getbadcontext();
		JSONObject jObject=new JSONObject();
		jObject.put("list",list);
		return jObject;
	}
	
	@RequestMapping(value="/qunaergood.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getqunaergood() throws SQLException {
		QunaerDao qn=new QunaerDao();
		List<ContextModel> list=qn.getgoodcontext();
		JSONObject jObject=new JSONObject();
		jObject.put("list",list);
		return jObject;
	}
}
