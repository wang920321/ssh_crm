/**  

* Title: UserService.java  

* Description:  

* Copyright: Copyright (c) 2017 

* Company: www.baidudu.com 

* @author 172219902  

* @date 2018年4月5日  

* @version 1.0  

*/
package cn.itcast.service;

import cn.itcast.domain.User;

/**  

* Title: UserService  

* Description:   

* @author 172219902  

* @date 2018年4月5日  

*/
public interface UserService {
    User getUserByCodePassword(User user);
    void saveUser(User user);
}
