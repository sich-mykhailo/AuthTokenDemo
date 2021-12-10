package com.authtokendemo.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Employee {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String phone;
    private String address;
    private String position;
    private LocalDate hiringDate;
    private Status status;

    public enum Status {
        ACTIVE, INACTIVE
    }
}
