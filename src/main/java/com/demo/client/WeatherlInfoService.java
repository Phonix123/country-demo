/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.client;

import com.demo.dto.country.CountryDto;
import com.demo.dto.weather.WeatherDto;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rui Rocha
 */
@Slf4j
@Service
public class WeatherlInfoService {

    public WeatherDto getCapitalWeather(CountryDto country) {
        WeatherDto response = null;
        if (country.getCapital() != null && !country.getCapital().isEmpty()) {
            Client client = ClientBuilder.newClient();
            String URL = "http://api.openweathermap.org/data/2.5/weather?q=" + encodeValue(country.getCapital()) + "&units=metric&APPID=a3168cdefbc04dc640fe2c55abf7b454";
            //log.info("Calling {}", URL);
            WebTarget webTarget = client
                    .target(URL);
            try {
                response = webTarget
                        .request()
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .get(WeatherDto.class);

            } catch (NotFoundException e) {
                log.info("Error getting city weather \"Not found\", trying with coordinates");
                URL = "http://api.openweathermap.org/data/2.5/weather?lat=" + country.getLatlng().get(0) + "&lon=" + country.getLatlng().get(1) + "&units=metric&APPID=a3168cdefbc04dc640fe2c55abf7b454";
                //log.info("Calling {}", URL);
                webTarget = client
                        .target(URL);
                response = webTarget
                        .request()
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .get(WeatherDto.class);
            } catch (ClientErrorException e) {
                

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
