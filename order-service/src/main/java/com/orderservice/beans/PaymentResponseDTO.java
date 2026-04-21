package com.orderservice.beans;

public class PaymentResponseDTO {

   private String status;

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   @Override
   public String toString() {
      return "PaymentResponseDTO{" +
              "status='" + status + '\'' +
              '}';
   }
}
