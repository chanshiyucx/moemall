package com.chanshiyu.moemall.service.exception;

/**
 * @author SHIYU
 * @data 2019/10/8 18:18
 * @description 基本异常类型
 */
public abstract class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public abstract int getStatus();

}
