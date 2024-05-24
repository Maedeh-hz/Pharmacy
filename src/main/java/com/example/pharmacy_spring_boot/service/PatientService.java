package com.example.pharmacy_spring_boot.service;

import com.example.pharmacy_spring_boot.exception.DuplicateDataException;
import com.example.pharmacy_spring_boot.model.Patient;
import com.example.pharmacy_spring_boot.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public Patient saveOrUpdate(Patient patient){
        if (patientRepository.findByUsername(patient.getUsername()).isPresent())
            throw new DuplicateDataException(String.format("User with %s username exists.", patient.getUsername()));
        else
            return patientRepository.save(patient);
    }
}
