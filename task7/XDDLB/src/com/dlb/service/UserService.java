package com.dlb.service;

import com.dlb.model.RegisterUser;

public interface UserService {

	/**
	 * 
	 * @param user
	 * @return true ��¼�ɹ� false��¼ʧ��
	 */
	boolean login(RegisterUser user);

	/**
	 * 
	 * @param user
	 * @return true ע��ɹ� false ע��ʧ��
	 */
	boolean register(RegisterUser user);

}