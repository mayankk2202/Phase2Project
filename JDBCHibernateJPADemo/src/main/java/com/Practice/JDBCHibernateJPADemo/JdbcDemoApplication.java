package com.Practice.JDBCHibernateJPADemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Practice.JDBCHibernateJPADemo.JDBC.PersonJDBCDAO;
import com.Practice.JDBCHibernateJPADemo.entity.Person;

//@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner {

//	@Autowired
	PersonJDBCDAO dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcDemoApplication.class, args);
	}
	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users -> {}",dao.findAll());
//		List<Person> per = dao.findAll();
//		per.forEach(Person -> logger.info("{}",Person));
		logger.info("User with ID=100004 ={}", dao.findById(100004));
		logger.info("Deleting record where ID=100005. {} records deleted",dao.deleteById(100005));
		logger.info("Remaining Users -> {}",dao.findAll());
		logger.info("Inserting record where ID=100005. {} records Inserted",dao.insertUser(new Person(100005,"Rohit","Dombivali",new Date(1985,02,22,20,29,0))));
		logger.info("All Users After inserting-> {}",dao.findAll());
		logger.info("Inserting record where ID=100005. {} records updated",dao.UpdateUser(100005,new Person(100005,"Mayank","Dombivali",new Date(85,01,22,20,29,0))));
		logger.info("All Users After updating-> {}",dao.findAll());
	}

}
