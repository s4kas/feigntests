package com.bmp.tests.feign.service;

import com.bmp.tests.feign.config.FeignSoapClientConfig;
import com.bmp.tests.feign.model.Add;
import com.bmp.tests.feign.model.AddResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "calculatorServer",
        url = "http://www.dneonline.com/calculator.asmx",
        configuration = FeignSoapClientConfig.class)
public interface FeignSoapClient {

    @PostMapping(value = "", consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE,
            headers = {"SOAPAction=http://tempuri.org/Add"})
    AddResponse calculate(@RequestBody Add addRequest);
}
