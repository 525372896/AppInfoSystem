package cn.appsys.controller.developer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.devuser.DevUserService;
import cn.appsys.tools.Constants;

@Controller
@RequestMapping("/dev")
public class LoginContorller {

	Logger logger = Logger.getLogger(LoginContorller.class);
	@Resource
	private DevUserService devUserService;
	
	//进行开发着登录的跳转
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String Login(){
		return "devlogin";
	}
	//验证登陆账号和密码
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String doLogin(@RequestParam String devCode, 
			@RequestParam String devPassword,
			HttpSession session,HttpServletRequest request){
		DevUser devUser = devUserService.existDevUser(devCode, devPassword);
		if(devUser != null){
			session.setAttribute(Constants.DEV_USER_SESSION, devUser);
			return "redirect:/dev/appinfolist";
		}else {	
			request.setAttribute("error","用户名或者密码不正确");
			return "devlogin";
		}
	}
	
	//跳转开发着的主页
	@RequestMapping(value="/appinfolist",method=RequestMethod.GET)
	public String appinfo(HttpSession session){
		return "/developer/main";
	}
	
	//退出当前的开发
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String outLogin(HttpSession session){
		DevUser devUser = (DevUser)session.getAttribute(Constants.DEV_USER_SESSION);
		logger.info("开发着------------->"+devUser.getDevName()+"下线");
		session.removeAttribute(Constants.DEV_USER_SESSION);
		return "devlogin";
	}
}
