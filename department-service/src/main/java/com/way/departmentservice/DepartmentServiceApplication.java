package com.way.departmentservice;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DepartmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }


    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * //单机
     * RedissonClient redisson = Redisson.create();
     * Config config = new Config();
     * config.useSingleServer().setAddress("myredisserver:6379");
     * RedissonClient redisson = Redisson.create(config);
     *
     *
     * //主从
     *
     * Config config = new Config();
     * config.useMasterSlaveServers()
     *     .setMasterAddress("127.0.0.1:6379")
     *     .addSlaveAddress("127.0.0.1:6389", "127.0.0.1:6332", "127.0.0.1:6419")
     *     .addSlaveAddress("127.0.0.1:6399");
     * RedissonClient redisson = Redisson.create(config);
     *
     *
     * //哨兵
     * Config config = new Config();
     * config.useSentinelServers()
     *     .setMasterName("mymaster")
     *     .addSentinelAddress("127.0.0.1:26389", "127.0.0.1:26379")
     *     .addSentinelAddress("127.0.0.1:26319");
     * RedissonClient redisson = Redisson.create(config);
     *
     *
     * //集群
     * Config config = new Config();
     * config.useClusterServers()
     *     .setScanInterval(2000) // cluster state scan interval in milliseconds
     *     .addNodeAddress("127.0.0.1:7000", "127.0.0.1:7001")
     *     .addNodeAddress("127.0.0.1:7002");
     * RedissonClient redisson = Redisson.create(config);
     */


    @Bean
    public RedissonClient getRedissonClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setPassword("root");
        return Redisson.create(config);
    }
}
