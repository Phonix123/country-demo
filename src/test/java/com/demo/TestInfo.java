package com.demo;

import com.demo.client.CountryOverallInfoService;
import com.demo.client.WeatherlInfoService;
import com.demo.controller.rest.CountryRest;
import com.demo.dto.country.CountryDto;
import com.demo.dto.country.CountryInfoAndWeatherDto;
import com.demo.dto.weather.WeatherDto;
import com.demo.dto.weather.elements.Main;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

//@RunWith(SpringJUnit4ClassRunner.class)
class TestInfo {

    @Mock
    private CountryOverallInfoService mockCountryService;

    @Mock
    private WeatherlInfoService mockWeatherService;

    @InjectMocks
    private CountryRest rest;

    MockHttpServletRequest request = new MockHttpServletRequest();

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        request.setSecure(true);
    }

    @Test
    void checkInfo() {
        CountryDto country = CountryDto.builder().name("Portugal").alpha3Code("PRT").capital("Lisboa").build();
        when(mockCountryService.getCountryInformation("PRT")).thenReturn(country);

        ResponseEntity<?> result = rest.info("PRT", request);

        assertThat(result.getStatusCode().is2xxSuccessful());

        CountryInfoAndWeatherDto dto = (CountryInfoAndWeatherDto) result.getBody();
        assertThat(dto.getInfo()).isNotNull();
        assertThat(dto.getInfo().getCapital()).isEqualTo("Lisboa");

    }

    @Test
    void checkWeather() {
        CountryDto country = CountryDto.builder().name("Portugal").alpha3Code("PRT").capital("Lisboa").build();
        when(mockCountryService.getCountryInformation("PRT")).thenReturn(country);
        when(mockWeatherService.getCapitalWeather(country)).thenReturn(WeatherDto.builder().main(Main.builder().temp(20d).build()).build());

        ResponseEntity<?> result = rest.info("PRT", request);
        assertThat(result.getStatusCode().is2xxSuccessful());

        CountryInfoAndWeatherDto dto = (CountryInfoAndWeatherDto) result.getBody();
        assertThat(dto.getWeather()).isNotNull();
        assertThat(dto.getWeather().getMain().getTemp()).isEqualTo(20d);

    }

}
