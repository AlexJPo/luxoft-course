package com.luxoft.training.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountRest {
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(path = "/create")
    public void create(@RequestParam(name = "client_id") Integer clientId) {
        accountDAO.create(clientId);
    }

    @RequestMapping(path = "/fund/{id}")
    public void fund(@PathVariable(name = "id") Integer id, @RequestParam BigDecimal sum) {
        accountDAO.addBalance(id, sum.abs());
    }

    @RequestMapping(path = "/checkout/{id}")
    public void checkout(@PathVariable(name = "id") Integer id, @RequestParam BigDecimal sum) {
        accountDAO.addBalance(id, sum.abs().negate());
    }

    @RequestMapping(path = "/get/{id}")
    public List<? extends Account> get(@PathVariable(name = "id") Integer id) {
        return accountRepository.findByClientId(id);
    }
}
