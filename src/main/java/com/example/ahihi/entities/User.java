package com.example.ahihi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class User {
    long id;
    String username;
    int age;
    String phoneNumber;
    String address;
}
