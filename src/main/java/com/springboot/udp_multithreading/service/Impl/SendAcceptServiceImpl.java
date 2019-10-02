package com.springboot.udp_multithreading.service.Impl;

import com.springboot.udp_multithreading.service.SendAcceptService;
import com.springboot.udp_multithreading.utils.udp.UdpConfig;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;

@Service
public class SendAcceptServiceImpl implements SendAcceptService {
    UdpConfig udpConfig = new UdpConfig();
    @Test
    public String sendAccept(String agreement,int port){
        try {
            byte[] bytes = new byte[1024];
            //假装负载均衡，端口60000+（0~50），防止占用
            DatagramSocket datagramSocket = udpConfig.getDatagramSocket(port);
            //发送
            //盲猜utf-8,gbk,ISO-8859-1
            bytes = agreement.getBytes("gbk");
            //System.out.println("2:"+udpConfig.getHexBytes("0102010002020001"));
            //转化为16进制
            //bytes = udpConfig.getHexBytes("0102010002020001");
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length,udpConfig.getInetSocketAddress());
            datagramSocket.send(packet);
            //接收
           // DatagramPacket packet2 = new DatagramPacket(data, data.length);
            datagramSocket.receive(packet);
            bytes = packet.getData();

            //String msg = new String(packet.getData(), 0, packet.getLength());
            //System.out.println("接收到："+msg);

            String data = udpConfig.getBufHexStr(bytes);


            System.out.println("接收到:"+data);
            datagramSocket.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
