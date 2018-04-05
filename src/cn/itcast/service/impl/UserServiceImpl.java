/**  

* Title: UserServiceImpl.java  

* Description:  

* Copyright: Copyright (c) 2017 

* Company: www.baidudu.com 

* @author 172219902  

* @date 2018年4月5日  

* @version 1.0  

*/
package cn.itcast.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService{
	/*@Resource(name="userDao")*/
    private UserDao userDao;
	//登录
	@Override
	public User getUserByCodePassword(User user) {
		//1根据登录名称查询登录用户
		User existUser = userDao.getByUserCode(user.getUser_code());
		//2判断用户是否存在,不存在=》抛出异常,提示用户名不存在
		if(existUser==null){
			throw new RuntimeException("用户名不存在");
		}
		//3判断用户密码是否正确=》不正确=》抛出异常,提示密码错误
		if(!existUser.getUser_password().equals(user.getUser_password())){
			throw new RuntimeException("密码不正确");
		}
		
		//4返回查询到的用户对象
		return existUser;
	}

    //注册
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User user) {
		userDao.save(user);
		
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    
}
