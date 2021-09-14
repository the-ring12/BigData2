package com.the_ring.kafka;



import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.log4j.Logger;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class KafkaAdmin {
    static Logger log = Logger.getLogger(Producer.class);
//
//    private static final String TOPIC = "test";
//    private static final String BROKER_LIST = "192.168.94.6:9092";
//    private static Admin admin;
//
//    /**
//     * 初始化生产者
//     */
//    static {
//        Properties configs = initConfig();
//        admin =  Admin.create(configs);
//    }
//
//    /**
//     * 初始化配置
//     * @return
//     */
//    private static Properties initConfig() {
//        Properties properties = new Properties();
//        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.94.6:9092,192.168.94.6:9091,192.168.94.6:9093");
//        return properties;
//    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        DescribeTopicsResult result = admin.describeTopics(Arrays.asList("test"));
//        KafkaFuture<Map<String, TopicDescription>> all = result.all();
//        Map<String, TopicDescription> stringTopicDescriptionMap = all.get();
//        for (String s : stringTopicDescriptionMap.keySet()) {
//            System.out.println(s);
//        }

        Properties pro = new Properties();
        pro.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.94.6:9092,192.168.94.6:9091,192.168.94.6:9093");
        Admin adminClient = Admin.create(pro);

        Set<String> topics = adminClient.listTopics().names().get();

        for (String topic : topics) {
            System.out.println(topic);
        }


    }
}
