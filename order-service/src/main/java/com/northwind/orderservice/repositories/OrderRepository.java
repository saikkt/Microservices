package com.northwind.orderservice.repositories;

import com.northwind.orderservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(long customerId);
    List<Order> findByCustomerNo(String customerNo);

    @Query(value="select * from Orders where CustomerID=:customerId  and OrderDate between :startDate and :endDate"
            , nativeQuery = true
    )
    List<Order> findByOrderDates(long customerId, java.sql.Date startDate, Date endDate);

  //  List<Order> findByCustomerNo(String customerNo);
}
