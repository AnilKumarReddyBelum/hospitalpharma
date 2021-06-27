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
        list.add(new Medicine("Brufin", "Brufin"));
        list.add(new Medicine("Saridon", "Saridon"));
        list.add(new Medicine("Paracitmol", "Paracitmol"));
        list.add(new Medicine("Vit-D-Shot", "Vit-D-Shot"));
        list.add(new Medicine("Vit-E-Tab", "Vit-E-Tab"));
        list.add(new Medicine("Vit-A-Injection", "Vit-A-Injection"));
        return list;
    }
}
