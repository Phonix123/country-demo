/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dto.country;

import com.demo.dto.country.elements.Currency;
import com.demo.dto.country.elements.Language;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Rui Rocha
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryDto {

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
    private List<Language> languages = null;
    
    @JsonProperty("flag")
    private String flag;
    
    @JsonProperty("latlng")
    private List<Double> latlng = null;
    
    @JsonProperty("currencies")
    private List<Currency> currencies = null;
}
