package cn.appsys.dao.devuser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

public interface DevUserMapper {

	/*
	 * 根据用户名和密码判断用户是否存在
	 */
	public DevUser existDevUser(@Param("devCode")String devCode,@Param("devPassword")String devPassword);
}
