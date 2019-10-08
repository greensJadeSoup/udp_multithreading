package com.springboot.udp_multithreading.controller;

import com.springboot.udp_multithreading.service.AnalysisService;
import com.springboot.udp_multithreading.service.SendAcceptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("")
public class DemoController {
    //随机数工具
    Random random = new Random();
    @Autowired
    private SendAcceptService sendAcceptService;
    @Autowired
    private AnalysisService analysisService;

    @RequestMapping(value="findOne", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String test(@RequestParam(value="first") String first){
        //01+01+(xx)+(xxxx)
        String send = "0101"+first;
        System.out.println("发送："+send);
        String accept = sendAcceptService.sendAccept(send,random.nextInt(50));
        System.out.println("处理后得到："+analysisService.udpAccept(accept));
        return accept;
    }

    @RequestMapping(value="findTwo", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String test(@RequestParam(value="first") String first,@RequestParam(value="second") String second){
        String send = "0102"+first+second;
        System.out.println("发送："+send);
        String accept = sendAcceptService.sendAccept(send,random.nextInt(50));
        return accept;
    }
}
