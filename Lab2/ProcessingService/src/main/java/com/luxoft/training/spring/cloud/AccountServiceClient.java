package com.luxoft.training.spring.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(fallback = AccountServiceFallback.class, name = "AccountService")
public interface AccountServiceClient {
    @RequestMapping("/checkout/{id}")
    boolean checkout(@PathVariable("id") Integer accountId, @RequestParam("sum") BigDecimal sum);
}
