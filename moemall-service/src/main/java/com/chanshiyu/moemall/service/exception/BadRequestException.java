package com.chanshiyu.moemall.service.exception;

import org.springframework.http.HttpStatus;

/**
 * @author SHIYU
 * @date 2019/10/8 19:33
 * @description 错误请求异常
 */
public class BadRequestException extends BaseException {

    public BadRequestException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }

}