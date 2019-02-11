package com.mmall.util;

import com.mmall.common.RedisPool;
import com.mmall.common.RedisShardedPool;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

/**
 * @author Timber
 * @date 2019/1/30
 */

@Slf4j
public class RedisShardedPoolUtil {

    // exTime 以秒为单位
    public static Long expire(String key, int exTime) {
        ShardedJedis shardedJedis = null;
        Long result = null;
        try {
            shardedJedis = RedisShardedPool.getJedis();
            result = shardedJedis.expire(key, exTime);
        } catch (Exception e) {
            log.error("expire key:{}, error", key, e);
        }
        RedisShardedPool.returnJedis(shardedJedis);
        return result;
    }

    public static Long del(String key) {
        ShardedJedis shardedJedis = null;
        Long result = null;
        try {
            shardedJedis = RedisShardedPool.getJedis();
            result = shardedJedis.del(key);
        } catch (Exception e) {
            log.error("del key:{}, error", key, e);
        }
        RedisShardedPool.returnJedis(shardedJedis);
        return result;
    }

    public static String get(String key) {
        ShardedJedis shardedJedis = null;
        String result = null;
        try {
            shardedJedis = RedisShardedPool.getJedis();
            result = shardedJedis.get(key);
        } catch (Exception e) {
            log.error("get key:{}, error", key, e);
        }
        RedisShardedPool.returnJedis(shardedJedis);
        return result;
    }

    public static String set(String key, String value) {
        ShardedJedis shardedJedis = null;
        String result = null;
        try {
            shardedJedis = RedisShardedPool.getJedis();
            result = shardedJedis.set(key, value);
        } catch (Exception e) {
            log.error("set key:{}, value:{}, error", key, value, e);
        }
        RedisShardedPool.returnJedis(shardedJedis);
        return result;
    }

    public static String getSet(String key, String value) {
        ShardedJedis shardedJedis = null;
        String result = null;
        try {
            shardedJedis = RedisShardedPool.getJedis();
            result = shardedJedis.getSet(key, value);
        } catch (Exception e) {
            log.error("getset key:{}, value:{}, error", key, value, e);
        }
        RedisShardedPool.returnJedis(shardedJedis);
        return result;
    }

    // exTime 以秒为单位
    public static String setEx(String key, String value, int exTime) {
        ShardedJedis shardedJedis = null;
        String result = null;
        try {
            shardedJedis = RedisShardedPool.getJedis();
            result = shardedJedis.setex(key, exTime, value);
        } catch (Exception e) {
            log.error("setex key:{}, value:{}, error", key, value, e);
        }
        RedisShardedPool.returnJedis(shardedJedis);
        return result;
    }

    public static Long setnx(String key, String value) {
        ShardedJedis shardedJedis = null;
        Long result = null;
        try {
            shardedJedis = RedisShardedPool.getJedis();
            result = shardedJedis.setnx(key, value);
        } catch (Exception e) {
            log.error("setnx key:{}, value:{}, error", key, value, e);
        }
        RedisShardedPool.returnJedis(shardedJedis);
        return result;
    }

}
