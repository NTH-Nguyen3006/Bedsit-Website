package com.example.ahihi.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "invoice")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "code", length = 10)
    String code;

    @Column(name = "contract_id")
    Long contractId;

    @Column(name = "billing_period_month", nullable = false)
    int billingPeriodMonth;

    @Column(name = "billing_period_year", nullable = false)
    int billingPeriodYear;

    @Column(name = "previous_debt", precision = 10, scale = 2)
    BigDecimal previousDebt;

    @Column(name = "discount", precision = 10, scale = 2)
    BigDecimal discount;

    @Column(name = "total_amount", precision = 12, scale = 2, nullable = false)
    BigDecimal totalAmount;

    @Column(name = "status", nullable = false)
    boolean status;

    @Column(name = "due_date")
    LocalDate dueDate;

    @Column(name = "created_at")
    LocalDateTime createdAt;

}