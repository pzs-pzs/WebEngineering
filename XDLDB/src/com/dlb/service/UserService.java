package com.dlb.service;

import com.dlb.model.RegisterUser;

public interface UserService {

	/**
	 * 
	 * @param user
	 * @return true µÇÂ¼³É¹¦ falseµÇÂ¼Ê§°Ü
	 */
	boolean login(RegisterUser user);

	/**
	 * 
	 * @param user
	 * @return true ×¢²á³É¹¦ false ×¢²áÊ§°Ü
	 */
	boolean register(RegisterUser user);

}