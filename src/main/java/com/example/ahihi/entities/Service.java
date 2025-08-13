package com.example.ahihi.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Services")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    int id;

    @Column(name = "ServiceName", nullable = false, length = 100, columnDefinition = "NVarchar(100)")
    String serviceName;

    @Column(name = "Unit", nullable = false, length = 20)
    String unit;

    @Column(name = "Price", nullable = false, precision = 10, scale = 2)
    BigDecimal price;

    @Lob
    @Column(name = "Description")
    String description;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<ServiceUsage> serviceUsages;

    @OneToMany(mappedBy = "service")
    Set<InvoiceDetail> invoiceDetails;

    // Getters and Setters
}