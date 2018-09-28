package cn.appsys.service.developer.devuser;

import cn.appsys.pojo.DevUser;

public interface DevUserService {

	/*
	 * 根据用户名和密码判断用户是否存在
	 */
	public DevUser existDevUser(String devCode,String devPassword);
}
