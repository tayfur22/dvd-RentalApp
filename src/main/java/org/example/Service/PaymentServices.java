package org.example.Service;

import org.example.Entity.Payment;
import org.example.Repositories.DbPaymentRepoImpl;

import java.sql.Timestamp;

public class PaymentServices {

    DbPaymentRepoImpl dbPaymentRepo;

    public PaymentServices(){
        this.dbPaymentRepo = new DbPaymentRepoImpl();
    }

    public boolean addPayment(Payment payment){
      return dbPaymentRepo.addPayment(payment);
    }

    public double getTotalPaymentsByDateRange(Timestamp startDate, Timestamp endDate){
       return dbPaymentRepo.getTotalPaymentsByDateRange(startDate,endDate);
    }

    public double getTotalPaymentsByCustomer(int customerId){
        return dbPaymentRepo.getTotalPaymentsByCustomer(customerId);
    }
}
