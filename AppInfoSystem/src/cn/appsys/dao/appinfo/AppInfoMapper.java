package cn.appsys.dao.appinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;

public interface AppInfoMapper {

	/**
	 * 分页获取所有的app信息
	 */
	public List<AppInfo> getAppInfoList(@Param(value="softwareName")String softwareName,
			@Param(value="flatformId")Integer flatformId,
			@Param(value="categoryLevel1")Integer categoryLevel1,
			@Param(value="categoryLevel2")Integer categoryLevel2,
			@Param(value="categoryLevel3")Integer categoryLevel3,
			@Param(value="status")Integer Status,
			@Param(value="devId")Integer devId,
			@Param(value="from")Integer currentPageNo,
			@Param(value="pageSize")Integer pageSize);
	
	/**
	 * 获取app信息的集合数量
	 */
	public int getAppInfoCount(@Param(value="softwareName")String softwareName,
			@Param(value="flatformId")Integer flatformId,
			@Param(value="categoryLevel1")Integer categoryLevel1,
			@Param(value="categoryLevel2")Integer categoryLevel2,
			@Param(value="categoryLevel3")Integer categoryLevel3,
			@Param(value="status")Integer Status,
			@Param(value="devId")Integer devId);
}
