package com.www.studyday.controller;

import com.www.studyday.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") // localhost:8080/api/getMethod
    public String getMethod() {
        System.out.println("hiGetMethod");
        return "Hi GetMethod";
    }

    @GetMapping("/Login")
    public String getParameter(@RequestParam String id, @RequestParam String pw) {
        return "12345";
    }

    @GetMapping("/header")
    public Header getHeader() {
        return Header.builder().resultCode("OK").description("OK").build();
    }
}
