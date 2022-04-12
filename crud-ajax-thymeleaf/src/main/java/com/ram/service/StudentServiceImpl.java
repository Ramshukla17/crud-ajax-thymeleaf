package com.ram.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ram.ObjectCopier.ObjectCopier;
import com.ram.dao.StudentDao;
import com.ram.domain.StudentDomain;
import com.ram.entity.StudentEntity;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;

	//insert student details in database
	@Transactional
	@Override
	public StudentDomain saveStudent(StudentDomain studentDomain) {
		// TODO Auto-generated method stub
		return toDomain(studentDao.saveStudent(toEntity(studentDomain)));
	}
	
	//getting all Student data
	@Transactional
	@Override
	public List<StudentDomain> viewStudent(Integer offset, Integer limit, String Sortby) {
		Page<com.ram.entity.StudentEntity> page = studentDao.viewStudent(--offset, limit, Sortby);
		List<StudentDomain> list = new ArrayList<StudentDomain>();
		page.forEach(studentDetails -> {
			StudentDomain domain = toDomain(studentDetails);
			list.add(domain);
		});
		return list;
		
	}

	//update Student method
	@Transactional
	@Override
	public StudentDomain editStudent(StudentDomain studentDomain) {
		return toDomain(studentDao.editStudent(toEntity(studentDomain)));
	}
//get single student detail
	@Override
	public void getStudent(long id) {
		studentDao.getStudent(id);
	}
	
	//delete Student details
	@Transactional
	@Override
	public void deleteStudent(long id) {
		studentDao.deleteStudent(id);
	}

	// Creating To Domain method
	private StudentDomain toDomain(StudentEntity studentEntity) {
		StudentDomain domain = null;
		if (studentEntity != null) {
			domain = new StudentDomain();
			ObjectCopier.copyObject(studentEntity, domain);
		}
		return domain;
	}
	// creating to Entity method
	private StudentEntity toEntity(StudentDomain studentDomain) {
		StudentEntity entity = null;
		if (studentDomain != null) {
			entity = new StudentEntity();
			ObjectCopier.copyObject(studentDomain, entity);
		}
		return entity;
	}
	
	/*
	 * // Creating toDomain Method and Mapping Entity class with Domain Class public
	 * List <StudentDomain> toDomain(List<StudentEntity> listEntity) {
	 * List<StudentDomain> listDomain = null; if (listEntity != null) { listDomain =
	 * new ArrayList<StudentDomain>(); ObjectCopier.copyObject(listEntity,
	 * listDomain); } return listDomain; }
	 * 
	 * // Creating toEntity Method and Mapping Entity class with Domain Class public
	 * List<StudentEntity> toEntity(List<StudentDomain> listDomain) {
	 * List<StudentEntity> listEntity = null; if (listDomain != null) { listEntity =
	 * new ArrayList<StudentEntity>(); ObjectCopier.copyObject(listDomain,
	 * listEntity); } return listEntity; }
	 */
}
