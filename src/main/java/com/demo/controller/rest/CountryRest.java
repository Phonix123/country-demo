/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller.rest;

import com.demo.client.CountryOverallInfoService;
import com.demo.dto.CountryReducedDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
@CrossOrigin(origins = {"http://localhost:8081"})
public class CountryRest {

    private final CountryOverallInfoService countryOverallInfoService;

    @GetMapping(value = "/country-info")
    public ResponseEntity<?> info() {
        List<CountryReducedDto> countries = countryOverallInfoService.getListOfCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
}
