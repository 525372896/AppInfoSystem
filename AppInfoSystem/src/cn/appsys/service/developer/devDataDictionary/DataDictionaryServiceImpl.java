package cn.appsys.service.developer.devDataDictionary;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.datadictionary.DevDataDictionaryMapper;
import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.DataDictionary;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService{

	@Resource
	private DevDataDictionaryMapper devDataDictionaryMapper;
	
	/**
	 * 获取app状态和所属平台的集合
	 */
	@Override
	public List<DataDictionary> getAppStatusAndFlatList(String typeCode) {
		// TODO Auto-generated method stub
		return devDataDictionaryMapper.getAppStatusAndFlatList(typeCode);
	}

	/**
	 * 获取一，二，三级分类的集合
	 */
	@Override
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId) {
		// TODO Auto-generated method stub
		return devDataDictionaryMapper.getAppCategoryListByParentId(parentId);
	}

}
