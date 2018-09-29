package cn.appsys.controller.developer;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.devDataDictionary.DataDictionaryService;
import cn.appsys.service.developer.devInfo.DevInfoService;
import cn.appsys.tools.Constants;
import cn.appsys.tools.PageSupport;

@Controller
@RequestMapping("/dev/flatform/app")
public class AppInfoController {

	Logger logger = Logger.getLogger(AppInfoController.class);
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private DevInfoService appInfoService;
	
	//app维护跳转 主页列表
		@RequestMapping(value="/list")
		public String appList(Model model,
				HttpSession session,
				@RequestParam(value="querySoftwareName",required=false) String querySoftwareName,
				@RequestParam(value="queryStatus",required=false) String _queryStatus,
				@RequestParam(value="queryCategoryLevel1",required=false) String _queryCategoryLevel1,
				@RequestParam(value="queryCategoryLevel2",required=false) String _queryCategoryLevel2,
				@RequestParam(value="queryCategoryLevel3",required=false) String _queryCategoryLevel3,
				@RequestParam(value="queryFlatformId",required=false) String _queryFlatformId,
				@RequestParam(value="pageIndex",required=false) String pageIndex){
				//设置当前页数
				int currentPageNo = 1;
				//设置每页的数量
				int pageSize = Constants.pageSize;
				if(pageIndex != null){
					currentPageNo = Integer.valueOf(pageIndex);
				}
				
				Integer queryStatus = null;
				if(_queryStatus != null && !_queryStatus.equals("")){
					queryStatus = Integer.parseInt(_queryStatus);
				}
				Integer queryCategoryLevel1 = null;
				if(_queryCategoryLevel1 != null && !_queryCategoryLevel1.equals("")){
					queryCategoryLevel1 = Integer.parseInt(_queryCategoryLevel1);
				}
				Integer queryCategoryLevel2 = null;
				if(_queryCategoryLevel2 != null && !_queryCategoryLevel2.equals("")){
					queryCategoryLevel2 = Integer.parseInt(_queryCategoryLevel2);
				}
				Integer queryCategoryLevel3 = null;
				if(_queryCategoryLevel3 != null && !_queryCategoryLevel3.equals("")){
					queryCategoryLevel3 = Integer.parseInt(_queryCategoryLevel3);
				}
				Integer queryFlatformId = null;
				if(_queryFlatformId != null && !_queryFlatformId.equals("")){
					queryFlatformId = Integer.parseInt(_queryFlatformId);
				}
				
				Integer devId = ((DevUser)session.getAttribute(Constants.DEV_USER_SESSION)).getId();
				//总数量（表）
				int totalCount = appInfoService.getAppInfoCount(querySoftwareName, queryFlatformId, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryStatus, devId);
				PageSupport pages = new PageSupport();
				pages.setCurrentPageNo(currentPageNo);
				pages.setPageSize(pageSize);
				//总页数
				pages.setTotalCount(totalCount);
				int totalPageCount = pages.getTotalPageCount();
				//控制首页和尾页
				if(currentPageNo < 1){
					currentPageNo = 1;
				}else if(currentPageNo > totalPageCount){
					currentPageNo = totalPageCount;
				}
				//获取app状态的集合
				List<DataDictionary> statusList = null;
				statusList = dataDictionaryService.getAppStatusAndFlatList("APP_STATUS");
				model.addAttribute("statusList",statusList);
				//获取所属平台的集合
				List<DataDictionary> flatFormList = null;
				flatFormList = dataDictionaryService.getAppStatusAndFlatList("APP_FLATFORM");
				model.addAttribute("flatFormList",flatFormList);
				//获取一级列表
				List<AppCategory> categoryLevel1List = null;
				categoryLevel1List = dataDictionaryService.getAppCategoryListByParentId(null);
				model.addAttribute("categoryLevel1List",categoryLevel1List);
				//获取app信息的集合
				List<AppInfo> appInfoList = null;
				appInfoList = appInfoService.getAppInfoList(querySoftwareName, queryFlatformId, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryStatus, devId, currentPageNo, pageSize);
				model.addAttribute("appInfoList", appInfoList);
				
				model.addAttribute("pages", pages);
				model.addAttribute("queryStatus", queryStatus);
				model.addAttribute("querySoftwareName", querySoftwareName);
				model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);
				model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);
				model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);
				model.addAttribute("queryFlatformId", queryFlatformId);
				return "/developer/appinfolist";	
		}
		
		//一级分类改变发生跳转ajax
		@RequestMapping(value="/categorylevellist.json",method=RequestMethod.GET)
		@ResponseBody
		public List<AppCategory> getDataDicList (@RequestParam String pid){
			logger.debug("getDataDicList tcode ============ " + pid);
			if(pid.equals("")){
				pid = null;
			}
			return dataDictionaryService.getAppCategoryListByParentId(Integer.parseInt(pid));
		}
}
