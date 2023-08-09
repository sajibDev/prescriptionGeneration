package com.example.PrescriptionGeneration.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    private Long id;

    @Column(name="prescription_date")
    private Date prescriptionDate;

    @Column(name="patient_name")
    private String patientName;

    @Column(name="patient_age")
    private int patientAge;

    @Column(name="patient_gender")
    private String patientGender;

    @Column(name="diagnosis")
    private String diagnosis;

    @Column(name="medicines")
    private String medicines;

    @Column(name="next_visit_date")
    private Date nextVisitDate;


}
