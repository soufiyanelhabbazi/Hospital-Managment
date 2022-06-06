package com.hospital.hospitalmanager;

import com.hospital.hospitalmanager.entites.*;
import com.hospital.hospitalmanager.repositories.MedecinRepository;
import com.hospital.hospitalmanager.repositories.PatientRepository;
import com.hospital.hospitalmanager.services.IHospitalServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagerApplication.class, args);
    }

    //une fonction qui a l'annotation Bean s'éxecute au demarrage
    //si on veut injecter les dépendances , il suffit de les ajouter dans l'argument de la methode start
    @Bean
    CommandLineRunner start(IHospitalServices hospitalServices, PatientRepository patientRepository
            , MedecinRepository medecinRepository) {
        return args -> {
            Stream.of("soufiyan", "amine", "salma").forEach(name -> {
                Patient patient = new Patient();
                patient.setName(name);
                patient.setEmail(name + "@gmail.com");
                hospitalServices.savePatient(patient);
            });

            Stream.of("ahlam", "said", "fatima").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setName(name);
                medecin.setEmail(name + "@gmail.com");
                medecin.setSpecialite(Math.random() < 0.5 ? "Dentiste" : "cardiologie");
                hospitalServices.saveMedecin(medecin);
            });
            Patient patient = patientRepository.findAll().get(0);
            Medecin medecin = medecinRepository.findAll().get(0);

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDateRdV(new Date());
            rendezVous.setMedecin(medecinRepository.findAll().get(0));
            rendezVous.setPatient(patientRepository.findAll().get(0));
            rendezVous.setStatus(StatusRDV.DONE);
            hospitalServices.saveRendezVous(rendezVous);

            List<RendezVous> rendezVousList = new ArrayList<>();
            rendezVousList.add(rendezVous);

            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRappot("Rapport de consultation");
            consultation.setRendezVous(rendezVous);
            consultation.setRendezVous(rendezVous);
            hospitalServices.saveConsultation(consultation);

            rendezVous.setConsulation(consultation);
            patient.setRendezVous(rendezVousList);

            medecin.setRendezVous(rendezVousList);
        };

    }
}
