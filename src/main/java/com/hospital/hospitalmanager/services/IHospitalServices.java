package com.hospital.hospitalmanager.services;

import com.hospital.hospitalmanager.entites.Consultation;
import com.hospital.hospitalmanager.entites.Medecin;
import com.hospital.hospitalmanager.entites.Patient;
import com.hospital.hospitalmanager.entites.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHospitalServices {
    Consultation saveConsultation(Consultation consultation);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Medecin saveMedecin(Medecin medecin);
    Patient savePatient(Patient patient);
}
