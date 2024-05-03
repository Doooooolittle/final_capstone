package com.techelevator.dao;

import com.techelevator.model.Img;

import java.util.List;

public interface ImgDao {
    List<Img> getImagesByCastleId(int castleId);
}
