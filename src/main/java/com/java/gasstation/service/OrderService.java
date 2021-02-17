package com.java.gasstation.service;

import com.java.gasstation.model.Fuel;
import com.java.gasstation.model.Order;
import com.java.gasstation.model.User;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    void saveOrder(Order order, Fuel fuel);
    Order getOrderById(Long id);
    void deleteOrderById(Long id);
    List<Order> getOrdersByUserId(Long id);
}
