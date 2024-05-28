package com.example.pharmacy_spring_boot.service;

import com.example.pharmacy_spring_boot.exception.DuplicateDataException;
import com.example.pharmacy_spring_boot.exception.NotFoundException;
import com.example.pharmacy_spring_boot.model.Patient;
import com.example.pharmacy_spring_boot.model.Prescription;
import com.example.pharmacy_spring_boot.repository.PrescriptionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;

    @Transactional
    public Prescription saveOrUpdate(Prescription prescription){
        if (prescriptionRepository.existsById(prescription.getId()))
            throw new DuplicateDataException(String.format("Prescription with %s id exists.", prescription.getId()));
        else
            return prescriptionRepository.save(prescription);
    }

    @Transactional
    public List<Prescription> findAllByConfirmed(){
//        if (prescriptionRepository.findAllByConfirmed(true).isPresent())
        Optional<List<Prescription>> confirmed = prescriptionRepository.findAllByConfirmed(true);
        return confirmed
                    .orElseThrow(()-> new NotFoundException("There's no confirmed prescription."));
    }
}
