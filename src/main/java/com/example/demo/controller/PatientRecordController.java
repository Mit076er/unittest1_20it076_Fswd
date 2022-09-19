package com.example.demo.controller;


import com.example.demo.model.PatientRecord;

import com.example.demo.repositories.PatientRecordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class PatientRecordController {

    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/listPatientRecord")
    public List<PatientRecord> getAllPatients() {
        return patientRecordRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public PatientRecord getPatient(@PathVariable Long id) {
        return patientRecordRepository.findById(id).get();
    }

    @DeleteMapping("/patient/{id}")
    public List<PatientRecord> deleteStudent(@PathVariable Long id) {
        patientRecordRepository.delete(patientRecordRepository.findById(id).get());
        return patientRecordRepository.findAll();
    }

   
    @PostMapping("/patient")
    public List<PatientRecord> addStudent(@RequestBody PatientRecord patientRecord) {
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }

    
    @PutMapping("/patient/{id}")
    public List<PatientRecord> updateStudent(@RequestBody PatientRecord patientRecord, @PathVariable Long id) {
        PatientRecord patientObj = patientRecordRepository.findById(id).get();
        patientObj.setName(patientRecord.getName());
        patientObj.setAddress(patientRecord.getAddress());
        patientObj.setAge(patientRecord.getAge());
        patientRecordRepository.save(patientObj);
        return patientRecordRepository.findAll();
    }


}
