package com.luxoft.training.spring.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "CardService", fallback = CardServiceFallback.class)
public interface CardServiceClient {
    @RequestMapping(path = "create")
    String create();
}
