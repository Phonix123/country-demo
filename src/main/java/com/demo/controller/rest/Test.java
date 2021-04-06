/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diaspedr
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "rest")
@CrossOrigin(origins = {"http://localhost:8081"})
public class Test {


    @GetMapping(value = "/country-info")
    public void info() {
        
    }
}
