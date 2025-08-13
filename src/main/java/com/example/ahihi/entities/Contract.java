package com.example.ahihi.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "StartDate", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "EndDate")
    private LocalDateTime endDate;

    @Column(name = "DepositAmount", precision = 10, scale = 2)
    private BigDecimal depositAmount;

    @Column(name = "Payment_cycle_months", nullable = false)
    private byte paymentCycleMonths;

    @Column(name = "File_scan_url", length = 20)
    private String fileScanUrl;

    @Lob
    @Column(name = "Notes", columnDefinition = "Nvarchar(max)")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoomId", nullable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Tenant", nullable = false)
    private Tenant tenant;

    @OneToMany(mappedBy = "contract")
    private Set<Invoice> invoices;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ServiceUsage> serviceUsages;

    // Getters and Setters
}
