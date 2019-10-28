package com.bmp.tests.feign;

import com.bmp.tests.feign.model.Add;
import com.bmp.tests.feign.model.AddResponse;
import com.bmp.tests.feign.service.FeignSoapClient;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@RestController
@Slf4j
public class FeignClientTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignClientTestsApplication.class, args);
    }

    @Autowired
    private FeignSoapClient feignSoapClient;

    @GetMapping("/soap")
    public AddResponse soap() {
        try {
            AddResponse addResponse = feignSoapClient.calculate(new Add(1, 2));
            return addResponse;
        } catch (FeignException e) {
            log.error("Error: ", e);
            return null;
        }
    }
}