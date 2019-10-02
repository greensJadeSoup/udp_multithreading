package com.springboot.udp_multithreading.utils.udp;

import lombok.Data;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Random;

@Data
public class UdpConfig {
    private DatagramSocket clientSocket = null;
    private InetSocketAddress serverAddress = null;
    //private static String UDP_URL="192.168.1.123";
    //private static Integer UDP_PORT=8002;
    private String UDP_URL="10.3.52.240";
    private Integer SERVER_PORT=22001; //服务器端口

    public DatagramSocket getDatagramSocket(int port)throws SocketException {
        return (clientSocket == null)?new DatagramSocket(port):clientSocket;//客户端端口
    }
    public InetSocketAddress getInetSocketAddress()throws SocketException {
        return (serverAddress == null)?new InetSocketAddress(UDP_URL, SERVER_PORT):serverAddress;
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
    //将字符串转成16进制的字符数组
    public static byte[] getHexBytes(String str){
        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }
        return bytes;
    }
}
