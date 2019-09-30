package com.springboot.udp_multithreading.utils.log4j;
//动态建立文件夹

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DynamicBuildFolder {
    public static void storage() {
        //日期文件路径
        Date date = new Date();
        String filePath = System.getProperty("user.dir") + "/logs" + "/" + new SimpleDateFormat("yyyy/MM/dd/").format(date);
        //如果不存在,创建文件夹
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
            file = new File(filePath); // 重新实例化
        }
        //log4j动态加载路径
        System.setProperty("logs.path", filePath);
    }
}
