package com.school.School.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	String class_type;
	String adm_year;
	String adm_number;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Users user;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="classs_id")
	private Class classs;
	
	public Student()
	{
		
	}
	public Student(long id, String class_type) {
		this.id = id;
		this.class_type = class_type;
	}
	public Class getClasss() {
		return classs;
	}
	public void setClasss(Class classs) {
		this.classs = classs;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClass_type() {
		return class_type;
	}
	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}
	public String getAdm_year() {
		return adm_year;
	}
	public void setAdm_year(String adm_year) {
		this.adm_year = adm_year;
	}
	public String getAdm_number() {
		return adm_number;
	}
	public void setAdm_number(String adm_number) {
		this.adm_number = adm_number;
	}
}
