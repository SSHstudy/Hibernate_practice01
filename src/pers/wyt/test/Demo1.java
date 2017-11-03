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
	 * ���Ա���
	 */
	@Test
	public void testSave3() {
		Session session = null;
		Transaction tr = null;
		try {
			//��ȡSession
			session = HibernateUtils.getSession();
			tr = session.beginTransaction();
			Customer c = new Customer();
			c.setCust_name("abc");
			session.save(c);
			tr.commit();
		}catch(Exception e) {
			//�ع�����
			tr.rollback();
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
			session.close();
		}
		
	}
	
	@Test
	public void testQuery() {
		
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		Query query = session.createQuery("from Customer");
		//��ѯ��������
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
		
		//arg0��ѯJavaBean��class����,arg1������ֵ
		Customer c = session.get(Customer.class, 2L);
	  
		c.setCust_name("bb");
		session.update(c);
	    tr.commit();
	    session.close();
	}
	
	
	/**
	 * ɾ�����޸ģ��Ȳ�ѯ��ɾ�����޸�
	 */
	@Test
	public void testDel() {
		
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		//arg0��ѯJavaBean��class����,arg1������ֵ
		Customer c = session.get(Customer.class, 3L);
	  
		//ɾ��
		session.delete(c);
		System.out.println(c);
	    tr.commit();
	    session.close();
	}
	
	/**
	 * ͨ��������һ����¼
	 */
	@Test
	public void testGet() {
		
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		//arg0��ѯJavaBean��class����,arg1������ֵ
		Customer c = session.get(Customer.class, 3L);
	  
		System.out.println(c);
	    tr.commit();
	    session.close();
	}
	
	
	/**
	 * ���Թ�����
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
	 * ���Ա���ͻ�
	 */
	@Test
	public void testSave() {
		
		/**
		 * 1.�ȼ��������ļ�
		 * 2.����SessionFactory��������Session
		 * 3.����session����
		 * 4.��������
		 * 5.��д�������
		 * 6.�ύ����
		 * 7.�ͷ���Դ
		 */
		
		//1.�ȼ��������ļ�
		//Configuration config = new Configuration();
		//Ĭ�ϼ���srcĿ¼��hibernate.cf.xml�������ļ�
		//config.configure();
		//��д��ʽ��������
		Configuration config = new Configuration().configure();
		
		
		//2.����SessionFactory��������Session
		SessionFactory factory = config.buildSessionFactory();
		
		//3.����session���󣬳־û�����ʵ����ɾ�Ĳ�
		Session session = factory.openSession();
		
		//4.��������
		
		Transaction tr = session.beginTransaction();
		
		//5.��д�������
		Customer c = new Customer();
		//�����Զ�����
		c.setCust_name("����3");
		c.setCust_level("2");
		c.setCust_phone("123");
		
		//�������ݣ�����������൱�ڲ������ݿ��ṹ
		session.save(c);
		
		//6.�ύ����
		tr.commit();
		//7.�ͷ���Դ
		session.close();
		factory.close();
	}

}
