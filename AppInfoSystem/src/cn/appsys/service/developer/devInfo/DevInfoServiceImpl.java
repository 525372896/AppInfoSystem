package cn.appsys.service.developer.devInfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.appinfo.AppInfoMapper;
import cn.appsys.pojo.AppInfo;

@Service
public class DevInfoServiceImpl implements DevInfoService{

	@Resource
	private AppInfoMapper appInfoMapper;
	/**
	 * 分页获得app信息集合
	 */
	@Override
	public List<AppInfo> getAppInfoList(String softwareName,
			Integer flatformId, Integer categoryLevel1, Integer categoryLevel2,
			Integer categoryLevel3, Integer Status, Integer devId,
			Integer currentPageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return appInfoMapper.getAppInfoList(softwareName, flatformId, categoryLevel1, categoryLevel2, categoryLevel3, Status, devId, (currentPageNo-1)*pageSize, pageSize);
	}
	
	/**
	 * 获取app的信息数量
	 */
	@Override
	public int getAppInfoCount(String softwareName, Integer flatformId,
			Integer categoryLevel1, Integer categoryLevel2,
			Integer categoryLevel3, Integer Status, Integer devId) {
		// TODO Auto-generated method stub
		return appInfoMapper.getAppInfoCount(softwareName, flatformId, categoryLevel1, categoryLevel2, categoryLevel3, Status, devId);
	}

}
