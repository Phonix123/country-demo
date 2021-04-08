/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller.rest;

import com.demo.client.CountryOverallInfoService;

import com.demo.client.WeatherlInfoService;
import com.demo.dto.country.CountryDto;
import com.demo.dto.country.CountryInfoAndWeatherDto;
import com.demo.dto.weather.WeatherDto;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
@CrossOrigin(origins = {"http://localhost:8081"})
@Slf4j
public class CountryRest {

    private final CountryOverallInfoService countryService;
    private final WeatherlInfoService weatherService;

    @GetMapping(value = "/countries")
    public ResponseEntity<?> list(@Context HttpServletRequest request) throws InterruptedException {
        log.info(request.getProtocol());
        List<CountryDto> countries = countryService.getListOfAllCountries();

        List<CountryInfoAndWeatherDto> result = countries.stream().parallel().map(element
                -> CountryInfoAndWeatherDto.builder()
                        .info(element)
                        //.weather(weatherService.getCapitalWeather(element))
                        .build()
        ).collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/country")
    public ResponseEntity<?> info(@RequestParam String code, @Context HttpServletRequest request) {

        CountryDto country = countryService.getCountryInformation(code);
        WeatherDto weather = weatherService.getCapitalWeather(country);

        CountryInfoAndWeatherDto info = CountryInfoAndWeatherDto.builder()
                .info(country)
                .weather(weather)
                .build();

        return new ResponseEntity<>(info, HttpStatus.OK);
    }
}
