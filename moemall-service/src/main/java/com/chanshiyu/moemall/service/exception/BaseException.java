package com.chanshiyu.moemall.service.exception;

import org.springframework.http.HttpStatus;

/**
 * @author SHIYU
 * @data 2019/10/8 18:18
 * @description 基本异常类型
 */
public abstract class BaseException extends RuntimeException {

    BaseException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatus();

}
