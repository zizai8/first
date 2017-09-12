package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.BaseDict;

public interface BaseDictService {

	//查询下拉列表的内容
	public  List<BaseDict> getDictItemCode(String id)throws Exception;
}
