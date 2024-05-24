package com.example.pharmacy_spring_boot.utility;

import com.example.pharmacy_spring_boot.model.Patient;
import com.example.pharmacy_spring_boot.service.PatientService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final PatientService patientService;

//    https://stackabuse.com/spring-custom-password-validation/

    public Menu(PatientService patientService, PasswordGenerator passwordGenerator){
        this.patientService = patientService;
    }

    @PostConstruct
    public void menu(){
//        System.out.println("------ Welcome. ------");
        registerPrescription();

    }


    public void registerPrescription(){


        Patient patient = Patient.builder()
                .username("milad")
                .password("  ")
                .build();
        Patient saved = patientService.saveOrUpdate(patient);
        System.out.println(saved);
    }
}
