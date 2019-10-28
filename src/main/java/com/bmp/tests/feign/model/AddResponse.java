package com.bmp.tests.feign.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(namespace = "http://tempuri.org/", name = "AddResponse")
public class AddResponse {
    private int addResult;
}
