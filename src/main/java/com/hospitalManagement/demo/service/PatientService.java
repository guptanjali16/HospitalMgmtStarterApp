package com.hospitalManagement.demo.service;

import com.hospitalManagement.demo.Entity.Patient;
import com.hospitalManagement.demo.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id) {
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();
        System.out.println(p1==p2);
        return p1;
    }
}
//    private final ModelMapper modelMapper;

//    @Transactional
//    public PatientResponseDto getPatientById(Long patientId) {
//        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient Not " +
//                "Found with id: " + patientId));
//        return modelMapper.map(patient, PatientResponseDto.class);
//    }
//
//    public List<PatientResponseDto> getAllPatients(Integer pageNumber, Integer pageSize) {
//        return patientRepository.findAllPatients(PageRequest.of(pageNumber, pageSize))
//                .stream()
//                .map(patient -> modelMapper.map(patient, PatientResponseDto.class))
//                .collect(Collectors.toList());
//    }

