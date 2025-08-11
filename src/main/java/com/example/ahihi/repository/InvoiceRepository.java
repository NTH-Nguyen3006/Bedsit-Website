package com.example.ahihi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ahihi.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
