package com.dlb.dao;

import java.util.List;

import com.dlb.model.EndData;

public interface DataDao {
	 /**
	  * 
	  *  ��ѯָ��λ������
	  * @param start ������ʼλ�� 
	  * @param offset ��ѯ����
	  * @return  ָ�����ݼ���
	  */
     public List<EndData> getData(int start,int offset);
     /**
      * ��data����д�����ݿ�
      * @param data
      * @return true д��ɹ�  false д��ʧ��
      */
     public boolean storeDate(EndData data);
     
     public EndData getData(String id);
}
