package com.hospital.hospitalmanager.repositories;

import com.hospital.hospitalmanager.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,String> {
}
