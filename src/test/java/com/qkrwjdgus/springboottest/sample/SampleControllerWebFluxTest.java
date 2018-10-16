package com.qkrwjdgus.springboottest.sample;


import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class SampleControllerWebFluxTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private SampleService mockSampleService;

    @Test
    public void hello() throws Exception {

        when(mockSampleService.getName()).thenReturn("babo");

        webTestClient.get().uri("/hello").exchange()
            .expectStatus().isOk()
            .expectBody(String.class).isEqualTo("Hello babo");

    }

}