package com.hospital.hospitalmanager.repositories;

import com.hospital.hospitalmanager.entites.Consultation;
import com.hospital.hospitalmanager.entites.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,String> {
}
