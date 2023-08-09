package com.example.PrescriptionGeneration.controller;

import com.example.PrescriptionGeneration.model.Prescription;
import com.example.PrescriptionGeneration.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {

        this.prescriptionService = prescriptionService;

    }

    //Generate prescription
    @PostMapping("/generatePrescription")
    public Prescription generatePrescription(@RequestBody Prescription prescription) {

        try {

            return prescriptionService.generatePrescription(prescription);

        } catch (Exception exception) {

            exception.printStackTrace();

            return new Prescription();

        }

    }

    //Get prescription by ID
    @GetMapping("/prescriptions/{id}")
    public Optional<Prescription> getPrescriptionById(@PathVariable Long id) {

        try {

            return prescriptionService.getPrescriptionById(id);

        } catch (Exception exception) {

            exception.printStackTrace();

        }

        return Optional.empty();

    }

    // Get all prescriptions
    @GetMapping("/prescriptions")
    public List<Prescription> getAllPrescriptions() {

        try {

            return prescriptionService.getAllPrescriptions();

        } catch (Exception exception) {

            exception.printStackTrace();

            return new ArrayList<>();

        }

    }

    //Update prescription
    @PutMapping("/updatePrescription/{id}")
    public Prescription updatePrescription(@PathVariable Long id, @RequestBody Prescription prescriptionDetails) {

        try {

            return prescriptionService.updatePrescription(id, prescriptionDetails);

        } catch (Exception exception) {

            exception.printStackTrace();

        }

        return new Prescription();

    }

    // Delete prescription
    @DeleteMapping("/deletePrescription/{id}")
    public void deletePrescription(@PathVariable Long id) {

        try {

            prescriptionService.deletePrescription(id);

        } catch (Exception exception) {

            exception.printStackTrace();

        }

    }

    // Delete all prescriptions
    @DeleteMapping("/deletePrescription")
    public void deleteAllPrescriptions() {

        try {

            prescriptionService.deleteAllPrescriptions();

        } catch (Exception exception) {

            exception.printStackTrace();

        }

    }

}
