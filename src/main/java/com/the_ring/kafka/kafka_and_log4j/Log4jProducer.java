package com.the_ring.kafka.kafka_and_log4j;


import org.apache.log4j.Logger;

public class Log4jProducer {
    private static final Logger LOG = Logger.getLogger(Log4jProducer.class);
    public static void main(String[] args) {
        LOG.info("这是一条 info 级别的日志！！");
//        System.out.println("这是一条 info 级别的日志！！");
        LOG.error("这是一条 error 级别的日志！！");
    }
}
