package com.example.PrescriptionGeneration.service;

import com.example.PrescriptionGeneration.model.Prescription;

import java.util.List;
import java.util.Optional;

public interface PrescriptionService {
    List<Prescription> getAllPrescriptions();
    Optional<Prescription> getPrescriptionById(Long id);
    Prescription generatePrescription(Prescription prescription);
    Prescription updatePrescription(Long id,Prescription prescriptionDetails);
    void deletePrescription(Long id);
    void deleteAllPrescriptions();

}
