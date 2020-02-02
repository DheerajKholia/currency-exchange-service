package com.dheeraj.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/{from}/to/{to}")
    public ExchnageValue retreiveExchnageValue(@PathVariable String from, @PathVariable String to){
        ExchnageValue exchnageValue=repository.findByFromAndTo(from,to);
        //new ExchnageValue(1000L, from, to, BigDecimal.valueOf(65));
        exchnageValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchnageValue;
    }
}
