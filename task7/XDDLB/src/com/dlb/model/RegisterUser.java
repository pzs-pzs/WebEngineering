package com.dlb.model;
/**
 * 注册用户信息
 * @author puzhengsong
 *
 */
public class RegisterUser {
       	private String username = null; 
       	private String pwd = null;
       	private String email = null;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@Override
		public String toString(){
			return username+"/"+pwd;
		}
}
