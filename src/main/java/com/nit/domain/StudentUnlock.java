package com.nit.domain;

import lombok.Data;

@Data
public class StudentUnlock {
	
	private String email;
	private String tempPassword;
	private String newpws;
	private String confpws;

}
