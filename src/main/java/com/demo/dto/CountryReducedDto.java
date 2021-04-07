/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author rochrui0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryReducedDto {

    @JsonProperty("name")
    private String name;
    
    @JsonProperty("alpha3Code")
    private String alpha3Code;
    
    @JsonProperty("capital")
    private String capital;
    
    @JsonProperty("region")
    private String region;
    
    @JsonProperty("population")
    private Integer population;
    
    @JsonProperty("area")
    private Double area;
    
    @JsonProperty("timezones")
    private List<String> timezones = null;
    
    @JsonProperty("languages")
    private List<LanguageDto> languages = null;
    
    @JsonProperty("flag")
    private String flag;
    
    @JsonProperty("latlng")
    private List<Double> latlng = null;
    
    @JsonProperty("currencies")
    private List<CurrencyDto> currencies = null;
}
