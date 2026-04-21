package com.paymentservice.controller;


import com.paymentservice.beans.Payment;
import com.paymentservice.beans.PaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {


    @PostMapping
    public PaymentResponse makePayment(@RequestBody Payment payment) {
        boolean paymentSuccess = payment.getAmount()<100000;

        if(!paymentSuccess){
            return new PaymentResponse("SUCCESS");
        }
        return new PaymentResponse("FAILED");
    }
}

