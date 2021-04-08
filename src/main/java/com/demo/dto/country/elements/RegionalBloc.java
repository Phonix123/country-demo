/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dto.country.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class RegionalBloc {
    
    @JsonProperty("acronym")
    private String acronym;
    @JsonProperty("name")
    private String name;
    @JsonProperty("otherAcronyms")
    private List<Object> otherAcronyms = null;
    @JsonProperty("otherNames")
    private List<Object> otherNames = null;
}
