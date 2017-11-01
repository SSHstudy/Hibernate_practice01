package pers.wyt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import pers.wyt.domain.Customer;

public class Demo1 {
	/*
	 * 测试保存客户
	 */
	@Test
	public void testSave() {
		/**
		 * 1.先加载配置文件
		 * 2.创建SessionFactory对象，生成Session
		 * 3.创建session对象
		 * 4.开启事务
		 * 5.编写保存代码
		 * 6.提交事务
		 * 7.释放资源
		 */
		
		//1.先加载配置文件
		Configuration config = new Configuration();
		//默认加载src目录下hibernate.cf.xml的配置文件
		config.configure();
		
		//2.创建SessionFactory对象，生成Session
		SessionFactory factory = config.buildSessionFactory();
		
		//3.创建session对象，持久化对象，实现增删改查
		Session session = factory.openSession();
		
		//4.开启事务
		
		Transaction tr = session.beginTransaction();
		
		//5.编写保存代码
		Customer c = new Customer();
		//主键自动递增
		c.setCust_name("测试");
		c.setCust_level("2");
		c.setCust_phone("123");
		
		//保存数据，操作对象就相当于操作数据库表结构
		session.save(c);
		
		//6.提交事务
		tr.commit();
		//7.释放资源
		session.close();
		factory.close();
	}

}
