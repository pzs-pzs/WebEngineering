package com.dlb.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.dlb.dao.DataDao;

import com.dlb.dao.impl.TradeDaoImpl;
import com.dlb.model.EndData;
import com.dlb.model.RequestForm;
import com.dlb.service.DataService;

public class TradeServeiceImpl implements DataService {
    private  int itemNum=5;//返回一次数据条数
	DataDao dao = null;
    public TradeServeiceImpl() {
		dao=new TradeDaoImpl();
	}
	@Override
	public String getDataToJson(RequestForm rform) {
	    String s = rform.getPage();
	    int page = Integer.parseInt(s);
	   
	    int start = (page-1)*itemNum ;
	    List<EndData> list = dao.getData(start, itemNum);
	   
	    return JSON.toJSONString(list);
 		
	}
	
	@Override
	public String getDataToJsonByid(RequestForm idform){
		String s=idform.getId();
		EndData e=dao.getData(s);
		return JSON.toJSONString(e);
		
	}

	@Override
	public boolean storeJsonDate(EndData data) {
		return dao.storeDate(data);
	}

}
