package cn.appsys.service.developer.devInfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;

public interface DevInfoService {

	/**
	 * 分页获取所有的app信息
	 */
	public List<AppInfo> getAppInfoList(String softwareName,Integer flatformId,Integer categoryLevel1,Integer categoryLevel2,Integer categoryLevel3,Integer Status,Integer devId,Integer currentPageNo,Integer pageSize);
	
	/**
	 * 获取所有app信息数量
	 */
	public int getAppInfoCount(String softwareName,Integer flatformId,Integer categoryLevel1,Integer categoryLevel2,Integer categoryLevel3,Integer Status,Integer devId);
}
