package cn.appsys.dao.datadictionary;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.DataDictionary;


public interface DevDataDictionaryMapper {

	/**
	 * 获取app状态和所属平台的集合
	 */
	public List<DataDictionary> getAppStatusAndFlatList(@Param("typeCode")String typeCode);

	/**
	 * 获取一，二，三级分类的集合
	 */
	public List<AppCategory> getAppCategoryListByParentId(@Param("parentId")Integer parentId);
}
