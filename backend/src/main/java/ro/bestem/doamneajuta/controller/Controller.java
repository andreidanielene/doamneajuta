package ro.bestem.doamneajuta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.bestem.doamneajuta.service.Service;
import ro.bestem.doamneajuta.service.model.ExchangeRate;
import ro.bestem.doamneajuta.service.model.Fixture;
import ro.bestem.doamneajuta.service.model.LocationDetail;
import ro.bestem.doamneajuta.util.User;
import ro.bestem.doamneajuta.util.UserRegister;

import java.util.List;
import java.util.Map;

/**
 * Created by Andrei-Daniel Ene on 4/14/2018.
 */
@RestController
public class Controller {

    @Autowired
    Service service;

    public static final String USER = "test@doamneajuta.ro";
    public static final String PASS = "test";

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserRegister> login(@RequestBody User user) {

        System.out.println("---> User Login: " + user.getUsername() + " " + user.getPassword());

        UserRegister userRegister = service.checkUserCredentials(user);
        if(userRegister != null ) {
            System.out.println("---> User login OK");
            return new ResponseEntity(userRegister, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody UserRegister userRegister) {

        System.out.println("---> User Register: " + userRegister.getUsername() + " " + userRegister.getPassword() + " " + userRegister.getFullName() + " " + userRegister.getPhone() + " " + userRegister.getTown());

        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/api/fixtures", method = RequestMethod.GET)
    public ResponseEntity<List<Fixture>> fixtures() {
        List<Fixture> fixtures;
        System.out.println("---> get fixtures");
        fixtures = service.getFixtures();
        System.out.println("---> response: " + fixtures.toString());

        return new ResponseEntity(fixtures, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/gethotels", method = RequestMethod.GET)
    public ResponseEntity<List<LocationDetail>> getNearbyHotels(
            @RequestParam(value = "location", required = false) String location
    ) {
        System.out.println("---> get Near Hotels");
        List<LocationDetail> locationList = service.getNearby(location, "hotel");
        System.out.println("---> response: " + locationList.toString());
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/getpoi", method = RequestMethod.GET)
    public ResponseEntity<List<LocationDetail>> getNearbyPOI(
            @RequestParam(value = "location", required = false) String location
    ) {
        System.out.println("---> get Near POI");
        List<LocationDetail> locationList = service.getNearby(location, "point_of_interest");
        System.out.println("---> response: " + locationList.toString());
        return new ResponseEntity<>(locationList, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/weather", method = RequestMethod.GET)
    public ResponseEntity getWeather(
            @RequestParam(value = "location") String location,
            @RequestParam(value = "startDate") String startDate,
            @RequestParam(value = "endDate") String endDate
    ) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/api/getexchangeratesymbols", method = RequestMethod.GET)
    public ResponseEntity<Map> getExchangeRateSymbols() {
        System.out.println("---> get Exchange Rate Symbols");
        Map exghangeRateSymbols = service.getExghangeRateSymbols();
        System.out.println("---> response: " + exghangeRateSymbols.toString());
        return new ResponseEntity<>(exghangeRateSymbols, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/getexchangerate", method = RequestMethod.GET)
    public ResponseEntity<ExchangeRate> getExchangeRate(
            @RequestParam(value = "base") String base,
            @RequestParam(value = "symbols") String symbols
    ) {
        System.out.println("---> get Exchange Rate");
        ExchangeRate exghangeRate = service.getExchangeRate(base,symbols);
        System.out.println("---> response: " + exghangeRate.toString());
        return new ResponseEntity<>(exghangeRate, HttpStatus.OK);
    }
}
