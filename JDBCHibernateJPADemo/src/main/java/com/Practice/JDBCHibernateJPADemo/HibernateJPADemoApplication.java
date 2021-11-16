package com.Practice.JDBCHibernateJPADemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Practice.JDBCHibernateJPADemo.JPA.PersonJPARepository;

@SpringBootApplication
public class HibernateJPADemoApplication implements CommandLineRunner {

	@Autowired
	PersonJPARepository rep;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateJPADemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
//		logger.info("All Users -> {}",rep.findAll());
		logger.info("User with ID=100004 ={}", rep.findByID(100004));
//		logger.info("Deleting record where ID=100005. {} records deleted",rep.deleteById(100005));
//		logger.info("Remaining Users -> {}",rep.findAll());
//		logger.info("Inserting record where ID=100005. {} records Inserted",rep.insertUser(new Person(100005,"Rohit","Dombivali",new Date(1985,02,22,20,29,0))));
//		logger.info("All Users After inserting-> {}",rep.findAll());
//		logger.info("Inserting record where ID=100005. {} records updated",rep.UpdateUser(100005,new Person(100005,"Mayank","Dombivali",new Date(85,01,22,20,29,0))));
//		logger.info("All Users After updating-> {}",rep.findAll());
	}

}
