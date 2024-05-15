package com.techelevator.dao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Castle;
import com.techelevator.model.Park;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcParkDao implements ParkDao {
    private final JdbcTemplate jdbcTemplate;
    public JdbcParkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Park> getParks() {
        List<Park> parks = new ArrayList<>();
        String sql =
                "SELECT " +
                        "park_id, " +
                        "park_name, " +
                        "park_banner_photo, " +
                        "short_desc, " +
                        "long_desc, " +
                        "address, " +
                        "longitude, " +
                        "latitude, " +
                        "site_url, " +
                        "map_location, " +
                        "region " +
                        "FROM park;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            while (rowSet.next()) {
                Park park = mapRowToPark(rowSet);
                parks.add(park);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return parks;
    }


    public Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();
        park.setParkId(rowSet.getInt("castle_id"));
        park.setParkName(rowSet.getString("castle_name"));
        park.setParkBannerPhoto(rowSet.getString("castle_banner_photo"));
        park.setShortDesc(rowSet.getString("short_desc"));
        park.setLongDesc(rowSet.getString("long_desc"));
        park.setAddress(rowSet.getString("address"));
        park.setLongitude(rowSet.getString("longitude"));
        park.setLatitude(rowSet.getString("latitude"));
        park.setSiteUrl(rowSet.getString("site_url"));
        park.setMapLocation(rowSet.getString("map_location"));
        park.setRegion(rowSet.getString("region"));
        return park;
    }


}
