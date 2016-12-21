package com.taotao.rest.jedis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;

/**
 * Jedis测试
 * Created with IntelliJ IDEA
 * Created by ustcck on 2016/12/18 18:43.
 */

public class JedisTest {
    @Test
    public void testJedisSingle() {
        //创建一个jedis对象
        Jedis jedis = new Jedis("120.27.49.184", 6379);
        //调用jedis对象的方法，方法名称和redis的一致
        jedis.set("key1", "jedis test");
        String key1 = jedis.get("key1");
        System.out.println(key1);

        //关闭jedis
        jedis.close();
    }

    //使用连接池
    @Test
    public void testJedisPool() {
        //创建jedis连接池
        JedisPool jedisPool = new JedisPool("120.27.49.184", 6379);
        //从连接池中获取连接池对象
        Jedis jedis = jedisPool.getResource();
        String key1 = jedis.get("key1");
        System.out.println(key1);
        jedis.close();
        jedisPool.close();

    }

    //集群版
    @Test
    public void testJedisCluster() {
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("120.27.49.184", 7001));
        nodes.add(new HostAndPort("120.27.49.184", 7002));
        nodes.add(new HostAndPort("120.27.49.184", 7003));
        nodes.add(new HostAndPort("120.27.49.184", 7004));
        nodes.add(new HostAndPort("120.27.49.184", 7005));
        nodes.add(new HostAndPort("120.27.49.184", 7006));
        JedisCluster cluster = new JedisCluster(nodes);
        cluster.set("key1", "1000");
        String key1 = cluster.get("key1");
        System.out.println(key1);
        cluster.close();
    }


    //单机版测试
    @Test
    public void testSpringJedisSingle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        JedisPool pool = (JedisPool) applicationContext.getBean("redisClient");
        Jedis jedis = pool.getResource();
        String key1 = jedis.get("key1");
        System.out.println(key1);

        jedis.close();
        pool.close();
    }

    //集群版测试
 /*   @Test
    public void testSpringJedisCluster() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        JedisCluster jedisCluster =  (JedisCluster) applicationContext.getBean("redisClient");
        String string = jedisCluster.get("key1");
        System.out.println(string);
        jedisCluster.close();
    }*/

}
