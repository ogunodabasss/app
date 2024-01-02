package com.example.backend.service;

import com.example.backend.model.Location;
import com.example.backend.model.LocationPojo;
import com.example.backend.model.req.LocationReqDTO;
import com.example.backend.repo.LocationDao;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LocationService {
    private final LocationDao dao;
    private final Connection connection;

    @SneakyThrows
    public List<Location> findBy(LocationReqDTO locationReqDTO) {
        try {
            connection.beginRequest();
            var res =dao.findBy(locationReqDTO);
            connection.commit();
            return res;
        } catch (Exception e) {
            connection.rollback();
            throw new RuntimeException(e);
        } finally {
            connection.endRequest();
        }
    }

    @SneakyThrows
    public boolean[] findByExitsBatch(List<LocationPojo> locationPojos) {
        try {
            connection.beginRequest();
            var res =dao.findByExitsBatch(locationPojos);
            connection.commit();
            return res;
        } catch (Exception e) {
            connection.rollback();
            throw new RuntimeException(e);
        } finally {
            connection.endRequest();
        }
    }
    @SneakyThrows
    public void insertBatch(List<Location> locations) {
        if (locations.isEmpty())
            return;
        try {
            connection.beginRequest();
            dao.insertBatch(locations);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw new RuntimeException(e);
        } finally {
            connection.endRequest();
        }
    }
}
