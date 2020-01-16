package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STUDENT_INFO")
public class StudentEntity {

	@Column(name = "ID", length = 7)
	@Id
	@GeneratedValue
	private int StudentID;
	@Column(name = "NAME", length = 20)
	private String studentName;
	@Column(name = "email", length = 35)
	private String studentEmail;
	@Column(name = "addrs", length = 10)
	private String studentaddress;
	@Column(name = "phNo", length = 15)
	private long phoneNo;
	@Column(name = "tpws", length = 10)
	private String temppws;
	@Column(name = "status", length = 10)
	private String status;

}
