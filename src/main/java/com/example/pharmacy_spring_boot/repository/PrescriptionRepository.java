package com.example.pharmacy_spring_boot.repository;

import com.example.pharmacy_spring_boot.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
