package com.hospitalManagement.demo;

import com.hospitalManagement.demo.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private PatientRepository patientRepository;

	@Test
	void getPatients() {
		//patientRepository.fin

	}

}
