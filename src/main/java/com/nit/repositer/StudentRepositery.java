package com.nit.repositer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nit.entity.StudentEntity;

@Repository
public interface StudentRepositery extends JpaRepository<StudentEntity, Integer> {

	
	@Query("from StudentEntity where temppws=:pws and studentEmail=:email")
	public StudentEntity searchdatabyemailandpws(String pws, String email);

	@Query("from StudentEntity where studentEmail=:email")
	public StudentEntity getpassword(String email);
	
	

}
