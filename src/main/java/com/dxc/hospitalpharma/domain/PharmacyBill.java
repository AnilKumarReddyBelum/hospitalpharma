package com.dxc.hospitalpharma.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class PharmacyBill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String consultantName;
    private Integer visitNumber;
    private String patientName;
    private LocalDate billDate;
    private String patientPhoneNumber;
    private String paymentMode;
    private Double totalBeforeTaxes;
    private Double sgst;
    private Double cgst;
    private Double discountRoundOff;
    private Double netAmount;
    private Double amountPayed;
    private String remarks;
    private String preparedBy;
    private String generatedBy;

    @OneToMany(mappedBy = "bill", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<MedicalItem> medicalItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }

    public Integer getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(Integer visitNumber) {
        this.visitNumber = visitNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = patientPhoneNumber;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Double getTotalBeforeTaxes() {
        return totalBeforeTaxes;
    }

    public void setTotalBeforeTaxes(Double totalBeforeTaxes) {
        this.totalBeforeTaxes = totalBeforeTaxes;
    }

    public Double getSgst() {
        return sgst;
    }

    public void setSgst(Double sgst) {
        this.sgst = sgst;
    }

    public Double getCgst() {
        return cgst;
    }

    public void setCgst(Double cgst) {
        this.cgst = cgst;
    }

    public Double getDiscountRoundOff() {
        return discountRoundOff;
    }

    public void setDiscountRoundOff(Double discountRoundOff) {
        this.discountRoundOff = discountRoundOff;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }

    public Double getAmountPayed() {
        return amountPayed;
    }

    public void setAmountPayed(Double amountPayed) {
        this.amountPayed = amountPayed;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public Set<MedicalItem> getMedicalItems() {
        return medicalItems;
    }

    public void setMedicalItems(Set<MedicalItem> medicalItems) {
        this.medicalItems = medicalItems;
    }
}
