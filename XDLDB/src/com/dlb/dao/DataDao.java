package com.dlb.dao;

import java.util.List;

import com.dlb.model.EndData;

public interface DataDao {
	 /**
	  * 
	  *  查询指定位置数据
	  * @param start 数据起始位置 
	  * @param offset 查询条数
	  * @return  指定数据集合
	  */
     public List<EndData> getData(int start,int offset);
     /**
      * 将data内容写入数据库
      * @param data
      * @return true 写入成功  false 写入失败
      */
     public boolean storeDate(EndData data);
     
     public EndData getData(String id);
}
