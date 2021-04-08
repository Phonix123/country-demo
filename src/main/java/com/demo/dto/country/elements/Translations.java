/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dto.country.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Rui Rocha
 */
@Getter
@Setter
@NoArgsConstructor
public class Translations {
    
    @JsonProperty("de")
    private String de;
    @JsonProperty("es")
    private String es;
    @JsonProperty("fr")
    private String fr;
    @JsonProperty("ja")
    private String ja;
    @JsonProperty("it")
    private String it;
    @JsonProperty("br")
    private String br;
    @JsonProperty("pt")
    private String pt;
    @JsonProperty("nl")
    private String nl;
    @JsonProperty("hr")
    private String hr;
    @JsonProperty("fa")
    private String fa;
}
