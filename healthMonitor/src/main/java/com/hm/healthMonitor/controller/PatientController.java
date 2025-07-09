package com.hm.healthMonitor.controller;

import com.hm.healthMonitor.model.PatientEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    @GetMapping("/findAll")
    public List<PatientEntity> findAll() {
        return null;
    }
}
