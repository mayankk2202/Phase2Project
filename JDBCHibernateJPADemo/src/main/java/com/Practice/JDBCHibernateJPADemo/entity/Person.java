package com.Practice.JDBCHibernateJPADemo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Person {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String location;
	private Date birthdate;
	public Person() {	}
	public Person(int id, String name, String location, Date birthdate) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthdate = birthdate;
	}
	public Person(String name, String location, Date birthdate) {
		this.name = name;
		this.location = location;
		this.birthdate = birthdate;
	}
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	@Override
	public String toString() {
		return "\nPerson [ID=" + id + ", Name=" + name + ", Location=" + location + ", Birthdate=" + birthdate + "]";
	} 
}
