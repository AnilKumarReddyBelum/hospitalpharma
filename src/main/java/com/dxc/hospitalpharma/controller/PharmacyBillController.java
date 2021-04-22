package com.dxc.hospitalpharma.controller;

import com.dxc.hospitalpharma.domain.PharmacyBill;
import com.dxc.hospitalpharma.service.PharmacyBillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/billing")
public class PharmacyBillController {

    private final PharmacyBillService pharmacyBillService;

    public PharmacyBillController(PharmacyBillService pharmacyBillService) {
        this.pharmacyBillService = pharmacyBillService;
    }

    @PostMapping
    private PharmacyBill createBill(@RequestBody  PharmacyBill bill) {
        return pharmacyBillService.createBill(bill);
    }

}
