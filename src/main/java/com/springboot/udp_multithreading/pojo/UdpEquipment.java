package com.springboot.udp_multithreading.pojo;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UdpEquipment {
    private String ChannelID;
    private String PointID;
    private String DeviceNum;
    private String DeviceName;
    private String DataName;
    private String Addition;
    private String DeviceID;
    private String IP;
    private String BrandID;
    private String IEEE754;
    private String HEX10;
}
