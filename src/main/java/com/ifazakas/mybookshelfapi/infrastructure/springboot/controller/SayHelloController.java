package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller;

import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.httpresponsebody.SayHelloHttpResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SayHelloController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public SayHelloHttpResponseBody sayHello(@PathVariable(value = "name") String name) {
        return new SayHelloHttpResponseBody("Hi there " + name);
    }

}

