package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.BaseDictDao;
import cn.itcast.pojo.BaseDict;
@Service
@Transactional
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictDao baseDictDao;
	
	//查询下拉列表的内容
	@Override
	public  List<BaseDict> getDictItemCode(String id) throws Exception {
		List<BaseDict> dictItemCode = baseDictDao.getDictItemCode(id);
		return dictItemCode;
	}

}
