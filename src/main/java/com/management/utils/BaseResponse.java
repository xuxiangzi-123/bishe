package com.management.utils;

import lombok.Data;

@Data
public class BaseResponse<T> {
        private String message;
        private Integer code;
        private T data;

    }

