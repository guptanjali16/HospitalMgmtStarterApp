package com.hospitalManagement.demo.Entity;

import com.hospitalManagement.demo.Entity.type.BloodGroup;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter
@Table(
        name= "patient_tbl",
        uniqueConstraints = {
                @UniqueConstraint(name="unique_patient_email", columnNames = {"email"}),
                @UniqueConstraint(name="unique_patient_name_birthdate", columnNames = {"name","birthDate"})
        },
        indexes = {
                @Index(name="idx_patient_birth_date", columnList = "birthDate")
        }
)
//pat123
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

//    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
}

