package com.mmall.common;

import com.mmall.util.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Timber
 * @date 2019/2/12
 */

@Component
@Slf4j
public class RedissonManager {

    private Config config = new Config();
    private Redisson redisson;

    private static String redis1IP = PropertiesUtil.getProperty("redis1.ip", "192.168.23.130");
    private static Integer redis1Port = Integer.parseInt(PropertiesUtil.getProperty("redis1.port", "6379"));
    private static String redis2IP = PropertiesUtil.getProperty("redis2.ip", "192.168.23.130");
    private static Integer redis2Port = Integer.parseInt(PropertiesUtil.getProperty("redis2.port", "6380"));

    @PostConstruct
    public void init() {
        try {
            config.useSingleServer().setAddress(redis1IP + ":" + redis1Port);
            redisson = (Redisson) Redisson.create(config);
            log.info("初始化 Redisson 结束");
        } catch (Exception e) {
            log.error("初始化 Redisson 失败", e);
        }
    }

    public Redisson getRedisson() {
        return redisson;
    }
}
