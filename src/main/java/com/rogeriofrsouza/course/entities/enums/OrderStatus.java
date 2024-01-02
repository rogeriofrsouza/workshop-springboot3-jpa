package com.rogeriofrsouza.course.entities.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private final int code;

    OrderStatus(int code) {
        this.code = code;
    }

    public static OrderStatus valueOf(int code) {
        return Arrays.stream(values()).filter(i -> i.getCode() == code).findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid OrderStatus code"));
    }

}
