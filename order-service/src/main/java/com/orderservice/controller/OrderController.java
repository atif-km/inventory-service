package com.orderservice.controller;

import com.orderservice.beans.Orders;
import com.orderservice.beans.PaymentRequestDTO;
import com.orderservice.beans.PaymentResponseDTO;
import com.orderservice.beans.ProductDTO;
import com.orderservice.exception.InsufficientStockException;
import com.orderservice.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {

    //private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository repo;

/*    @PostMapping
    public ResponseEntity<String> createOrder(
            @RequestParam(defaultValue = "false") boolean failPayment) {

        try {
            // Step 1: Reserve inventory
            restTemplate.postForObject(
                    "http://localhost:8082/inventory/reserve",
                    null,
                    String.class
            );

            // Step 2: Charge payment (forward flag)
            restTemplate.postForObject(
                    "http://localhost:8083/payment/charge?fail=" + failPayment,
                    null,
                    String.class
            );

            return ResponseEntity.ok("✅ Order completed successfully");

        } catch (Exception e) {

            System.out.println("Saga failed: " + e.getMessage());

            // Compensation (safe)
            try {
                restTemplate.postForObject(
                        "http://localhost:8082/inventory/release",
                        null,
                        String.class
                );
            } catch (Exception ex) {
                System.out.println("Compensation failed: " + ex.getMessage());
            }

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("❌ Order failed, compensation triggered");
        }
    }*/

    @PostMapping
    public Orders placeOrder(@RequestParam Long productId, @RequestParam int quantity){

        ProductDTO product = restTemplate.getForObject("http://PRODUCT-SERVICES/products/"+productId, ProductDTO.class);
        System.out.println("produtct ::"+product);
        if (product.getStock()<quantity){
            throw new InsufficientStockException("Insufficient stock for product Id "+productId);
        }else
            restTemplate.put("http://PRODUCT-SERVICES/products/"+productId+"/reduce?qty="+quantity,null);

        Orders order = new Orders();
        order.setQuantity(quantity);
        order.setStatus("PAYMENT_PENDING");
        order.setProductid(productId);

        PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
        paymentRequestDTO.setOrderId(order.getId());
        paymentRequestDTO.setAmount(product.getPrice()*quantity);

        PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();

        paymentResponseDTO= restTemplate.postForObject("http://PAYMENT-SERVICE/payments",paymentRequestDTO,PaymentResponseDTO.class);


        if ("SUCCESS".equals(paymentResponseDTO.getStatus())) {
            order.setStatus("PAYMENT_SUCCESS");
        } else {
            order.setStatus("PAYMENT_FAILED");
            // (Later we’ll add rollback / Saga here)
        }




        return repo.save(order);
    }
}