package com.techelevator.controller;

import com.techelevator.dao.CastleDao;
import com.techelevator.model.Castle;
import com.techelevator.model.Img;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@CrossOrigin
@RestController
public class CastleController {
    private CastleDao castleDao;
    public CastleController (CastleDao castleDao) {
        this.castleDao = castleDao;
    }
    @RequestMapping(path = "/castles", method = RequestMethod.GET)
    public Castle[] getCastles() {
        List<Castle> castles = castleDao.getCastles();
        if (castles.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No castles found");
        } else {
            return castleDao.getCastles().toArray(new Castle[castles.size()]);
        }
    }

    @RequestMapping(path = "/castle/{castleId}", method = RequestMethod.GET)
    public Castle getCastleById(@PathVariable("castleId") int castleId) {
        Castle castle = castleDao.getCastleById(castleId);
        return castle;
    }

    @RequestMapping(path = "/castle/search/{castleName}", method = RequestMethod.GET)
    public List<Castle> getCastleByName(@PathVariable("castleName") String castleName) {
        return castleDao.getCastlesByName(castleName);
    }
    @RequestMapping(path = "/castle/filter/{region}", method = RequestMethod.GET)
    public List<Castle> getCastlesByRegion(@PathVariable("region") String region) {
        return castleDao.getCastlesByRegion(region);
    }
}
