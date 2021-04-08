/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.client;

import com.demo.dto.country.CountryDto;
import java.util.Arrays;
import java.util.List;
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
public class CountryOverallInfoService {

    public List<CountryDto> getListOfAllCountries() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client
                .target("https://restcountries.eu/rest/v2/all?fields=name;capital;alpha3Code");//;currencies;region;population;area;currencies;timezones;languages;flag;latlng

        CountryDto[] response = webTarget
                .request()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .get(CountryDto[].class);

//        log.info("" + (response == null ? 0 : response.length));

        return Arrays.asList(response);
//        List<CountryDto> list = Arrays.asList(response);
        //return list.stream().parallel().map(element -> CountryInfoAndWeatherDto.builder().countryInfo(element).build()).collect(Collectors.toList());
    }

    public CountryDto getCountryInformation(String code) {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client
                .target("https://restcountries.eu/rest/v2/alpha/" + code + "?fields=name;capital;alpha3Code;currencies;region;population;area;currencies;timezones;languages;flag;latlng");

        CountryDto response = webTarget
                .request()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .get(CountryDto.class);

//        log.info("" + (response == null ? "" : response));
        return response;
    }
}
