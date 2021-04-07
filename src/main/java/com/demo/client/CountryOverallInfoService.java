/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.client;

import com.demo.dto.CountryReducedDto;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author rochrui0
 */
@Slf4j
@Service
public class CountryOverallInfoService {

    public List<CountryReducedDto> getListOfCountries() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client
                .target("https://restcountries.eu/rest/v2/all?fields=name;capital;currencies;alpha3Code;region;population;area;currencies;timezones;languages;flag;latlng");
//                .target("https://restcountries.eu/rest/v2/alpha/pt?fields=name");

        CountryReducedDto[] response = webTarget
                .request()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .get(CountryReducedDto[].class);
        
        log.info("" + (response == null ? 0 : response.length));
        
        return Arrays.asList(response);
    }
}
