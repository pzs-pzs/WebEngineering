package com.dlb.service.impl;


import com.dlb.dao.UserDao;
import com.dlb.dao.impl.UserDaoImpl;

import com.dlb.model.RegisterUser;
import com.dlb.service.UserService;

public class UserServiceImpl implements UserService {
	    private static UserDao dao ;
	    public UserServiceImpl(){
	     	dao = new UserDaoImpl();
	    }
	    /* (non-Javadoc)
		 * @see com.dlb.service.impl.UserService#login(com.dlb.model.RegisterUser)
		 */
        @Override
		public boolean login(RegisterUser user){
        	if( dao.login(user)){
            	return true;
            }
        	return false;
        }
        /* (non-Javadoc)
		 * @see com.dlb.service.impl.UserService#register(com.dlb.model.RegisterUser)
		 */
        @Override
		public boolean register(RegisterUser user){
        	if(dao.checkUser(user)){
	        	if(dao.save(user)){
	        		return true;
	        	}else{
	        		return false;
	        	}
        	}
        	return false;
        }
}
