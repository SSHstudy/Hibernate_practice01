package pers.wyt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import pers.wyt.domain.Customer;
import pers.wyt.utils.HibernateUtils;

public class Demo1 {
	
	/**
	 * 测试保存
	 */
	@Test
	public void testSave3() {
		Session session = null;
		Transaction tr = null;
		try {
			//获取Session
			session = HibernateUtils.getSession();
			tr = session.beginTransaction();
			Customer c = new Customer();
			c.setCust_name("abc");
			session.save(c);
			tr.commit();
		}catch(Exception e) {
			//回滚事务
			tr.rollback();
			e.printStackTrace();
		}finally {
			//释放资源
			session.close();
		}
		
	}
	
	@Test
	public void testQuery() {
		
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		Query query = session.createQuery("from Customer");
		//查询所有数据
		List<Customer> list = query.list();
	  
		for(Customer customer:list) {
			System.out.println(customer);
		}
		
	    tr.commit();
	    session.close();
	}
	
	@Test
	public void testUpdate() {
		
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		//arg0查询JavaBean的class对象,arg1主键的值
		Customer c = session.get(Customer.class, 2L);
	  
		c.setCust_name("bb");
		session.update(c);
	    tr.commit();
	    session.close();
	}
	
	
	/**
	 * 删除或修改，先查询再删除或修改
	 */
	@Test
	public void testDel() {
		
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		//arg0查询JavaBean的class对象,arg1主键的值
		Customer c = session.get(Customer.class, 3L);
	  
		//删除
		session.delete(c);
		System.out.println(c);
	    tr.commit();
	    session.close();
	}
	
	/**
	 * 通过主键查一条记录
	 */
	@Test
	public void testGet() {
		
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		//arg0查询JavaBean的class对象,arg1主键的值
		Customer c = session.get(Customer.class, 3L);
	  
		System.out.println(c);
	    tr.commit();
	    session.close();
	}
	
	
	/**
	 * 测试工具类
	 */
	@Test
	public void testSave2() {
		
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
	    Customer c = new Customer();
	    c.setCust_name("aa");
	    session.save(c);
	    tr.commit();
	    session.close();
	}
	
	
	
	
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
		//Configuration config = new Configuration();
		//默认加载src目录下hibernate.cf.xml的配置文件
		//config.configure();
		//简写方式，方法链
		Configuration config = new Configuration().configure();
		
		
		//2.创建SessionFactory对象，生成Session
		SessionFactory factory = config.buildSessionFactory();
		
		//3.创建session对象，持久化对象，实现增删改查
		Session session = factory.openSession();
		
		//4.开启事务
		
		Transaction tr = session.beginTransaction();
		
		//5.编写保存代码
		Customer c = new Customer();
		//主键自动递增
		c.setCust_name("测试3");
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
