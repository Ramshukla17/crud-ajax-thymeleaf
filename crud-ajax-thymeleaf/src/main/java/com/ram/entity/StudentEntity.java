package com.ram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="student")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@NotEmpty
	@Size(min= 3, message = "userName should have at least 3  character")
	private String name;
	@Min(value = 4000, message = "fees can't be less than 4000")
	private Integer fee;
	@NotEmpty
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
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentEntity(Long id,
			@NotEmpty @Size(min = 3, message = "userName should have at least 3  character") String name,
			@Min(value = 4000, message = "fees can't be less than 4000") Integer fee, String course) {
		super();
		this.id = id;
		this.name = name;
		this.fee = fee;
		this.course = course;
	}
	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", fee=" + fee + ", course=" + course + "]";
	}
	
	
	

	
}
