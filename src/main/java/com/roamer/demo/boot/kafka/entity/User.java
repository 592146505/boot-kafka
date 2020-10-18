package com.roamer.demo.boot.kafka.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author roamer
 * @version v1.0
 * @date 2020/10/18 00:09
 */
@Accessors(chain = true)
@NoArgsConstructor
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -4880255270904951881L;

    private Long id;

    private String nickname;
}
