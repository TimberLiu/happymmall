package com.mmall.common;

import com.google.common.collect.Lists;
import com.mmall.util.PropertiesUtil;
import redis.clients.jedis.*;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

/**
 * @author Timber
 * @date 2019/2/6
 */
public class RedisShardedPool {

    private static ShardedJedisPool pool;

    private static String redis1IP = PropertiesUtil.getProperty("redis1.ip", "192.168.23.130");
    private static Integer redis1Port = Integer.parseInt(PropertiesUtil.getProperty("redis1.port", "6379"));

    private static String redis2IP = PropertiesUtil.getProperty("redis2.ip", "192.168.23.130");
    private static Integer redis2Port = Integer.parseInt(PropertiesUtil.getProperty("redis2.port", "6380"));


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
        config.setBlockWhenExhausted(true);

        JedisShardInfo info1 = new JedisShardInfo(redis1IP, redis1Port, 1000*2);
        JedisShardInfo info2 = new JedisShardInfo(redis2IP, redis2Port, 1000*2);

        pool = new ShardedJedisPool(config, Lists.newArrayList(info1, info2), Hashing.MURMUR_HASH, Sharded.DEFAULT_KEY_TAG_PATTERN);
    }

    public static ShardedJedis getJedis() {
        return pool.getResource();
    }

    public static void returnJedis(ShardedJedis shardedJedis) {
        shardedJedis.close();
    }

    public static void main(String[] args) {
        ShardedJedis shardedJedis = RedisShardedPool.getJedis();

        for (int i = 0; i < 10; i++) {
            shardedJedis.set("key" + i, "value" + i);
        }
        shardedJedis.set("liu", "jie");

        returnJedis(shardedJedis);

//        pool.destroy();
    }

}
