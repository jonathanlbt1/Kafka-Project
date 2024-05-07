package com.jonathan.paymentservice.service;

import com.jonathan.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
