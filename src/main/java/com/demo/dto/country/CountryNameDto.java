/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dto.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
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
public class CountryNameDto {

    @JsonProperty("name")
    private String name;
    
    @JsonProperty("alpha3Code")
    private String alpha3Code;
    
}
