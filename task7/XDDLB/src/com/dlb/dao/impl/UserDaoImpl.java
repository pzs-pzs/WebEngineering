package com.dlb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dlb.dao.UserDao;
import com.dlb.model.RegisterUser;

import com.dlb.utils.ConnDB;

public class UserDaoImpl implements UserDao{
	private ConnDB conn = null;

	public UserDaoImpl() {
		conn = new ConnDB();
	}
	
	@SuppressWarnings("unused")
	@Override
	public boolean login(RegisterUser user) {
		int flag = 0;
		String sql = "SELECT * FROM tb_user where username='"+ user.getUsername() + "'";
		
		ResultSet rs = conn.executeQuery(sql);// 鎵цSQL璇彞
		try {
			if (rs.next()) {
				String pwd = user.getPwd();// 鑾峰彇瀵嗙爜
				int uid = rs.getInt(1);// 鑾峰彇绗竴鍒楃殑鏁版嵁
				if (pwd.equals(rs.getString("pwd"))) {
					flag = uid;
					rs.last(); // 瀹氫綅鍒版渶鍚庝竴鏉¤褰�
					int rowSum = rs.getRow();// 鑾峰彇璁板綍鎬绘暟
					rs.first();// 瀹氫綅鍒扮鍑犳潯璁板綍
					if (rowSum != 1) {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();// 杈撳嚭寮傚父淇℃伅
			return false;
		} finally {
			conn.close();// 鍏抽棴鏁版嵁搴撹繛锟�?
		}
		return true;
	}
	

	/**
	 * 鍔熻兘锛氭娴嬬敤鎴峰悕鏄惁涓虹┖
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public boolean checkUser(RegisterUser user) {
		String sql = "SELECT * FROM tb_user where username='"+ user.getUsername() + "'";
		ResultSet rs = conn.executeQuery(sql);// 鎵цSQL璇彞
		try {
			if(rs.next()){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.close(); // 鍏抽棴鏁版嵁搴撹繛鎺�
		}
		return false;
	}
	
	/**
	 * 鍔熻兘锛氫繚瀛樼敤鎴锋敞鍐屼俊鎭�
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public boolean save(RegisterUser user) {
		String sql = "insert into tb_user (username,pwd,email) value ('"+user.getUsername()+"','"+user.getPwd()+"','"+user.getEmail()+"')";
		int result = conn.executeUpdate(sql); // 鎵ц鏇存柊璇彞
		if(result>0){
			conn.close(); // 鍏抽棴鏁版嵁搴撶殑杩炴帴
			return true;
		}else{
			conn.close(); // 鍏抽棴鏁版嵁搴撶殑杩炴帴
			return false;
		}
	}
	
}
