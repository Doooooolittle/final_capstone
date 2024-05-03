package com.techelevator.dao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Castle;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcCastleDao implements CastleDao {
    private final JdbcTemplate jdbcTemplate;
    public JdbcCastleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Castle> getCastles() {
        List<Castle> castles = new ArrayList<>();
        String sql =
                "SELECT " +
                "castle_id, " +
                "castle_name, " +
                "castle_banner_photo, " +
                "short_desc, " +
                "long_desc, " +
                "address, " +
                "longitude, " +
                "latitude, " +
                "site_url, " +
                "map_location, " +
                        "region " +
                "FROM castle;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            while (rowSet.next()) {
                Castle castle = mapRowToCastle(rowSet);
                castles.add(castle);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return castles;
    }
    @Override
    public Castle getCastleById(int castleId){
        Castle castle = new Castle();
        String sql =
                "SELECT " +

                "castle_id, " +
                "castle_name, " +
                "castle_banner_photo, " +
                "short_desc, " +
                "long_desc, " +
                "address, " +
                "longitude, " +
                "latitude, " +
                "site_url, " +
                "map_location, " +
                        "region " +

                "FROM castle " +
                "WHERE castle_id = ?;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, castleId);
            while (rowSet.next()) {
                castle = mapRowToCastle(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return castle;
    };

//

    @Override
    public List<Castle> getCastlesByName(String castleName){
        List<Castle> castles = new ArrayList<>();
        String sql =
                "SELECT " +

                        "castle_id, " +
                        "castle_name, " +
                        "castle_banner_photo, " +
                        "short_desc, " +
                        "long_desc, " +
                        "address, " +
                        "longitude, " +
                        "latitude, " +
                        "site_url, " +
                        "map_location, " +
                        "region " +

                        "FROM castle " +
                        "WHERE castle_name ILIKE concat('%', ?, '%');";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, castleName);
            while (rowSet.next()) {
                Castle castle = mapRowToCastle(rowSet);
                castles.add(castle);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return castles;
    };

    @Override
    public List<Castle> getCastlesByRegion(String region) {
        List<Castle> castles = new ArrayList<>();
        String sql =
                "SELECT " +

                        "castle_id, " +
                        "castle_name, " +
                        "castle_banner_photo, " +
                        "short_desc, " +
                        "long_desc, " +
                        "address, " +
                        "longitude, " +
                        "latitude, " +
                        "site_url, " +
                        "map_location, " +
                        "region " +

                        "FROM castle " +
                        "WHERE region ILIKE ?;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, region);
            while (rowSet.next()) {
                Castle castle = mapRowToCastle(rowSet);
                castles.add(castle);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return castles;
    }



    public Castle mapRowToCastle(SqlRowSet rowSet) {
        Castle castle = new Castle();
        castle.setCastleId(rowSet.getInt("castle_id"));
        castle.setCastleName(rowSet.getString("castle_name"));
        castle.setCastleBannerPhoto(rowSet.getString("castle_banner_photo"));
        castle.setShortDesc(rowSet.getString("short_desc"));
        castle.setLongDesc(rowSet.getString("long_desc"));
        castle.setAddress(rowSet.getString("address"));
        castle.setLongitude(rowSet.getString("longitude"));
        castle.setLatitude(rowSet.getString("latitude"));
        castle.setSiteUrl(rowSet.getString("site_url"));
        castle.setMapLocation(rowSet.getString("map_location"));
        castle.setRegion(rowSet.getString("region"));
        return castle;
    }


}
