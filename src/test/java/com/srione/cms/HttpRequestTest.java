package com.srione.cms;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void homeControllerShouldReturnMessage(){
        Assertions.assertThat(this.testRestTemplate
                .getForObject("http://localhost:" + port + "/", String.class))
                .contains("Unauthorized");
    }

    @Test
    public void homeControllerShouldPassWithAuthorization(){
        this.testRestTemplate = new TestRestTemplate("user", "password");
        Assertions.assertThat(this.testRestTemplate
                .getForObject("http://localhost:" + port + "/", String.class))
                .contains("Application is working absolutely amazing!!!");
    }
}
