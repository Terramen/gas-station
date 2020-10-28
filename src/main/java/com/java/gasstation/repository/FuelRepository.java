package com.java.gasstation.repository;

import com.java.gasstation.model.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepository extends JpaRepository <Fuel, Long> {
}
