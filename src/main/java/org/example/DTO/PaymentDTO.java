package org.example.DTO;

import java.util.Date;

public class PaymentDTO {
    private Integer paymentId;
    private Integer customerId;
    private Integer staffId;
    private Integer rentalId;
    private Double amount;
    private String paymentDate;

    public PaymentDTO(Integer paymentId, Integer customerId,
                      Integer staffId, Integer rentalId,
                      Double amount, String paymentDate) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.staffId = staffId;
        this.rentalId = rentalId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
