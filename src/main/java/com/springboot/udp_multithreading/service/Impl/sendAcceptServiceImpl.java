package com.springboot.udp_multithreading.service.Impl;

import com.springboot.udp_multithreading.utils.udp.UdpConfig;
import org.junit.jupiter.api.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class sendAcceptServiceImpl {

    UdpConfig udpConfig = new UdpConfig();
    @Test
    public void sendAccept(){
        try {
            byte[] bytes = new byte[1024];
            DatagramSocket datagramSocket = udpConfig.getDatagramSocket();
            //发送
            //盲猜utf-8,gbk,ISO-8859-1
            bytes = "0102010002020001".getBytes("gbk");
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length,udpConfig.getInetSocketAddress());
            datagramSocket.send(packet);
            //接收
           // DatagramPacket packet2 = new DatagramPacket(data, data.length);
            datagramSocket.receive(packet);
            bytes = packet.getData();
            String data = getBufHexStr(bytes);
            System.out.println(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //将16进制的byte数组转换成字符串
    public static String getBufHexStr(byte[] raw){
        String HEXES = "0123456789ABCDEF";
        if ( raw == null ) {
            return null;
        }
        final StringBuilder hex = new StringBuilder( 2 * raw.length );
        for ( final byte b : raw ) {
            hex.append(HEXES.charAt((b & 0xF0) >> 4))
                    .append(HEXES.charAt((b & 0x0F)));
        }
        return hex.toString();
    }
}
