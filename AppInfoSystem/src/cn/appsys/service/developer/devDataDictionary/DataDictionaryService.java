package cn.appsys.service.developer.devDataDictionary;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.DataDictionary;

public interface DataDictionaryService {

	/**
	 * 获取app状态和所属平台的集合
	 */
	public List<DataDictionary> getAppStatusAndFlatList(String typeCode);

	/**
	 * 获取一，二，三级分类的集合
	 */
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId);
}
