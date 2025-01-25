package org.example.Coverter;

import org.example.DTO.PaymentDTO;
import org.example.Entity.Payment;

public class PaymentConverter {

    public static PaymentDTO toPaymentDTO (Payment payment){
        return new PaymentDTO(
                payment.getPaymentId(),
                payment.getCustomerId(),
                payment.getStaffId(),
                payment.getRentalId(),
                payment.getAmount(),
                payment.getPaymentDate()
        );
    }

    public static Payment toPayment (PaymentDTO paymentDTO){
        return new Payment(
                paymentDTO.getPaymentId(),
                paymentDTO.getCustomerId(),
                paymentDTO.getStaffId(),
                paymentDTO.getRentalId(),
                paymentDTO.getAmount(),
                paymentDTO.getPaymentDate()
        );
    }
}
