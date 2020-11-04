package com.zohn.springboot01.algorithm.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IdGeneratorSnowflake {
    // 机器id
    private long workerId = 1;
    // 数据中心id
    private long dataCenterId = 1;
    private Snowflake snowflake = IdUtil.createSnowflake(workerId, dataCenterId);

    public void init() {
        try {
            // 获取本机的IP地址编码
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workerId：" + workerId);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("当前机器的workerId获取失败----->:" + e);
            workerId= NetUtil.getLocalhostStr().hashCode();
        }
    }

    public synchronized long snowflakeId(){
        return snowflake.nextId();
    }
    // colors
    public synchronized long snowflakeId(long workerId, long dataCenterId){
        Snowflake snowflake = IdUtil.createSnowflake(workerId,dataCenterId);
        return snowflake.nextId();
    }

    public static void main(String[] args) {
        long l = new IdGeneratorSnowflake().snowflakeId();
        System.out.println("======^_^======variable l value is : " + l + ", " + " current method and class name is : IdGeneratorSnowflake.main()");
    }
}
