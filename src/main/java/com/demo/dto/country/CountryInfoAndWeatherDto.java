/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dto.country;

import com.demo.dto.weather.WeatherDto;
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
public class CountryInfoAndWeatherDto {

    @JsonProperty("info")
    public CountryDto info;
    @JsonProperty("weather")
    public WeatherDto weather;

}
