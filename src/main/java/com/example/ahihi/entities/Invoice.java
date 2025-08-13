package com.example.ahihi.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "invoices")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "code", length = 10, unique = true)
    String code;

    @Column(name = "billing_period_month", nullable = false)
    int billingPeriodMonth;

    @Column(name = "billing_period_year", nullable = false)
    int billingPeriodYear;

    // @Column(name = "previous_debt", precision = 10, scale = 2)
    // BigDecimal previousDebt;

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

    @lombok.ToString.Exclude
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    public List<InvoiceDetail> invoiceDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Contract_id")
    private Contract contract;

    @PrePersist
    public void generateCode() {
        var timestampStr = String.valueOf(new java.util.Date().getTime());
        if (this.code == null) {
            var codeRandom = UUID.randomUUID().toString().replaceAll("-", "")
                    .substring(0, 5)
                    .concat(timestampStr.substring(timestampStr.length() - 5));
            this.code = codeRandom.toUpperCase();
        }
    }
}