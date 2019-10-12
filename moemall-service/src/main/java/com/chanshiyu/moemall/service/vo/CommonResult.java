package com.chanshiyu.moemall.service.vo;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author SHIYU
 * @date 2019/8/29 9:17
 * @description 自定义响应数据结构
 */
@Data
public class CommonResult<T> {

    /** 响应业务状态 */
    private Integer status;

    /** 响应消息 */
    private String message;

    /** 响应中的数据 */
    private T data;

    /** 分页描述信息 */
    private ResultAttributes attributes;

    private CommonResult() {
        this.status = HttpStatus.OK.value();
        this.message = "OK";
    }

    private CommonResult(T data, ResultAttributes attributes) {
        this.status = HttpStatus.OK.value();
        this.message = "OK";
        this.data = data;
        this.attributes = attributes;
    }

    private CommonResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public static <T> CommonResult<T> ok() {
        return new CommonResult<>();
    }

    public static <T> CommonResult<T> ok(T data) {
        return new CommonResult<>(data, null);
    }

    public static <T> CommonResult<T> ok(T data, ResultAttributes attributes) {
        return new CommonResult<>(data, attributes);
    }

    public static <T> CommonResult<T> unauthorized(String message) {
        return new CommonResult<>(HttpStatus.UNAUTHORIZED.value(), message);
    }

    public static <T> CommonResult<T> forbidden(String message) {
        return new CommonResult<>(HttpStatus.FORBIDDEN.value(), message);
    }

    public static <T> CommonResult<T> failed() {
        return new CommonResult<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "操作失败");
    }

    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public static <T> CommonResult<T> failed(int status, String message) {
        return new CommonResult<>(status, message);
    }

}