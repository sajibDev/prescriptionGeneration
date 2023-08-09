package com.example.PrescriptionGeneration.Repository;

import com.example.PrescriptionGeneration.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

}
