package com.daitda.backend.advertisement.controller;

import com.daitda.backend.advertisement.domain.Ads;
import com.daitda.backend.advertisement.domain.AdsRepository;
import com.daitda.backend.advertisement.dto.AdsSaveRequestDto;
import com.daitda.backend.advertisement_log.domain.AdLogsRepository;
import com.daitda.backend.user.domain.UsersRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdsControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AdsRepository adsRepository;

    @Autowired
    private AdLogsRepository adLogsRepository;

    public void adsTearDown(Long id) throws Exception {
        adsRepository.deleteById(id);
    }

    AdsControllerTest() {
    }

    @Test
    void index() {
    }

    @Test
    void save() throws Exception {
        // given
        String title = "fsadfasdf";
        String agency = "agefasfasddncy";
        Long id;

        AdsSaveRequestDto requestDto = AdsSaveRequestDto.builder()
                .title(title)
                .agency(agency)
                .build();
        String url = "http://localhost:" + port + "/ad";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        id = responseEntity.getBody();
        assertThat(id)
                .isGreaterThan(0L);
        System.out.println(id);

        Optional<Ads> response = adsRepository
                .findById((id != null) ? id : 0);
        assertThat(response.orElseThrow(() -> new IllegalArgumentException("에러"))
                .getTitle())
                .isEqualTo(title);
        assertThat(response.orElseThrow(() -> new IllegalArgumentException("에러"))
                .getAgency())
                .isEqualTo(agency);
        adsTearDown(id);
    }

    @Test
    void delete() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void logsIndex() {
    }

    @Test
    void logsOneIndex() {
    }
}