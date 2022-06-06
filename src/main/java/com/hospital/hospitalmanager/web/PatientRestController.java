package com.hospital.hospitalmanager.web;

import com.hospital.hospitalmanager.entites.Patient;
import com.hospital.hospitalmanager.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    List<Patient> patientList(){
        return patientRepository.findAll();
    }
}
