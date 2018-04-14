package ro.bestem.doamneajuta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ro.bestem.doamneajuta.dal.Dao;
import ro.bestem.doamneajuta.service.model.ExchangeRate;
import ro.bestem.doamneajuta.service.model.Fixture;
import ro.bestem.doamneajuta.service.model.LocationDetail;
import ro.bestem.doamneajuta.util.TeamDetails;
import ro.bestem.doamneajuta.util.User;
import ro.bestem.doamneajuta.util.UserRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrei-Daniel Ene on 4/14/2018.
 */
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    Dao dao;

    @Value("${google.api.key}")
    String googleApiKey;

    @Value("${football.api.token}")
    String footbalApiToken;

    @Value("${exchangerate.api.key}")
    String exchangerateApiKey;

    private RestTemplate restTemplate = new RestTemplate();
    private String nearbySearch = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";
    private String fixtureUrl = "http://api.football-data.org/v1/competitions/456/fixtures?matchday=33";
    private String textSearch = "https://maps.googleapis.com/maps/api/place/textsearch/json";
    private String exchangeRateUrl = "http://data.fixer.io/api/latest";
    private String exchangeRateSymbols = "http://data.fixer.io/api/symbols";

    public List<LocationDetail> getNearby(String location, String keyword) {
        List<LocationDetail> locationDetailList = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(nearbySearch)
                .queryParam("location", location)
                .queryParam("rankby", "distance")
                .queryParam("key", googleApiKey);
        if(keyword.equals("hotel")) {
            builder.queryParam("keyword", "hotel");
        } else {
            builder.queryParam("type", "point_of_interest");
        }

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<Object> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Object.class);

        List<Map> results = (List<Map>) ((Map) response.getBody()).get("results");

        for(Map item:results) {
            LocationDetail locationDetail = new LocationDetail();
            locationDetail.setName( (String) item.get("name") );
            try {
                if(item.get("rating") instanceof Integer) {
                    locationDetail.setRating( (Integer) item.get("rating") );
                } else {
                    locationDetail.setRating( (Double) item.get("rating") );
                }
            } catch (Exception e) {
                System.out.println("-- Rating inexistent.");
            }

            Map locatie = (Map) ((Map) item.get("geometry")).get("location");
            locationDetail.setLatitudine( (Double) locatie.get("lat") );
            locationDetail.setLongitudine( (Double) locatie.get("lng"));
            locationDetailList.add(locationDetail);
        }


        return locationDetailList;
    }

    public Map getExghangeRateSymbols() {
        List<String> response = new ArrayList<>();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(exchangeRateSymbols)
                .queryParam("access_key", exchangerateApiKey)
                .queryParam("format",1);

        HttpEntity<Object> exchangeRateSymbols = restTemplate.getForEntity(builder.toUriString(), Object.class);

        return (Map) ((Map) exchangeRateSymbols.getBody()).get("symbols");
    }

    public ExchangeRate getExchangeRate(String base, String symbols) {
        ExchangeRate exchangeRate = new ExchangeRate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(exchangeRateUrl)
                .queryParam("access_key", exchangerateApiKey)
                .queryParam("base", base)
                .queryParam("symbols", symbols);

        HttpEntity<Object> exchangeRateSymbols = restTemplate.getForEntity(builder.toUriString(), Object.class);

        exchangeRate.setBase( (String) ((Map) exchangeRateSymbols.getBody()).get("base") );
        exchangeRate.setDate( (String) ((Map) exchangeRateSymbols.getBody()).get("date") );
        exchangeRate.setRates( (Map)   ((Map) exchangeRateSymbols.getBody()).get("rates") );

        return exchangeRate;
    }

    public Map getTeamDetails(String teamDetails) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        teamDetails = teamDetails.replace(" ", "+");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(textSearch)
                .queryParam("query", teamDetails)
                .queryParam("key", googleApiKey);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<Object> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Object.class);
        List<Map> results = (List<Map>) ((Map) response.getBody()).get("results");
        if( results.isEmpty() ) {
            System.out.println("LOG: " + ((Map) response.getBody()).get("error_message"));
            throw new Exception( (String) ((Map) response.getBody()).get("error_message"));
        }
        Map location = (Map) ((Map) results.get(0).get("geometry")).get("location");

        return location;
    }

    public List<Fixture> getFixtures() {
        List<Fixture> fixtures = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", footbalApiToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);

//        HttpEntity<Object> fixturesString = restTemplate.getForEntity(fixtureUrl, Object.class);
        HttpEntity<Object> fixturesString = restTemplate.exchange(
                fixtureUrl,
                HttpMethod.GET,
                entity,
                Object.class);

        List<Map> map = (List<Map>) ((Map) fixturesString.getBody()).get("fixtures");
        for(Map item:map) {
            Fixture fixture = new Fixture();
            fixture.setHomeTeamName( (String) item.get("homeTeamName") );
            fixture.setAwayTeamName( (String) item.get("awayTeamName") );
            fixture.setDate( (String) item.get("date") );
            fixture.setStadium( getStadium(fixture.getHomeTeamName() ) );
            Map location = null;
            try {
                location = getTeamDetails( fixture.getStadium() );
                if( location == null ) {
                    location = getTeamDetails( getCity( fixture.getHomeTeamName() ) );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if( location != null ) {
                fixture.setLongitudine((Double) location.get("lng"));
                fixture.setLatitudine((Double) location.get("lat"));
            }

            fixtures.add(fixture);
        }

        return fixtures;
    }

    private String getStadium(String teamName) {
        List<TeamDetails> teamDetailsList = dao.getTeamDetails();
        for(TeamDetails item:teamDetailsList) {
            if(item.getTeamName().equalsIgnoreCase(teamName)) {
                return item.getStadium();
            }
        }
        return null;
    }

    private String getCity(String teamName) {
        List<TeamDetails> teamDetailsList = dao.getTeamDetails();
        for(TeamDetails item:teamDetailsList) {
            if(item.getTeamName().equalsIgnoreCase(teamName)) {
                return item.getCity();
            }
        }
        return null;
    }

    public UserRegister checkUserCredentials(User user) {
        return dao.checkUserCredentials(user);
    }
}
