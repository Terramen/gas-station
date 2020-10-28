package com.java.gasstation.service;

import com.java.gasstation.model.Fuel;

import java.util.List;

public interface FuelService {
    List<Fuel> getAllFuel();
    void saveFuel(Fuel fuel);
    Fuel getFuelById(Long id);
    void deleteFuelById(Long id);
}
