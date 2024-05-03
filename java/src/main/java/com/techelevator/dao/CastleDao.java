package com.techelevator.dao;

import com.techelevator.model.Castle;

import java.util.List;

public interface CastleDao {
    List<Castle> getCastles();
    Castle getCastleById(int castleId);
    List<Castle> getCastlesByName(String castleName);
    List<Castle> getCastlesByRegion(String region);
}
