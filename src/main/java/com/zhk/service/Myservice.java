package com.zhk.service;

import java.util.List;
import java.util.Map;

import com.zhk.bean.Move;
import com.zhk.bean.Type;

public interface Myservice {

	List getList(String mname);

	List<Type> gettypeList();

	int addmove(Move move, String tids);

	Map getmoveById(String mid);

	int updatemove(Move move, String tids);

	int dels(String mids);

}
