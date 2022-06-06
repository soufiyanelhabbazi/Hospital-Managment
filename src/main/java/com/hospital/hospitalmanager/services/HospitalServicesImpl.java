package com.hospital.hospitalmanager.services;

import com.hospital.hospitalmanager.entites.Consultation;
import com.hospital.hospitalmanager.entites.Medecin;
import com.hospital.hospitalmanager.entites.Patient;
import com.hospital.hospitalmanager.entites.RendezVous;
import com.hospital.hospitalmanager.repositories.ConsultationRepository;
import com.hospital.hospitalmanager.repositories.MedecinRepository;
import com.hospital.hospitalmanager.repositories.PatientRepository;
import com.hospital.hospitalmanager.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class HospitalServicesImpl implements IHospitalServices {
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;
    private MedecinRepository medecinRepository;
    private PatientRepository patientRepository;

    public HospitalServicesImpl(ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository, MedecinRepository medecinRepository, PatientRepository patientRepository) {
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.medecinRepository = medecinRepository;
        this.patientRepository = patientRepository;
    }


    @Override
    public Consultation saveConsultation(Consultation consultation) {
        consultation.setId(UUID.randomUUID().toString());
        return consultationRepository.save(consultation);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        medecin.setId(UUID.randomUUID().toString());
        return medecinRepository.save(medecin);
    }

    @Override
    public Patient savePatient(Patient patient) {
        patient.setId(UUID.randomUUID().toString());
        return patientRepository.save(patient);
    }
}
