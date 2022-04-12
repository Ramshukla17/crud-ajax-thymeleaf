package com.ram.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.ram.entity.StudentEntity;
import com.ram.repository.StudentRepository;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private StudentRepository studentRepo;

	//student record save
	@Transactional
	@Override
	public StudentEntity saveStudent(StudentEntity studentEntity) {
		StudentEntity create = studentRepo.saveAndFlush(studentEntity);
		return create;
	}
	/*
	 * //view all student
	 * 
	 * @Override public List<StudentEntity> viewStudent() { List<StudentEntity>
	 * list=studentRepo.findAll(); System.out.println("dao"+list); return list; }
	 */
	
	@Override
	public Page<StudentEntity> viewStudent(Integer offset, Integer limit, String Sortby) {
		Pageable pageable = PageRequest.of(offset, limit, Sort.by("id").ascending());
	return studentRepo.findAll(pageable);
	}

	//edit student details
	@Override
	public StudentEntity editStudent(StudentEntity studentEntity) {
		StudentEntity student=studentRepo.getById(studentEntity.getId());
		return student;
	}

	//delete student detail
	@Override
	public void deleteStudent(long id) {
		studentRepo.deleteById(id);
	}
//get single student detail
	@Override
	public void getStudent(long id) {
		 studentRepo.getById(id);
	}


}
