package com.example.ahihi.entities;

import groovy.transform.builder.Builder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tenant_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TenantDetail {
    @Id
    @Column(name = "Citizen_id", length = 12)
    private String citizenId;

    @Column(name = "PerCard_FrontImage", length = 20)
    private String perCardFrontImage;

    @Column(name = "PerCard_BackImage", length = 20)
    private String perCardBackImage;

    @Column(name = "ResidencyStatus")
    private boolean residencyStatus;

    @Column(name = "Occupation", length = 100)
    private String occupation;

    @Column(name = "Hometown", length = 255)
    private String hometown;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "Citizen_id")
    private Tenant tenant;
}
