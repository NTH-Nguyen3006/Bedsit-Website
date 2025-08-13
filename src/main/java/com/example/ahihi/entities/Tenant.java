package com.example.ahihi.entities;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tenants")
public class Tenant {
    @Id
    @Column(name = "Citizen_id", length = 12)
    private String citizenId;

    @Column(name = "FullName", nullable = false, length = 100)
    private String fullName;

    @Column(name = "DateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "PhoneNumber", nullable = false, length = 10)
    private String phoneNumber;

    @Column(name = "Email", length = 255)
    private String email;

    @Column(name = "VehiclePlate", length = 12)
    private String vehiclePlate;

    @OneToOne(mappedBy = "tenant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TenantDetail tenantDetails;

    @OneToMany(mappedBy = "tenant")
    private Set<Contract> contracts;

    @OneToMany(mappedBy = "tenant")
    private Set<Payment> payments;

}
