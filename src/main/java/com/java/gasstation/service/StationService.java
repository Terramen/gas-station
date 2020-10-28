package com.java.gasstation.service;

import com.java.gasstation.model.Station;

import java.util.List;

public interface StationService {
    List<Station> getAllStations();
    void saveStations(Station station);
    Station getStationById(Long id);
    void deleteStationById(Long id);
}
