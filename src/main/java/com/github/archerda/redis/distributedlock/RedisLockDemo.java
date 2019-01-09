package com.github.archerda.redis.distributedlock;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Redis分布式锁
 *
 * @author archerda
 * @date 2018/8/8
 */
public class RedisLockDemo {

    private static final Jedis JEDIS = new Jedis("10.113.7.1", 6379);

    public static void main(String[] args) {
        RedisLockDemo redisLockDemo = new RedisLockDemo();

        redisLockDemo.version4();
    }

    /**
     * 版本1:
     *  使用 setnx
     *
     * 不足:
     *  锁不会被释放, 后续无法获取;
     */
    private void version1() {
        String key = "archerda";
        if (JEDIS.setnx(key, "1") == 1L) {
            System.out.println("获取锁成功");
        } else {
            System.out.println("获取锁失败");
        }
    }

    /**
     * 版本2:
     *  使用 setnx, 处理完后手动 del
     *
     * 不足:
     *  在操作②的时候, 如果线程突然down了, 导致没有释放锁;
     */
    private void version2() {
        String key = "archerda";

        // ① 获取锁
        if (JEDIS.setnx(key, "1") == 1L) {
            System.out.println("获取锁成功");
        } else {
            System.out.println("获取锁失败");
            return;
        }

        // ② Do something

        // ③ 释放锁
        JEDIS.del(key);
    }

    /**
     * 版本3:
     *  使用 setnx和expire;
     *
     * 不足:
     *  在操作②的时候, 如果线程突然down了, 导致没有执行expire操作, 最后锁还是无法释放;
     */
    private void version3() {
        String key = "archerda";

        // ① 获取锁
        if (JEDIS.setnx(key, "1") == 1L) {
            // ② 设置expire
            JEDIS.expire(key, 5);
            System.out.println("获取锁成功");
        } else {
            System.out.println("获取锁失败");
            return;
        }

        // ③ Do something
    }

    /**
     * 版本4:
     *  使用 事务包装setnx和expire;
     *
     * 不足:
     *  无论setnx是否执行成功, expire一直都会执行, 当请求过多的时候, 会导致锁的有效时间一直更新, 导致一直无法获取;
     *
     */
    private void version4() {
        String key = "archerda";

        // ① 开启事务
        Transaction transaction = JEDIS.multi();
        // ② 获取锁
        transaction.setnx(key, "1");
        transaction.expire(key, 5);
        // ③ 提交事务
        List<Object> respList = transaction.exec();

        if (CollectionUtils.isEmpty(respList) || respList.size() < 2) {
            System.out.println("获取锁失败");
            return;
        }
        if ((Long) respList.get(0) != 1L || (Long) respList.get(1) != 1L) {
            System.out.println("获取锁失败");
            return;
        }

        System.out.println("获取锁成功");

        // ④ Do something
    }

    /**
     * 版本5:
     *  使用 setnx 和 getset
     *
     */
    private void version5() {
        String key = "archerda";
        long now = System.currentTimeMillis();
        long lockTimeout = now + 3000;

        // 存的是绝对的过期时间戳;
        boolean nxRet = JEDIS.setnx(key, Long.valueOf(now).toString()) == 1L;

        if (nxRet
                || (now > Long.parseLong(JEDIS.get(key)) && now > Long.parseLong(JEDIS.getSet(key, Long.valueOf(lockTimeout).toString())))) {

            System.out.println("获取锁成功");
        } else {
            System.out.println("获取锁失败");
        }

    }

    /**
     * [单机Redis的完美脚本]版本6:
     *  使用 set() 高级参数;
     */
    private void version6() {
        String key = "archerda";

        String value = RandomStringUtils.random(16);
        try {
            // 把setnx+expire整合为一个原子命令
            JEDIS.set(key, value, "NX", "EX", 3L);
        } finally {
            /* Lua 脚本
            if redis.call("get",KEYS[1]) == ARGV[1] then
                return redis.call("del",KEYS[1])
            else
                return 0
            end
             */
        }

    }

}
