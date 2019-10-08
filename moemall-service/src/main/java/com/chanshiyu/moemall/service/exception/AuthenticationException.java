package com.chanshiyu.moemall.service.exception;

import org.springframework.http.HttpStatus;

/**
 * @author SHIYU
 * @date 2019/10/8 18:40
 * @description 认证异常
 */
public class AuthenticationException extends BaseException {

    public AuthenticationException(String message) {
        super(message);
    }

    @Override
    public int getStatus() {
        return HttpStatus.UNAUTHORIZED.value();
    }

}
