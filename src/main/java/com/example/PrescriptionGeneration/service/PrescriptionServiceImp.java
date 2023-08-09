package com.example.PrescriptionGeneration.service;


import com.example.PrescriptionGeneration.Repository.PrescriptionRepository;
import com.example.PrescriptionGeneration.model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImp implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionServiceImp(PrescriptionRepository prescriptionRepository) {

        this.prescriptionRepository = prescriptionRepository;

    }

    //Generate prescription
    @Override
    public Prescription generatePrescription(Prescription prescription) {

        try {

            return prescriptionRepository.save(prescription);

        } catch (Exception exception) {

            exception.printStackTrace();

            return new Prescription();

        }

    }

    //Get prescription by ID
    @Override
    public Optional<Prescription> getPrescriptionById(Long id) {

        try {

            return prescriptionRepository.findById(id);

        } catch (Exception exception) {

            exception.printStackTrace();
        }

        return Optional.empty();

    }

    // Get all prescriptions
    @Override
    public List<Prescription> getAllPrescriptions() {

        try {

            return prescriptionRepository.findAll();

        } catch (Exception exception) {

            exception.printStackTrace();

            return new ArrayList<>();

        }

    }

    //Update prescription
    @Override
    public Prescription updatePrescription(Long id, Prescription prescriptionDetails) {

        try {

            Optional<Prescription> prescription = prescriptionRepository.findById(id);

            if (prescription.isPresent()) {

                Prescription existingPrescription = prescription.get();

                existingPrescription.setPrescriptionDate(prescriptionDetails.getPrescriptionDate());

                existingPrescription.setPatientName(prescriptionDetails.getPatientName());

                existingPrescription.setPrescriptionDate(prescriptionDetails.getPrescriptionDate());

                existingPrescription.setPatientAge(prescriptionDetails.getPatientAge());

                existingPrescription.setPatientGender(prescriptionDetails.getPatientGender());

                existingPrescription.setDiagnosis(prescriptionDetails.getDiagnosis());

                existingPrescription.setMedicines(prescriptionDetails.getMedicines());

                existingPrescription.setNextVisitDate(prescriptionDetails.getNextVisitDate());

                return prescriptionRepository.save(existingPrescription);

            }

        } catch (Exception exception) {

            exception.printStackTrace();

        }

        return null;

    }

    // Delete prescription
    @Override
    public void deletePrescription(Long id) {

        try {

            prescriptionRepository.deleteById(id);

        } catch (Exception exception) {

            exception.printStackTrace();

        }

    }

    // Delete all prescriptions
    @Override
    public void deleteAllPrescriptions() {

        try {

            prescriptionRepository.deleteAll();

        } catch (Exception exception) {

            exception.printStackTrace();

        }

    }

}
