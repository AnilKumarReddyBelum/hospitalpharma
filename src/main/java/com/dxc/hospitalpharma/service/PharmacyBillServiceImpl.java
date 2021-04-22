package com.dxc.hospitalpharma.service;

import com.dxc.hospitalpharma.domain.MedicalItem;
import com.dxc.hospitalpharma.domain.PharmacyBill;
import com.dxc.hospitalpharma.repository.PharmacyBillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class PharmacyBillServiceImpl implements PharmacyBillService {

    private final PharmacyBillRepository pharmacyBillRepository;

    public PharmacyBillServiceImpl(PharmacyBillRepository pharmacyBillRepository) {
        this.pharmacyBillRepository = pharmacyBillRepository;
    }


    @Override
    public PharmacyBill createBill(PharmacyBill bill) {
        Set<MedicalItem> medicalItems = bill.getMedicalItems();
        for (MedicalItem medicalItem : medicalItems) {
            medicalItem.setId(null);
            medicalItem.setBill(bill);
        }
        return pharmacyBillRepository.save(bill);
    }
}
