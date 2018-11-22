package com.luxoft.training.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProcessingRest {
    @Autowired
    private AccountServiceClient accountServiceClient;
    @Autowired
    private CardServiceClient cardServiceClient;
    @Autowired
    private ProcessingRepository processingRepository;

    @RequestMapping(path = "/issue/{accountId}")
    public String issue(@PathVariable Integer accountId) {
        ProcessingEntity entity = new ProcessingEntity();
        entity.setAccountId(accountId);
        entity.setCard(cardServiceClient.create());
        processingRepository.save(entity);
        return entity.getCard();
    }

    @RequestMapping(path = "/checkout/{card}")
    public boolean checkout(@PathVariable String card, @RequestParam BigDecimal sum) {
        ProcessingEntity entity = processingRepository.findByCard(card);
        return entity == null ? false :
                accountServiceClient.checkout(entity.getAccountId(), sum);
    }

    @RequestMapping(path = "/get")
    public Map<Integer, String> get(@RequestParam List<Integer> accounts) {
        Map<Integer, String> map = new HashMap<>();
        processingRepository.findByAccountIdIn(accounts).forEach(pe -> map.put(pe.getAccountId(), pe.getCard()));
        return map;
    }
}
