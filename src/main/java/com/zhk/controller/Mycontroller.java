package com.zhk.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhk.bean.Move;
import com.zhk.bean.Type;
import com.zhk.service.Myservice;

@Controller
public class Mycontroller {

	@Autowired
	private Myservice ms;
	
	@RequestMapping("list.do")
	public String getList(Model model,@RequestParam(defaultValue="1")int cpage,@RequestParam(defaultValue="")String mname ){
		
		PageHelper.startPage(cpage, 2);
		List list=ms.getList(mname);
		
		PageInfo pi =new PageInfo(list);
		
		model.addAttribute("pi", pi);
		model.addAttribute("list", list);
		model.addAttribute("mname", mname);
		
		return "list";
	}
	
	
	@RequestMapping("toadd.do")
	public String toadd(){
		
		return "add";
	}
	
	@RequestMapping("toupdate.do")
	public String toupdate(Model model,@RequestParam(defaultValue="1")String mid){
		
		model.addAttribute("mid", mid);
		
		return "update";
	}
	
	
	
	@RequestMapping("gettypeList.do")
	@ResponseBody
	public Object gettypeList(){
		
		List<Type> list=ms.gettypeList();
		
		return list;
	}
	
	@RequestMapping("add.do")
	public String addmove(Move move,String tids){
		int i=ms.addmove(move,tids);
		
		if(i>0){
			return "redirect:list.do";
		}
		return "error";
	}
	
	@RequestMapping("getmoveById.do")
	@ResponseBody
	public Object getmoveById(@RequestParam(defaultValue="1")String mid){
		
		Map map=ms.getmoveById(mid);
		System.out.println(map);
		return map;
	}
	
	@RequestMapping("updatemove.do")
	public String updatemove(Move move,String tids){
		
		int i=ms.updatemove(move,tids);
		
		if(i>0){
			return "redirect:list.do";
		}
		return "error";
	}
	
		
	@RequestMapping("dels.do")
	public String dels(String mids){
		
		int i=ms.dels(mids);
		
		if(i>0){
			return "redirect:list.do";
		}
		return "error";
	}
}
