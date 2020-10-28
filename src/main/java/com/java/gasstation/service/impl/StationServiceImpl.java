package com.java.gasstation.service.impl;

import com.java.gasstation.model.Station;
import com.java.gasstation.repository.StationRepository;
import com.java.gasstation.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationRepository stationRepository;

    @Override
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    @Override
    public void saveStations(Station station) {
        this.stationRepository.save(station);
    }

    @Override
    public Station getStationById(Long id) {
        Optional<Station> optional = stationRepository.findById(id);
        Station station = null;
        if(optional.isPresent()) {
            station = optional.get();
        }else {
            throw new RuntimeException("Станция не найдена " + id);
        }
        return station;
    }

    @Override
    public void deleteStationById(Long id) {
        this.stationRepository.deleteById(id);
    }
}
