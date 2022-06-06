package com.hospital.hospitalmanager.repositories;

import com.hospital.hospitalmanager.entites.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,String> {
}
