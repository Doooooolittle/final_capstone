package com.techelevator.controller;
import com.techelevator.dao.CastleDao;
import com.techelevator.dao.ParkDao;
import com.techelevator.model.Castle;
import com.techelevator.model.Img;
import com.techelevator.model.Park;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@CrossOrigin
@RestController
public class ParkController {
    private ParkDao parkDao;
    public ParkController (ParkDao parkDao) {
        this.parkDao = parkDao;
    }
    @RequestMapping(path = "/parks", method = RequestMethod.GET)
    public Park[] getParks() {
        List<Park> parks = parkDao.getParks();
        if (parks.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No parks found");
        } else {
            return parkDao.getParks().toArray(new Park[parks.size()]);
        }
    }



}
