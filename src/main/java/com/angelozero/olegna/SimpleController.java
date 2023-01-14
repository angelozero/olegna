package com.angelozero.olegna;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/")
    public String simpleRequest() {
        return "OK";
    }
}
