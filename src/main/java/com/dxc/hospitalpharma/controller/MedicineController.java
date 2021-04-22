package com.dxc.hospitalpharma.controller;

import com.dxc.hospitalpharma.model.Medicine;
import com.dxc.hospitalpharma.service.MedicineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping
    public Collection<Medicine> medicines() {
        return medicineService.medicines();
    }
}
