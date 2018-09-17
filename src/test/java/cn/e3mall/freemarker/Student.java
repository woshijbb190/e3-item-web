package cn.e3mall.freemarker;

import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}	
