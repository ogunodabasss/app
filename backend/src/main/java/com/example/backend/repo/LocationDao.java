package com.example.backend.repo;

import com.example.backend.model.Location;
import com.example.backend.model.LocationPojo;
import com.example.backend.model.req.LocationReqDTO;
import com.example.backend.utils.SqlUtil;
import com.example.backend.utils.clazz.Pair;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class LocationDao {
    private final Connection connection;


    public List<Location> findBy(LocationReqDTO reqDTO) throws SQLException {
        var sql = """
                SELECT longitude,latitude,json FROM public."location" AS l
                WHERE
                longitude <= ? AND latitude <= ? AND
                longitude >= ? AND latitude >= ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Pair<Double, Double>[] pairs = reqDTO.locationToPoint();
        preparedStatement.setDouble(1, pairs[1].getFirst());
        preparedStatement.setDouble(2, pairs[1].getSecond());
        preparedStatement.setDouble(3, pairs[2].getFirst());
        preparedStatement.setDouble(4, pairs[2].getSecond());
        log.warn("\n\npairs : {}\n\n", Arrays.toString(pairs));
        ResultSet rs = preparedStatement.executeQuery();
        List<Location> res = new ArrayList<>();
        while (rs.next()) {
            res.add(Location.of(
                    rs.getDouble(1),
                    rs.getDouble(2),
                    rs.getString(3)
            ));
        }
        SqlUtil.closeResultSet(rs);
        SqlUtil.closeStatement(preparedStatement);
        return res;
    }

    public boolean[] findByExitsBatch(List<LocationPojo> locationPojos) throws SQLException {
        var sql = """
                SELECT EXISTS(
                    SELECT 1 FROM public."location" AS l
                    WHERE longitude = ? AND latitude = ?
                )
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (LocationPojo locationPojo : locationPojos) {
            preparedStatement.setDouble(1, locationPojo.longitude());
            preparedStatement.setDouble(2, locationPojo.latitude());
            preparedStatement.addBatch();
        }

        ResultSet rs = preparedStatement.executeQuery();
        boolean[] res = new boolean[locationPojos.size()];
        int index = 0;
        while (rs.next())
            res[index++] = rs.getBoolean(1);
        SqlUtil.closeResultSet(rs);
        SqlUtil.closeStatement(preparedStatement);
        return res;
    }

    public void insertBatch(List<Location> locations) throws SQLException {
        var sql = """
                INSERT INTO public.location
                (longitude, latitude, json)
                VALUES (?,?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (Location location : locations) {
            preparedStatement.setDouble(1, location.longitude());
            preparedStatement.setDouble(2, location.latitude());
            preparedStatement.setString(3, location.json());
            preparedStatement.addBatch();
        }
        int[] res = preparedStatement.executeBatch();
        SqlUtil.closeStatement(preparedStatement);
    }

    public void insert(Location location) throws SQLException {
        var sql = """
                INSERT INTO public.location
                (longitude, latitude, json)
                VALUES (?,?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, location.longitude());
        preparedStatement.setDouble(2, location.latitude());
        preparedStatement.setString(3, location.json());

        int res = preparedStatement.executeUpdate();
        SqlUtil.closeStatement(preparedStatement);
        if (res != 1)
            throw new RuntimeException();
    }

    public void delete(long id) throws SQLException {
        var sql = """
                DELETE FROM public.location
                WHERE id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, id);
        int res = preparedStatement.executeUpdate();
        SqlUtil.closeStatement(preparedStatement);
        if (res != 1)
            throw new RuntimeException();
    }

    public void deleteBatch(List<Long> ids) throws SQLException {
        var sql = """
                DELETE FROM public.location
                WHERE id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (long id : ids) {
            preparedStatement.setDouble(1, id);
            preparedStatement.addBatch();
        }
        int[] res = preparedStatement.executeBatch();
        SqlUtil.closeStatement(preparedStatement);
    }


    public void update() {
        throw new UnsupportedOperationException();
    }

    public void updateBatch() {
        throw new UnsupportedOperationException();
    }
}
