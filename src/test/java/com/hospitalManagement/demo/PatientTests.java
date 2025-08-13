package com.hospitalManagement.demo.DTO;

import com.hospitalManagement.demo.Entity.Patient;
import com.hospitalManagement.demo.DTO.BloodGroupTypeCountDto;
import com.hospitalManagement.demo.repository.PatientRepository;
import com.hospitalManagement.demo.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    PatientService patientService;


    @Test
    public void testPatientRepository(){
       List<Patient> PatientList = patientRepository.findAll();
       System.out.println("PatientList :"+ PatientList);

//       Patient p1= new Patient();
//       patientRepository.save(p1);
    }

    @Test
    public void testTransactionMethods(){
//        Patient p1 = patientService.getPatientById(2L);
//        System.out.println("-------------------getPatientById-------------------");
//        System.out.println(p1);
//        System.out.printf("Patient with id{} is : {} ",p1.getId() , p1);
//
//        Patient p2 = patientRepository.findByName("Diya Patel");
//        System.out.println("-------------------findByName-------------------");
//        System.out.println(p2);

//        Patient p3= patientRepository.findByBirthDate(LocalDate.of(1993,07,11));
//        System.out.println("-------------------findByBirthDate-------------------");
//        System.out.println(p3);

//        List<Patient> p4 = patientRepository.findByBirthDateOrEmail(LocalDate.of(1993,07,11), "diya.patel@example.com");
//        System.out.println("-------------------findByBirthDateOrEmail-------------------");
//        for(Patient pat : p4) {
//            System.out.println(pat);
////        }
//
//        List<Patient> p5 = patientRepository.findByBloodGroup(BloodGroup.A_POSITIVE);
//        System.out.println("-------------------findByBloodGroup-------------------");
//        for(Patient pat : p5) {
//            System.out.println(pat);
//        }

//        List<Patient> p6 = patientRepository.findByBornAfterDate(LocalDate.of(1990,05,10));
//        System.out.println("-------------------findByBornAfterDate-------------------");
//        for(Patient pat : p6) {
//            System.out.println(pat);
//        }

//        List<Object[]> p7 = patientRepository.countEachBloodGroup();
//        System.out.println("-------------------countEachBloodGroup-------------------");
//        for(Object[] pat : p7) {
//            System.out.println(pat.toString());
//            System.out.println(pat[0]+ " "+ pat[1]);
//        }

//        List<Patient> patientList = patientRepository.listOfAllPatients();
//        System.out.println("-------------------listOfAllPatients-------------------");
//        for(Patient pat : patientList) {
//            System.out.println(pat);
//        }

//        int rowsUpdated = patientRepository.updateNameWithId("Anjali Gupta", 1L);
//        System.out.println("-------------------rowsUpdated-------------------");
//        System.out.println(rowsUpdated);

        //Projection
        List<BloodGroupTypeCountDto> p7 = patientRepository.countEachBloodGroupUsingProjection();
        System.out.println("-------------------countEachBloodGroupUsingProjection-------------------");
        for(BloodGroupTypeCountDto bloodGroupCountResponse : p7) {
            System.out.println(bloodGroupCountResponse.toString());
            System.out.println(bloodGroupCountResponse);
        }


    }

}
