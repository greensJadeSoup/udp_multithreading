package com.springboot.udp_multithreading.utils.udp;

import lombok.Data;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

@Data
public class UdpConfig {
    private DatagramSocket clientSocket = null;
    private InetSocketAddress serverAddress = null;
    //private static String UDP_URL="192.168.1.123";
    //private static Integer UDP_PORT=8002;
    private String UDP_URL="10.3.52.240";
    private Integer SERVER_PORT=22001; //服务器端口
    private Integer CLIENT_PORT=60001;   //客户端端口

    public DatagramSocket getDatagramSocket()throws SocketException {
        return (clientSocket == null)?new DatagramSocket(CLIENT_PORT):clientSocket;
    }
    public InetSocketAddress getInetSocketAddress()throws SocketException {
        return (serverAddress == null)?new InetSocketAddress(UDP_URL, SERVER_PORT):serverAddress;
    }
}
