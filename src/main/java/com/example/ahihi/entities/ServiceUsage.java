package com.example.ahihi.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
@Data
class ServiceUsageId implements Serializable {

    @Column(name = "ServiceId")
    private int serviceId;

    @Column(name = "ContractId")
    private int contractId;

    // hashCode, equals, getters, setters
}

@Entity
@Table(name = "ServiceUsages")
public class ServiceUsage {

    @EmbeddedId
    private ServiceUsageId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("serviceId")
    @JoinColumn(name = "ServiceId")
    private Service service;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("contractId")
    @JoinColumn(name = "ContractId")
    private Contract contract;

    @Column(name = "StartDate", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "EndDate")
    private LocalDateTime endDate;

    // Getters and Setters
}