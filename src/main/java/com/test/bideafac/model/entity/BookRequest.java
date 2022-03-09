package com.test.bideafac.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
@Data
@Entity
public class BookRequest {

    @Id
    @Size(max = 10, min = 9,message = "ID")
    private String id;

    @Size(max = 50, min = 2,message = "NAME")
    private String name;

    @Size(max = 50, min = 2,message = "LASTNAME")
    private String lastname;

    @DecimalMin(value = "18")
    @Max(value = 100)
    private int age;

    @Size(max = 20, min = 9,message = "PHONENUMBER")
    private String phoneNumber;

    private String startDate;

    private String endDate;

    @Size(max = 15, min = 6,message = "HOUSE ID")
    private String houseId;

    @Size(max = 8, min = 8,message = "DISCOUNT CODE")
    private String discountCode;

}
