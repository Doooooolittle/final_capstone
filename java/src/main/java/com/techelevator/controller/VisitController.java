package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.VisitDao;
import com.techelevator.model.Castle;
import com.techelevator.model.User;
import com.techelevator.model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
public class VisitController {

    private UserDao userDao;
    private VisitDao visitDao;

    public VisitController(UserDao userDao, VisitDao visitDao) {
        this.userDao = userDao;
        this.visitDao = visitDao;
    }

    @PostMapping(path = "/add/visit")
    public Visit createVisit(@Valid @RequestBody Visit visit, Principal principal){
        return visitDao.createVisit(visit);
    }

    @RequestMapping(path = "/visit/{visitId}", method = RequestMethod.GET)
    public Visit getVisitById(@PathVariable("visitId") int visitId) {
        return visitDao.getVisitById(visitId);
    }
    @RequestMapping(path = "/visit/{visitId}", method = RequestMethod.DELETE)
    public int deleteVisitById(@PathVariable("visitId") int visitId) {
        return visitDao.deleteVisitById(visitId);
    }
    @RequestMapping(path = "/itinerary/{visitDate}", method = RequestMethod.GET)
    public Visit[] getVisitsByUsernameAndVisitDate(
            Principal principal,
            @PathVariable("visitDate")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate visitDate) {
        User currentUser = userDao.getUserByUsername(principal.getName());
        List<Visit> itinerary = visitDao.getVisitsByUsernameAndVisitDate(currentUser.getUsername(), visitDate);
        return itinerary.toArray(new Visit[itinerary.size()]);
    }
    @RequestMapping(path = "/itinerary/{visitDate}", method = RequestMethod.DELETE)
    public int deleteVisitsByUsernameAndVisitDate(
            Principal principal,
            @PathVariable("visitDate")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate visitDate) {
        User currentUser = userDao.getUserByUsername(principal.getName());
        return visitDao.deleteVisitByUsernameAndVisitDate(currentUser.getUsername(), visitDate);
    }

    @RequestMapping(path = "/visits", method = RequestMethod.GET)
    public Visit[] getVisits() {
        List<Visit> visits = visitDao.getVisits();
        if (visits.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No visits found");
        } else {
            return visitDao.getVisits().toArray(new Visit[visits.size()]);
        }
    }
}

