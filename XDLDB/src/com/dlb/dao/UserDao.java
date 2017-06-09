package com.dlb.dao;

import com.dlb.model.RegisterUser;

public interface UserDao {

	/**
	 * 
	 * @param user
	 * @return true 登录成功 false登录失败
	 */
	boolean login(RegisterUser user);

    /**
     * 
     * @param user
     * @return true 没有重复用户  false 存在重复用户
     */
	
	boolean checkUser(RegisterUser user);

	/**
	 * 
	 * @param user
	 * @return true 注册成功 false注册失败
	 */
	boolean save(RegisterUser user);

	

}