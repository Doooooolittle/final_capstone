package com.techelevator.controller;

import com.techelevator.dao.ImgDao;
import com.techelevator.model.Img;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
public class ImgController {
    private ImgDao imgDao;
    public ImgController (ImgDao imgDao) {
        this.imgDao = imgDao;
    }
    @RequestMapping(path = "/images/{castleId}", method = RequestMethod.GET)
    public Img[] getImagesByCastleId(@PathVariable("castleId") int castleId) {
        List<Img> imagesByCastleId = imgDao.getImagesByCastleId(castleId);
        if (imagesByCastleId.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No castles found");
        } else {
            return imagesByCastleId.toArray(new Img[imagesByCastleId.size()]);
        }
    }
}