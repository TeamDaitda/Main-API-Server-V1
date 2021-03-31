//package com.daitda.backend.user.controller;
//
//import com.daitda.backend.user.domain.Users;
//import com.daitda.backend.user.domain.UsersRepository;
//import com.daitda.backend.user.dto.UsersSaveRequestDto;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(locations = "classpath: application.yaml")
//public class UserControllerTest {
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    private UsersRepository usersRepository;
//
//    @Test
//    public void 사용자_등록() throws Exception {
//        //  given
//        String name = "김이박";
//        String affiliation = "숭실대학교";
//        String phone = "010-1234-5678";
//        int category = 1004;
//
//        UsersSaveRequestDto requestDto = UsersSaveRequestDto.builder()
//                .name(name)
//                .affiliation(affiliation)
//                .phone(phone)
//                .category(category)
//                .build();
//
//        String url = "http://localhost:" + port + "/com/daitda/backend/user";
//
//        //  when
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
//
//        //  then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        Long id = responseEntity.getBody();
//
//        List<Users> all = usersRepository.findAll();
//        assertThat(all.get(id.intValue()).getName()).isEqualTo(name);
//        assertThat(all.get(id.intValue()).getAffiliation()).isEqualTo(affiliation);
//        assertThat(all.get(id.intValue()).getPhone()).isEqualTo(phone);
//        assertThat(all.get(id.intValue()).getCategory()).isEqualTo(category);
//    }
//
//
//}
