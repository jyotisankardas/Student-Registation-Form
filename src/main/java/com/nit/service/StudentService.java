package com.nit.service;

import java.io.IOException;

import javax.mail.MessagingException;

import com.nit.domain.ResetPassword;
import com.nit.domain.Student;
import com.nit.domain.StudentLogin;
import com.nit.domain.StudentUnlock;
import com.nit.entity.StudentEntity;

public interface StudentService {

	public boolean insertValue(Student stu, String pws) throws Exception;

	public StudentEntity fetchDatabypwsandemail(StudentUnlock unlock);

	public StudentEntity getdatabymailandpws(StudentLogin login);

	public String getPassword(ResetPassword password) throws MessagingException, IOException;

	public String getEmailId(String email);
}
