package com.springboot.udp_multithreading.controller;

import com.springboot.udp_multithreading.service.SendAcceptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("")
public class DemoController {
    //随机数工具
    Random random = new Random();
    @Autowired
    private SendAcceptService sendAcceptService;
    @RequestMapping("1")
    public String test(){
        return sendAcceptService.sendAccept("0102010002020001",random.nextInt(50));
    }
    @RequestMapping("2")
    public String demo(){
        return sendAcceptService.sendAccept("0102010002020001",random.nextInt(50));
    }
}
