package com.bodax.home.managment.controller;

import com.bodax.home.managment.db.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnStudent() throws Exception {
        Student student = new Student();
        student.setId(5L);
        student.setFirstName("Ivan");
        student.setLastName("Recic");
        student.setEmailId("ivan@gmail.com");
        student.setCourse("Web Development with Java");
        student.setCity("Barcelona");
        student.setCountry("Spain");

        String expectedJson = new ObjectMapper()
                .writeValueAsString(student);

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/students/5",
                String.class)).isEqualTo(expectedJson);
    }

}
