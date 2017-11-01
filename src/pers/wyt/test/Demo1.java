package pers.wyt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import pers.wyt.domain.Customer;

public class Demo1 {
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
		Configuration config = new Configuration();
		//Ĭ�ϼ���srcĿ¼��hibernate.cf.xml�������ļ�
		config.configure();
		
		//2.����SessionFactory��������Session
		SessionFactory factory = config.buildSessionFactory();
		
		//3.����session���󣬳־û�����ʵ����ɾ�Ĳ�
		Session session = factory.openSession();
		
		//4.��������
		
		Transaction tr = session.beginTransaction();
		
		//5.��д�������
		Customer c = new Customer();
		//�����Զ�����
		c.setCust_name("����");
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
