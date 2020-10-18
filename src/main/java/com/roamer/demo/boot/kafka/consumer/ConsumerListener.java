package com.roamer.demo.boot.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 消费者监听器
 *
 * @author roamer
 * @version v1.0
 * @date 2020/10/17 23:45
 */
@Slf4j
public class ConsumerListener {

    @KafkaListener(topics = "test1")
    public void save(List<ConsumerRecord<String, byte[]>> records, Acknowledgment ack) {
        records.forEach(record -> {
            log.info("收到信息: {}", new String(record.value()));
        });

        // 手动确认
        ack.acknowledge();
    }
}
