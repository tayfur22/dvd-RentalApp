package org.example.Entity;

import java.sql.Timestamp;
import java.util.Date;

public class Payment {
    private int paymentId;
    private int customerId;
    private int staffId;
    private int rentalId;
    private double amount;
    private Timestamp paymentDate;

    public Payment(int paymentId, int customerId, int staffId, int rentalId, double amount, Timestamp paymentDate) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.staffId = staffId;
        this.rentalId = rentalId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", customerId=" + customerId +
                ", staffId=" + staffId +
                ", rentalId=" + rentalId +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                '}';
    }

}
