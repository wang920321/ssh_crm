/**  

* Title: HibernateTest.java  

* Description:  

* Copyright: Copyright (c) 2017 

* Company: www.baidudu.com 

* @author 172219902  

* @date 2018年4月5日  

* @version 1.0  

*/
package cn.itcast.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

//测试hibernate框架
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	@Resource(name="sessionFactory")
    private SessionFactory sf;
	@Test
	public void fun1(){
    	Configuration conf=new Configuration().configure();
    	SessionFactory sf = conf.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	//-------------------------------------------
    	User user=new User();
    	user.setUser_code("tom");
    	user.setUser_name("汤姆");
    	user.setUser_password("1234");
    	session.save(user);
    	//-------------------------------------------
    	
    	tx.commit();
    	session.close();
    	sf.close();
    }
	@Test
	public void fun2(){
    	
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	//-------------------------------------------
    	User user=new User();
    	user.setUser_code("jerry");
    	user.setUser_name("杰瑞");
    	user.setUser_password("1234");
    	session.save(user);
    	//-------------------------------------------
    	
    	tx.commit();
    	session.close();
    	sf.close();
    }
	@Test
	public void fun3(){
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//-------------------------------------------
		User user=new User();
		user.setUser_code("jack");
		user.setUser_name("杰克");
		user.setUser_password("1234");
		session.save(user);
		//-------------------------------------------
		
		tx.commit();
		session.close();
		sf.close();
	}
	@Test
	public void fun4(){
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//-------------------------------------------
		User user=new User();
		user.setUser_code("rose");
		user.setUser_name("罗斯");
		user.setUser_password("1234");
		session.save(user);
		//-------------------------------------------
		
		tx.commit();
		session.close();
		sf.close();
	}
	//测试Dao Hibernate模板
	@Resource(name="userDao")
	private UserDao userDao;
	@Test
	public void fun5(){
		User user = userDao.getByUserCode("tom");
		System.out.println(user);
	}
	
	//测试aop事务
	@Resource(name="userService")
	private UserService userService;
	@Test
	public void fun6(){
		User user=new User();
		user.setUser_code("lily");
		user.setUser_name("lily");
		user.setUser_password("1234");
		userService.saveUser(user);
	}
}
