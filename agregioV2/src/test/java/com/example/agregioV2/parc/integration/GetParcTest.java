package com.example.agregioV2.parc.integration;

import com.example.agregioV2.parc.entities.HydraulicParcDto;
import com.example.agregioV2.parc.entities.ParcDto;
import com.example.agregioV2.parc.entities.SolarParcDto;
import com.example.agregioV2.parc.entities.WindParcDto;
import com.example.agregioV2.parc.repository.InMemoryParcRepository;
import com.example.agregioV2.parc.request.HydraulicParcCreationRequestDto;
import com.example.agregioV2.parc.request.SolarParcCreationRequestDto;
import com.example.agregioV2.parc.request.WindParcCreationRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetParcTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private InMemoryParcRepository inMemoryParcRepository;

    @Test
    void a_solar_parc_is_found() {
        inMemoryParcRepository.create(new SolarParcCreationRequestDto(20), "uuid");

        ResponseEntity<ParcDto> response = restTemplate.getForEntity("/parc/uuid", ParcDto.class);

        ParcDto expectedSolarParc = new SolarParcDto(("uuid"), 20);
        assertThat(response.getBody()).isEqualTo(expectedSolarParc);
    }

    @Test
    void a_wind_parc_is_found() {
        inMemoryParcRepository.create(new WindParcCreationRequestDto(20), "uuid");

        ResponseEntity<ParcDto> response = restTemplate.getForEntity("/parc/uuid", ParcDto.class);

        ParcDto expectedWindParc = new WindParcDto(("uuid"), 20);
        assertThat(response.getBody()).isEqualTo(expectedWindParc);
    }

    @Test
    void a_hydraulic_parc_is_found() {
        inMemoryParcRepository.create(new HydraulicParcCreationRequestDto(20), "uuid");

        ResponseEntity<ParcDto> response = restTemplate.getForEntity("/parc/uuid", ParcDto.class);

        ParcDto expectedHydraulicParc = new HydraulicParcDto(("uuid"), 20);
        assertThat(response.getBody()).isEqualTo(expectedHydraulicParc);
    }

}
