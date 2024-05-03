package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Castle;
import com.techelevator.model.Img;
import com.techelevator.model.Visit;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVisitDao implements VisitDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcVisitDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Visit getVisitById(int visitId) {
        Visit visit = new Visit();
        String sql = "SELECT visit_id, username, castle_id, visit_date FROM visit WHERE visit_id = ?;";

        try{
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,visitId);
            while (rowSet.next()) {
                visit = mapRowToVisit(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database ", e);
        }
        return visit;
    }

    @Override
    public Visit createVisit(Visit visit) {

        Visit newVisit = new Visit();
        String sql =
                "INSERT INTO visit(username, castle_id, visit_date) " +
                "VALUES(?, ?, ?) " +
                "RETURNING visit_id;";

        try{
            int newVisitId = jdbcTemplate.queryForObject(sql, Integer.class, visit.getUsername(), visit.getCastleId(), visit.getVisitDate()); //int.class before //visit.getUserId(), visit.getCastleId(), visit.getVisitDate() new Object[]{visit.getUserId(), visit.getCastleId(), java.sql.Date.valueOf(visit.getVisitDate())},
//            new int[]{Types.INTEGER, Types.INTEGER, Types.DATE}
            newVisit = getVisitById(newVisitId); //newVisit.getVisitId()

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data Integrity Violation", e);
        }
        return visit;
    }

    public List<Visit> getVisitsByUsernameAndVisitDate(String username, LocalDate visitDate) {
        List<Visit> visits = new ArrayList<>();
        String sql = "SELECT DISTINCT " +
                "v.visit_id, " +
                "v.username, " +
                "v.castle_id, " +
                "v.visit_date, " +
                "c.castle_name, " +
                "c.castle_banner_photo, " +
                "c.region, " +
                "c.short_desc " +
                "FROM visit v " +
                "JOIN castle c ON c.castle_id = v.castle_id " +
                "WHERE v.username = ? AND v.visit_date = ?";
        try{
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username, visitDate);
            while (rowSet.next()) {
                visits.add(mapRowToVisit(rowSet));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database ", e);
        }
        return visits;
    }

    @Override
    public int deleteVisitByUsernameAndVisitDate(String username, LocalDate visitDate) {
        String sql = "DELETE FROM visit WHERE username = ? AND visit_date = ?";
        int numberDeleted = 0;
        try {
            jdbcTemplate.update(sql, username, visitDate);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database.", e);
        }

        return numberDeleted;
    }

    @Override
    public List<Visit> getVisits() {
        List<Visit> visits = new ArrayList<>();
        String sql = "SELECT v.visit_id, v.username, v.castle_id, v.visit_date, c.castle_name, c.castle_banner_photo, c.region, c.short_desc FROM visit v JOIN castle c ON c.castle_id = v.castle_id";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            while (rowSet.next()) {
                Visit visit = mapRowToVisit(rowSet);
                visits.add(visit);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return visits;
    }
    @Override
    public int deleteVisitById(int visitId) {
        String sql = "DELETE FROM visit WHERE visit_id = ?";
        int numberDeleted = 0;

        try {
            numberDeleted = jdbcTemplate.update(sql, visitId);

            if (numberDeleted != 1) {
                throw new DaoException(numberDeleted + " parks where deleted, but should have only been one!");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Park needs to be removed from Park State", e);
        }

        return numberDeleted;
    }


    public Visit mapRowToVisit(SqlRowSet rowSet) {
        Visit visit = new Visit();
        visit.setVisitId(rowSet.getInt("visit_id"));
        visit.setCastleId(rowSet.getInt("castle_id"));
        visit.setUsername(rowSet.getString("username"));
        visit.setVisitDate(rowSet.getDate("visit_date").toLocalDate());
        visit.setCastleName(rowSet.getString("castle_name"));
        visit.setCastleBannerPhoto(rowSet.getString("castle_banner_photo"));
        visit.setShortDesc(rowSet.getString("short_desc"));
        visit.setRegion(rowSet.getString("region"));
        return visit;
    }
}
