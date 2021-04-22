package com.dxc.hospitalpharma.service;

import com.dxc.hospitalpharma.model.Medicine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Override
    public Collection<Medicine> medicines() {
        List<Medicine> list = new ArrayList<>();
        list.add(new Medicine(1001, "Brufin"));
        list.add(new Medicine(1002, "Saridon"));
        list.add(new Medicine(1003, "Paracitmol"));
        list.add(new Medicine(1004, "Vit-D-Shot"));
        list.add(new Medicine(1005, "Vit-E-Tab"));
        list.add(new Medicine(1006, "Vit-A-Injection"));
        return list;
    }
}
