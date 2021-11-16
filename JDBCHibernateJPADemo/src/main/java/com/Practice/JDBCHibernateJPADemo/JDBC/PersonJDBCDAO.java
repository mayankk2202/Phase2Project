package com.Practice.JDBCHibernateJPADemo.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Practice.JDBCHibernateJPADemo.entity.Person;

//@Repository
public class PersonJDBCDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person", new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4));
				return person;
			}
		}) ;
//		return jdbcTemplate.query("select * from person", BeanPropertyRowMapper.newInstance(Person.class));
	}
	public List<Person> findById(int id) {
		String qry = "select * from person where id="+id;
		return jdbcTemplate.query(qry, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4));
				return person;
			}
			
		});
	}
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", new Object[] {id});
	}
	public int insertUser(Person p) {
		return jdbcTemplate.update(
				"insert into person"
				+ "(id, name, location, birthdate) "
				+ "values (?, ?, ?, ?)", 
				new Object[] {p.getID(), p.getName(), p.getLocation(), new Timestamp(p.getBirthdate().getTime())});
	}
	public int UpdateUser(int id, Person p) {
		return jdbcTemplate.update(
				"update person "
				+ "set name=?, location=?, birthdate=? "
				+ "where id=?", 
				new Object[] {p.getName(), p.getLocation(), new Timestamp(p.getBirthdate().getTime()), p.getID()});
	}
}
