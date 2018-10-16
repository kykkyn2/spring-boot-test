package com.qkrwjdgus.springboottest.sample;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SampleControllerRestTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private SampleService mockSampleService;

    @Test
    public void hello() throws Exception {

        String result = testRestTemplate.getForObject("/hello", String.class);
        assertThat(result).isEqualTo("Hello kykkyn2");

    }

    @Test
    public void helloMocking() throws Exception {

        when(mockSampleService.getName()).thenReturn("babo");

        String result = testRestTemplate.getForObject("/hello", String.class);
        assertThat(result).isEqualTo("Hello babo");

    }

}