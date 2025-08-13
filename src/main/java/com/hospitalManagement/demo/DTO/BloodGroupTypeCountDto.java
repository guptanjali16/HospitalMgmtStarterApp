package com.hospitalManagement.demo.DTO;

import com.hospitalManagement.demo.Entity.type.BloodGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupTypeCountDto {
    BloodGroup bloodGroupType;
    Long count;
//    public BloodGroupTypeCountDto(BloodGroup bloodGroupType, Long count){
//        this.bloodGroupType= bloodGroupType;
//        this.count = count;
//    }
}
