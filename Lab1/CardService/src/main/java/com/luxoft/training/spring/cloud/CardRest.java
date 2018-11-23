package com.luxoft.training.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardRest {
    @Autowired
    private CardNumberGenerator numberGenerator;

    @RequestMapping(path = "/create")
    public String create() {
        return numberGenerator.generate();
    }
}
