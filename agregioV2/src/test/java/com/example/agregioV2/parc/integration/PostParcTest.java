package com.example.agregioV2.parc.integration;

import com.example.agregioV2.parc.request.HydraulicParcCreationRequestDto;
import com.example.agregioV2.parc.request.ParcCreationRequestDto;
import com.example.agregioV2.parc.request.SolarParcCreationRequestDto;
import com.example.agregioV2.parc.request.WindParcCreationRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostParcTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void a_solar_parc_is_created() {
        ParcCreationRequestDto request = new SolarParcCreationRequestDto(20);

        ResponseEntity<String> response = restTemplate.postForEntity("/parc", request, String.class);

        Assertions.assertAll(
                () -> assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED),
                () -> assertThat(response.getBody()).isNotEmpty()
        );
    }

    @Test
    void a_wind_parc_is_created() {
        ParcCreationRequestDto request = new WindParcCreationRequestDto(20);

        ResponseEntity<String> response = restTemplate.postForEntity("/parc", request, String.class);

        Assertions.assertAll(
                () -> assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED),
                () -> assertThat(response.getBody()).isNotEmpty()
        );
    }

    @Test
    void a_hydraulic_parc_is_created() {
        ParcCreationRequestDto request = new HydraulicParcCreationRequestDto(20);

        ResponseEntity<String> response = restTemplate.postForEntity("/parc", request, String.class);

        Assertions.assertAll(
                () -> assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED),
                () -> assertThat(response.getBody()).isNotEmpty()
        );
    }


}
