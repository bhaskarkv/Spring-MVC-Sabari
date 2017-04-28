package com.balaji.logistics.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.balaji.logistics.entities.ProjectEntity;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.balaji.logistics")
@EnableTransactionManagement
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }


	
	@Bean(name="viewResolver")
	public  InternalResourceViewResolver  viewResolver(){
		
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");
		
		return irvr;
		
	}
	
	//Step 1: Creating DataSource 
	@Bean(name="dataSource")
	 public DataSource getDataSource(){
		 
		 BasicDataSource dataSource = new BasicDataSource();
		 
		 	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    	dataSource.setUrl("jdbc:mysql://localhost:3306/springtraining");
	    	dataSource.setUsername("root");
	    	dataSource.setPassword("password@123");
		 
		 return dataSource;
		 
	}	
	//Step 2: Creating HibernateProperties
		
	public Properties getHibernateProperties(){
		
		Properties prop = new Properties();
		
		prop.put("hibernate.show_sql", "true");
    	prop.put("hibernate.hbm2ddl.auto", "update");
    	prop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		return prop;
	}
	
	//Step3 : Creating SessionFactory
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		
		LocalSessionFactoryBuilder lsfb = new LocalSessionFactoryBuilder(dataSource);
		
		lsfb.addProperties(getHibernateProperties());
		lsfb.addAnnotatedClasses(ProjectEntity.class);
		
		SessionFactory sf = lsfb.buildSessionFactory();
		
		return sf;
		
	}
	//Step3 : Creating Transaction Manager
	@Autowired
	@Bean	
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		
		HibernateTransactionManager htm = new HibernateTransactionManager(sessionFactory);		
		return htm;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

