package com.qkrwjdgus.springboottest.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    Logger logger = LoggerFactory.getLogger(SampleController.class);

    private SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/hello")
    public String hello() {
        logger.info("log 라니");
        System.out.println("sout 이라니");
        return "Hello " + sampleService.getName();
    }

}
