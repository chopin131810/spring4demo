/**
 * 
 */
package hello;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * @author Welcome
 *
 */
@Configuration
public class AppConfig {
	@Autowired
	DataSource dataSource;
	
	/*
	 * Use to create sessionFactory (Hibernate)
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(dataSource);
		sf.setPackagesToScan("hello.entity");
		
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		sf.setHibernateProperties(props);
		return sf;
	}
}
