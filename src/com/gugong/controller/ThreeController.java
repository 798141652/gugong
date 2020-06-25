package com.gugong.controller;


import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import com.gugong.dao.Data2020Dao;
import com.gugong.dao.Databefore20Dao;

import net.sf.json.JSONObject;
@Controller
@RequestMapping(value="/three")
public class ThreeController {
	@RequestMapping(value="/q.do")
	@ResponseBody
    public JSONObject get2020(){
		Data2020Dao d1 = new Data2020Dao();
		Databefore20Dao d2=new Databefore20Dao();
		List<Integer> d2020=d1.get2020data();
		List<Integer> db2020=d2.getbefore2020data();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("d1",d2020);
		jsonObject.put("d2",db2020);
		return jsonObject;
	}
	
}

