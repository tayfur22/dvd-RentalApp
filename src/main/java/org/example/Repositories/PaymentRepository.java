package org.example.Repositories;

import org.example.Entity.Payment;

import java.sql.Timestamp;

public interface PaymentRepository {

    boolean addPayment(Payment payment);

    double getTotalPaymentsByDateRange(Timestamp startDate, Timestamp endDate);

    double getTotalPaymentsByCustomer(int customerId);

}
