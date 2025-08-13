package com.hospitalManagement.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class patientdto {
    private Long Id;
    private String name;
    private LocalDate birthDate;
    private String email;
    private String gender;
}
