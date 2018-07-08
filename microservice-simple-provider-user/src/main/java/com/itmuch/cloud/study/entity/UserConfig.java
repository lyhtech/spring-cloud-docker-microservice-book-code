package com.itmuch.cloud.study.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserConfig {
    private String timeZone;

    private String server;
}
