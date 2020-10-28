package com.java.gasstation.service.impl;

import com.java.gasstation.model.Fuel;
import com.java.gasstation.repository.FuelRepository;
import com.java.gasstation.service.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuelServiceImpl implements FuelService {
    @Autowired
    private FuelRepository fuelRepository;

    @Override
    public List<Fuel> getAllFuel() {
        return fuelRepository.findAll();
    }

    @Override
    public void saveFuel(Fuel fuel) {
        this.fuelRepository.save(fuel);
    }

    @Override
    public Fuel getFuelById(Long id) {
        Optional<Fuel> optional = fuelRepository.findById(id);
        Fuel fuel = null;
        if(optional.isPresent()) {
            fuel = optional.get();
        }else {
            throw new RuntimeException("Станция не найдена " + id);
        }
        return fuel;
    }

    @Override
    public void deleteFuelById(Long id) {
        this.fuelRepository.deleteById(id);
    }
}
