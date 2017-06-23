package com.dlb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.dlb.dao.DataDao;
import com.dlb.model.EndData;
import com.dlb.utils.ConnDB;

public class InformDaoImpl implements DataDao{
	private ConnDB conn = null;

	public InformDaoImpl() {
		conn = new ConnDB();
	}
	@Override
	public List<EndData> getData(int start, int offset) {
		List<EndData> list = new ArrayList<EndData>();
		String sql = "Select * from tb_inform  order by time desc limit "+start+","+offset;
		ResultSet rs = conn.executeQuery(sql);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			while(rs.next()){
				EndData temp = new EndData();
				temp.setTitle(rs.getString("title"));
				temp.setUsername(rs.getString("username"));
				temp.setTime(rs.getTimestamp("time").toString());
				temp.setText(rs.getString("text"));
				temp.setId(rs.getInt("id"));
				list.add(temp);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return null;
	}
	
	@Override
	public EndData getData(String id) {
			
			String sql = "Select * from tb_inform where id="+id;
			ResultSet rs = conn.executeQuery(sql);
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			EndData temp = new EndData();
			try {
				rs.next();
				temp.setTitle(rs.getString("title"));
				temp.setUsername(rs.getString("username"));
				temp.setTime(rs.getTimestamp("time").toString());
				temp.setText(rs.getString("text"));
				temp.setId(rs.getInt("id"));
				
				return temp;
				}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn.close();
			}
			return null;
		}

	@Override
	public boolean storeDate(EndData data) {
		String sql = "insert into tb_inform (title,username,time,text) value "
				+ "('"+data.getTitle()+"','"+data.getUsername()+"','"+Timestamp.valueOf(data.getTime())+"','"+data.getText()+"')";
		int result = conn.executeUpdate(sql);
		if(result>0){
			conn.close();
			return true;
		}else{
			conn.close();
			return false;
		}
	}

}
