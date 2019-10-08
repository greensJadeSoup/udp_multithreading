
package com.springboot.udp_multithreading.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.springboot.udp_multithreading.pojo.UdpEquipment;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper//指定该接口为Mapper，注入spring容器
public interface AnalysisMapper {

    @Update("update udpEquipment set IEEE754=#{IEEE754} where ChannelID =#{ChannelID} and PointID = #{PointID} ")
    int udpAccept(UdpEquipment udpEquipment) throws Exception;
}
