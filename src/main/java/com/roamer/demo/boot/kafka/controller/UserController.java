package com.roamer.demo.boot.kafka.controller;

import com.roamer.demo.boot.kafka.entity.User;
import com.roamer.demo.boot.kafka.producer.ProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author roamer
 * @version v1.0
 * @date 2020/10/18 00:24
 */
@RestController
@RequestMapping
public class UserController {

    private final ProducerService producerService;

    public UserController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping
    public void send(@RequestParam(value = "nickname", defaultValue = "未定") String nickname) {
        producerService.sendMsg(new User().setId(System.currentTimeMillis()).setNickname(nickname));
    }
}
