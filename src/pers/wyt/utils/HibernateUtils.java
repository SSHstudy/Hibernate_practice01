package pers.wyt.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 *Hibernate框架的工具类
 * @author asus
 *
 */
public class HibernateUtils {

	//常量必须赋值
	private static final Configuration CONFIG;
	private static final SessionFactory FACTORY;
	
	//编写静态代码
	static {
		//加载xml配置文件
		CONFIG = new Configuration().configure();
		//构建工厂
		FACTORY = CONFIG.buildSessionFactory();
	}
	
	/**
	 * 从工厂中获取Session对象
	 * @return
	 */
	public static Session getSession() {
		return FACTORY.openSession();
	}
}
