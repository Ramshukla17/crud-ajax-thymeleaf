package com.ram.domain;

public class StudentDomain {

	private Long id;
	private String name;
	private Integer fee;
	private String course;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public StudentDomain(Long id, String name, Integer fee, String course) {
		super();
		this.id = id;
		this.name = name;
		this.fee = fee;
		this.course = course;
	}
	public StudentDomain() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StudentDomain [id=" + id + ", name=" + name + ", fee=" + fee + ", course=" + course + "]";
	}
	
	
	
}
