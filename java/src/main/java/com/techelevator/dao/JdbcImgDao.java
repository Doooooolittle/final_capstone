package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Img;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcImgDao implements ImgDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcImgDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Img> getImagesByCastleId(int castleId) {
        List<Img> images = new ArrayList<>();
        String sql =
                "SELECT img_id, castle_id, img_name, img_path " +
                "FROM img " +
                "WHERE castle_id = ?;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, castleId);
            while (rowSet.next()) {
                Img img = mapRowToImage(rowSet);
                images.add(img);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return images;
    }

    public Img mapRowToImage(SqlRowSet rowSet) {
        Img img = new Img();
        img.setImgId(rowSet.getInt("img_id"));
        img.setCastleId(rowSet.getInt("castle_id"));
        img.setImgName(rowSet.getString("img_name"));
        img.setImgPath(rowSet.getString("img_path"));
        return img;
    }
}
