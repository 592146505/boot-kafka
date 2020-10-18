package com.roamer.demo.boot.kafka.producer;

import com.roamer.demo.boot.kafka.entity.User;
import com.roamer.demo.boot.kafka.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

/**
 * 生产者
 *
 * @author roamer
 * @version v1.0
 * @date 2020/10/18 00:07
 */
@Slf4j
@Service
public class ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMsg(User user) {
        log.info("java.security.auth.login.config:{}", System.getProperty("java.security.auth.login.config"));
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("test1",user.getId().toString(), JsonUtil.toJson(user));
        future.addCallback((SuccessCallback<Object>) o -> {
            log.info("发生成功：{}", JsonUtil.toJson(o));
        }, thr -> {
            log.error("发生消息失败", thr);
        });
    }
}
