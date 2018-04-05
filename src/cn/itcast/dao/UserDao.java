/**  

* Title: UserDao.java  

* Description:  

* Copyright: Copyright (c) 2017 

* Company: www.baidudu.com 

* @author 172219902  

* @date 2018年4月5日  

* @version 1.0  

*/
package cn.itcast.dao;

import cn.itcast.domain.User;

/**  

* Title: UserDao  

* Description:   

* @author 172219902  

* @date 2018年4月5日  

*/
public interface UserDao {
    //根据登录名称查询user对象
	User getByUserCode(String usercode);

	/**  
	
	 * Title: save  
	
	 * Description:  
	
	 * @param user  
	
	 */ 
	void save(User user);
}
