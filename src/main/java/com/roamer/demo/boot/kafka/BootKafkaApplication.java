package com.roamer.demo.boot.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class BootKafkaApplication {

    public static void main(String[] args) {
        System.setProperty("java.security.auth.login.config",
                           "/Users/wangshichang/WorkSpace/Projects/boot-kafka/kafka_client_jaas.conf");
        SpringApplication.run(BootKafkaApplication.class, args);
    }

}
