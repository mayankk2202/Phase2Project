package com.Practice.JDBCHibernateJPADemo.JPA;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.Practice.JDBCHibernateJPADemo.entity.Person;

@Repository
@Transactional
public class PersonJPARepository {
	@PersistenceContext
	EntityManager em;
	
	public Person findByID(int id) {
		return em.find(Person.class, id);	
	}
}
