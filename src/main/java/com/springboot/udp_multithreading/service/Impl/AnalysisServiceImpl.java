package com.springboot.udp_multithreading.service.Impl;

import com.springboot.udp_multithreading.mapper.AnalysisMapper;
import com.springboot.udp_multithreading.pojo.UdpEquipment;
import com.springboot.udp_multithreading.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired(required=false) //承认mapper用非bean配置，否则报错
    private AnalysisMapper analysisMapper;
    @Autowired
    UdpEquipment udpEquipment;
    @Override
    public String udpAccept(String accept) {
        String ChannelID = accept.substring(4,6);
        String PointID = accept.substring(6,10);
        String IEEE754 = accept.substring(10,18);

        System.out.println(ChannelID+PointID+IEEE754);
        udpEquipment.setChannelID(ChannelID);
        udpEquipment.setPointID(PointID);
        udpEquipment.setIEEE754(IEEE754);
        try {
            //成功为1，失败为0
            int i = analysisMapper.udpAccept(udpEquipment);
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return IEEE754;
    }
}
