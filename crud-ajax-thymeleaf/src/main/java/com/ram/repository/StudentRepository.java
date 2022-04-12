package com.ram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

}
