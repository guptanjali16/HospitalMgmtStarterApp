package com.hospitalManagement.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hospitalManagement.demo.DTO.BloodGroupTypeCountDto;
import com.hospitalManagement.demo.Entity.Patient;
import com.hospitalManagement.demo.Entity.type.BloodGroup;

import jakarta.transaction.Transactional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    Patient findByBirthDate(LocalDate date);
    List<Patient> findByBirthDateOrEmail(LocalDate date, String mail); //Or keyword supported by JPA

    //using @Query - JPQL, or sql as well
    @Query("select p from Patient p where p.bloodGroup= ?1")
    List<Patient> findByBloodGroup(BloodGroup bloodgroup);

    //SELECT * FROM patient_tbl WHERE birth_date > '1990-05-10';
    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(LocalDate birthDate);

    //select blood_group, COUNT(*) from patient_tbl where blood_group is not null group by blood_group;
    @Query("select p.bloodGroup, count(DISTINCT p) from Patient p group by p.bloodGroup")
    List<Object[]> countEachBloodGroup();

    @Query(value = "select * from patient_tbl",nativeQuery = true)
    List<Patient> listOfAllPatients();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name= :name where p.id = :id")
    int updateNameWithId(String name, Long id);

    // Using Projection
    // select blood_group, COUNT(*) from patient_tbl where blood_group is not null group by blood_group;
    // JPQL and Hibernate is responsible for converting your type to this.
    @Query("select new com.hospitalManagement.demo.DTO.BloodGroupTypeCountDto(p.bloodGroup, " +
            "count(p)) from Patient p group by p.bloodGroup")
    List<BloodGroupTypeCountDto> countEachBloodGroupUsingProjection();

}

