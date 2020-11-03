package com.school.School.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	String class_teach;
	String DOJ;
	String experience;
	String schedule;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private Users user;
	
	//@ManyToMany(mappedBy="teacher")
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="faculty_class",joinColumns=@JoinColumn(name="teacher_id"), inverseJoinColumns=@JoinColumn(name="classs_id"))
	private List<Class> classs;
	
	public List<Class> getClasss() {
		return classs;
	}
	public void setClasss(List<Class> classs) {
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
	public String getClass_teach() {
		return class_teach;
	}
	public void setClass_teach(String class_teach) {
		this.class_teach = class_teach;
	}
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	
}
