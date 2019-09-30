package com.springboot.udp_multithreading.service;

import java.net.Socket;

public interface Log4jService {
    void analysis(Socket socket, String data);
}
