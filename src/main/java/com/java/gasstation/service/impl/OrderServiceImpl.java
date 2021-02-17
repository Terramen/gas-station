package com.java.gasstation.service.impl;

import com.java.gasstation.model.Fuel;
import com.java.gasstation.model.Order;
import com.java.gasstation.model.User;
import com.java.gasstation.repository.FuelRepository;
import com.java.gasstation.repository.OrderRepository;
import com.java.gasstation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FuelRepository fuelRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order, Fuel fuel) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        order.setOrderDate(timestamp);
        order.setPrice(order.getCount() * order.getFuel().getPrice());
        order.getFuel().setCount(fuel.getCount() - order.getCount());
        orderRepository.save(order);
        fuelRepository.save(fuel);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public void deleteOrderById(Long id) {
        this.orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getOrdersByUserId(Long id) {

        return orderRepository.findAllByUserId(id);
    }

}
