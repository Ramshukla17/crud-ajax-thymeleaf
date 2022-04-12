package com.ram.dao;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import com.ram.entity.StudentEntity;

@Repository
public interface StudentDao{

	public StudentEntity saveStudent(StudentEntity studentEntity);
	//public List<StudentEntity> viewStudent();
	public Page<StudentEntity> viewStudent(Integer offset, Integer limit, String Sortby);
	public StudentEntity editStudent(StudentEntity studentEntity);
	public void getStudent(long id);
	public void deleteStudent(long id);
	
}
