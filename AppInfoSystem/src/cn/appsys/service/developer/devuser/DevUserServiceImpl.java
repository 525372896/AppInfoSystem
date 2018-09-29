package cn.appsys.service.developer.devuser;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.devuser.DevUserMapper;
import cn.appsys.pojo.DevUser;

@Service
public class DevUserServiceImpl implements DevUserService{

	@Resource
	private DevUserMapper devUserMapper;
	
	/*
	 * 根据用户名和密码判断用户是否存在
	 */
	@Override
	public DevUser existDevUser(String devCode, String devPassword) {
		// TODO Auto-generated method stub
		return devUserMapper.existDevUser(devCode, devPassword);
	}
}
