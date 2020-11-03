package com.school.School.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

@Entity
@Table(name="class")
public class Class {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	String name;
	String section;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="classs")
	@JsonIgnore
	private List<Student> student;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Teacher> teacher;
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", section=" + section + "]";
	}
	
}
