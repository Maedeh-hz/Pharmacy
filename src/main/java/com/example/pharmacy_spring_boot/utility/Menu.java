package com.example.pharmacy_spring_boot.utility;

import com.example.pharmacy_spring_boot.model.Item;
import com.example.pharmacy_spring_boot.model.Patient;
import com.example.pharmacy_spring_boot.model.Prescription;
import com.example.pharmacy_spring_boot.service.PatientService;
import com.example.pharmacy_spring_boot.service.PrescriptionService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;


@Component
@Slf4j
public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final PatientService patientService;
    private final PrescriptionService prescriptionService;

//    https://stackabuse.com/spring-custom-password-validation/

    public Menu(PatientService patientService, PrescriptionService prescriptionService){
        this.patientService = patientService;
        this.prescriptionService = prescriptionService;
    }

    @PostConstruct
    public void test(){
//        registerPatient();
        registerPrescription();
    }


    public void registerPatient(){
        CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generatePassword(10, digits);

        Patient patient = Patient.builder()
                .username("milad")
                .password(password)
                .build();
        try{
            Patient saved = patientService.saveOrUpdate(patient);
            if (saved!=null)
                log.info("Patient is saved.");
        } catch (Exception e){
            log.error("ERROR KHORDIM!!!!");
        }
    }

    public void registerPrescription(){
        Patient patient = patientService.findById(1L);
        Item item1 = Item.builder().name("Ibuprofen").build();
        Item item2 = Item.builder().name("Vitamin D").build();
        Item item3 = Item.builder().name("Amoxi").build();
        List<Item> items = List.of(item1, item2, item3);
        Prescription prescription = Prescription.builder()
                .items(items)
                .patient(patient)
                .build();
        try{
            Prescription saved = prescriptionService.saveOrUpdate(prescription);
            if (saved!=null)
                log.info("Prescription is saved.");
        } catch (Exception e){
            log.error("ERROR KHORDIM!!!!");
        }
    }
}
