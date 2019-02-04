package com.mmall.common;

import com.mmall.util.PropertiesUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Timber
 * @date 2019/1/30
 */
public class RedisPool {

    private static JedisPool jedisPool;

    private static String redisIP = PropertiesUtil.getProperty("redis.ip", "192.168.23.130");
    private static Integer redisPort = Integer.parseInt(PropertiesUtil.getProperty("redis.port", "6379"));

    // 最大连接数
    private static Integer maxTotal = Integer.parseInt(PropertiesUtil.getProperty("redis.max.total", "20"));
    // 最大的 idle 状态的 jedis 实例个数
    private static Integer maxIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.max.idle", "10"));
    // 最小的 idle 状态的 jedis 实例个数
    private static Integer minIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.min.idle", "2"));

    // 在 borrow 一个 jedis 实例时，是否要进行验证操作
    private static Boolean testOnBorrow = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.borrow", "true"));
    // 在 return 一个 jedis 实例时，是否要进行验证操作
    private static Boolean testOnReturn = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.return", "true"));

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        config.setTestOnBorrow(testOnBorrow);
        config.setTestOnReturn(testOnReturn);

        jedisPool = new JedisPool(config, redisIP, redisPort, 1000*2);
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void returnJedis(Jedis jedis) {
        jedis.close();
    }

    public static void main(String[] args) {
        Jedis jedis = RedisPool.getJedis();
        jedis.set("liu", "jie");
        System.out.println(jedis.get("liu"));
        returnJedis(jedis);

        jedisPool.destroy();
    }

}
