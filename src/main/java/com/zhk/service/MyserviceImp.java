package com.zhk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhk.bean.Move;
import com.zhk.bean.Type;
import com.zhk.dao.MyDao;

@Service
public class MyserviceImp implements Myservice {

	@Autowired
	private MyDao dao;

	@Override
	public List getList(String mname) {
		// TODO Auto-generated method stub
		return dao.getList(mname);
	}

	@Override
	public List<Type> gettypeList() {
		// TODO Auto-generated method stub
		return dao.gettypeList();
	}

	@Override
	public int addmove(Move move, String tids) {
		int i=dao.addmove(move);
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("mid", move.getMid());
		map.put("tids", tids.split(","));
		i=dao.addmid(map);
		return i;
	}

	@Override
	public Map getmoveById(String mid) {
		// TODO Auto-generated method stub
		return dao.getmoveById(mid);
	}

	@Override
	public int updatemove(Move move, String tids) {
		int i=dao.updatemove(move);
		i=dao.delmid(move.getMid());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("mid", move.getMid());
		map.put("tids", tids.split(","));
		i=dao.addmid(map);
		return i;
	}

	@Override
	public int dels(String mids) {
		int i=dao.dels(mids);
		i=dao.delmids(mids);
		return i;
	}
}
