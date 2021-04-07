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
public class CountryDto {

    @JsonProperty("name")
    private String name;
    @JsonProperty("topLevelDomain")
    private List<String> topLevelDomain = null;
    @JsonProperty("alpha2Code")
    private String alpha2Code;
    @JsonProperty("alpha3Code")
    private String alpha3Code;
    @JsonProperty("callingCodes")
    private List<String> callingCodes = null;
    @JsonProperty("capital")
    private String capital;
    @JsonProperty("altSpellings")
    private List<String> altSpellings = null;
    @JsonProperty("region")
    private String region;
    @JsonProperty("subregion")
    private String subregion;
    @JsonProperty("population")
    private Integer population;
    @JsonProperty("latlng")
    private List<Double> latlng = null;
    @JsonProperty("demonym")
    private String demonym;
    @JsonProperty("area")
    private Double area;
    @JsonProperty("gini")
    private Double gini;
    @JsonProperty("timezones")
    private List<String> timezones = null;
    @JsonProperty("borders")
    private List<String> borders = null;
    @JsonProperty("nativeName")
    private String nativeName;
    @JsonProperty("numericCode")
    private String numericCode;
    @JsonProperty("currencies")
    private List<CurrencyDto> currencies = null;
    @JsonProperty("languages")
    private List<LanguageDto> languages = null;
    @JsonProperty("translations")
    private TranslationsDto translations;
    @JsonProperty("flag")
    private String flag;
    @JsonProperty("regionalBlocs")
    private List<RegionalBlocDto> regionalBlocs = null;
    @JsonProperty("cioc")
    private String cioc;

    public CountryDto() {
    }
}
