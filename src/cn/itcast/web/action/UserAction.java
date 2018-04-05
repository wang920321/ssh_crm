/**  

* Title: UserAction.java  

* Description:  

* Copyright: Copyright (c) 2017 

* Company: www.baidudu.com 

* @author 172219902  

* @date 2018年4月5日  

* @version 1.0  

*/
package cn.itcast.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user=new User();
    private UserService userService;

	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	
	public String login() throws Exception {
		//1调用service执行登录逻辑
		User user1 = userService.getUserByCodePassword(user);
		//2将返回的user对象放入session对象
		ActionContext.getContext().getSession().put("user", user1);
		//3重定向到项目首页
		return "toHome";
	}



	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	
    
}
