package com.javatpoint.microservices.currencyexchangeservice.controller;


import com.javatpoint.microservices.currencyexchangeservice.model.ExchangeValue;
import com.javatpoint.microservices.currencyexchangeservice.repo.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Value("${server.port}")
    private int port;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {

        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(port);

        return exchangeValue;
    }
}
