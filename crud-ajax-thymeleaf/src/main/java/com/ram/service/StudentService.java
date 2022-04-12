package com.ram.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ram.domain.StudentDomain;

@Service
public interface StudentService {

	public StudentDomain saveStudent(StudentDomain studentDomain);
	public List<StudentDomain> viewStudent(Integer offset, Integer limit, String Sortby);
	public StudentDomain editStudent(StudentDomain studentDomain);
	public void getStudent(long id);
	public void deleteStudent(long id);
}

