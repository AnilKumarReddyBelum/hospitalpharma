package com.dxc.hospitalpharma.repository;

import com.dxc.hospitalpharma.domain.PharmacyBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyBillRepository extends JpaRepository<PharmacyBill, Long> {
}
