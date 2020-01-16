package com.nit.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.domain.ResetPassword;
import com.nit.domain.Student;
import com.nit.domain.StudentLogin;
import com.nit.domain.StudentUnlock;
import com.nit.emailutility.EmailSender;
import com.nit.entity.StudentEntity;
import com.nit.repositer.StudentRepositery;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepositery studentrepo;

	@Autowired
	private EmailSender emailsender;

	/**
	 * This method is used for insert Record into Data base
	 */
	@Override
	public boolean insertValue(Student stu, String pws) throws IOException, MessagingException {
		StudentEntity entity = new StudentEntity();
		if (stu != null) {
			BeanUtils.copyProperties(stu, entity);

			entity.setTemppws(pws);
			entity.setStatus("LOCKED");
		}
		StudentEntity save = studentrepo.save(entity);

		emailsender.sendEmailWithAttachment(entity.getStudentEmail(), "Welcome to TeakLead", preapreMail(entity));

		return save.getStudentID() > 0;
	}

	/**
	 * This method is used for Prepare Mail body with valid input
	 * 
	 * @param entity
	 * @return
	 * @throws IOException
	 */
	public static String preapreMail(StudentEntity entity) throws IOException {
		File file = new File("mail.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuilder builder = new StringBuilder();
		String line = reader.readLine();
		while (line != null) {
			if (line.contains("${name")) {
				line = line.replace("${name}", entity.getStudentName());
			}
			if (line.contains("${pws}")) {
				line = line.replace("${pws}", entity.getTemppws());
			}
			if (line.contains("${email}")) {
				line = line.replace("${email}", entity.getStudentEmail());
			}

			builder.append(line);
			line = reader.readLine();
		}
		reader.close();
		return builder.toString();
	}

	/**
	 * This method is used for Fetch all data by password and mail id into db
	 */
	@Override
	public StudentEntity fetchDatabypwsandemail(StudentUnlock unlock) {
		StudentEntity entity = studentrepo.searchdatabyemailandpws(unlock.getTempPassword(), unlock.getEmail());

		if (entity != null) {
			entity.setStatus("ACTIVE");
			entity.setTemppws(unlock.getNewpws());
			studentrepo.save(entity);
		}

		return entity;
	}

	/**
	 * This method is used for get data by mail id and password
	 */
	@Override
	public StudentEntity getdatabymailandpws(StudentLogin login) {
		return studentrepo.searchdatabyemailandpws(login.getPassword(), login.getEmail());

	}

	/**
	 * This method is used for get password by given mail id
	 */
	@Override
	public String getPassword(ResetPassword password) throws MessagingException, IOException {
		String msg;
		StudentEntity entity = studentrepo.getpassword(password.getMail());

		if (entity != null) {
			if ("ACTIVE".equals(entity.getStatus())) {
				emailsender.sendEmailWithAttachment(entity.getStudentEmail(), "welcome to teak leads",
						preparebody(entity));
				msg = "password sent to Your Given Mail id...please check";
			}

			else {
				msg = "Your Account is in inactive mode ...please contact admine";
			}
		} else {
			msg = "Invalid email Id...please enter valid email id";
		}
		return msg;
	}

	public String preparebody(StudentEntity entity) {

		String body = "<b>your password is<b> " + entity.getTemppws();
		return body;
	}

	@Override
	public String getEmailId(String email) {
		String emailmsg;
		StudentEntity entity = studentrepo.getpassword(email);
		if (entity == null)
			emailmsg = "unique";
		else
			emailmsg = "duplicate";
		return emailmsg;
	}
}
