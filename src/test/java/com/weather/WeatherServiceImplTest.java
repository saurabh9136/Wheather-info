package com.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.weather.model.Description;
import com.weather.service.WeatherServiceImpl;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherServiceImpl weatherService;

    @Test
    public void testGetAllData() {
        // Given
        String stateCode = "400075";
        Description mockDescription = new Description();
        mockDescription.setName("Best Staff Colony");
        mockDescription.setTimezone("19800");
        

        when(restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?zip=" + stateCode + ",in&appid=df7d9d47d309d446f5ab57a58f5e2e79", Description.class))
                .thenReturn(mockDescription);

        
        Description result = weatherService.getAllData(stateCode);
        assertEquals("Best Staff Colony", result.getName());
        assertEquals("19800", result.getTimezone());
        
    }
}
