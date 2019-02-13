package com.yaya.spring.boot.demo.core.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/demo")
public class DemoApi {

    @GetMapping(path = "/hello/v1.html")
    String home() {
        return "Hello World!";
    }

}
