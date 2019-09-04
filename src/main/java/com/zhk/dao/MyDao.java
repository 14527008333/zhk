package com.zhk.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhk.bean.Move;
import com.zhk.bean.Type;

public interface MyDao {

	List getList(@Param("mname")String mname);

	List<Type> gettypeList();

	int addmove(Move move);

	int addmid(Map<String, Object> map);

	Map getmoveById(String mid);

	int updatemove(Move move);

	int delmids(String mids);

	int dels(String mids);

	int delmid(Integer mid);

}
