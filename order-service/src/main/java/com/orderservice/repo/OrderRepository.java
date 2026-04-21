package com.orderservice.repo;

import com.orderservice.beans.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long>{
}
