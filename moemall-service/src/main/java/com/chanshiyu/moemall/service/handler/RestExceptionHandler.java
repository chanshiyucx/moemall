package com.chanshiyu.moemall.service.handler;

import com.chanshiyu.moemall.service.exception.AuthenticationException;
import com.chanshiyu.moemall.service.vo.CommonResult;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.stream.Stream;

/**
 * @author SHIYU
 * @date 2019/8/29 9:51
 * @description 全局异常提示
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult<String> defaultErrorHandler(Exception e) {
        e.printStackTrace();
        return CommonResult.errorMsg(e.getMessage());
    }

    /**
     * 普通Restful接口参数判断
     * @param e 具体异常
     * @return 包括的类型
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult<String> argumentNotValidException(MethodArgumentNotValidException e) {
        return CommonResult.errorMsg(getValidException(e));
    }

    /**
     * webflux接口参数判断
     * @param e 具体异常
     * @return 包括的类型
     */
    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult<String> handleBindException(WebExchangeBindException e) {
        return CommonResult.errorMsg(getValidException(e));
    }

    /**
     * 自定义异常
     * @param e 具体异常
     * @return
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult<String> handleBindException(AuthenticationException e) {
        return CommonResult.errorMsg(e.getStatus(), e.getMessage());
    }

    /**
     * Restful 把校验异常转换为字符串
     * @param ex 具体异常
     * @return 异常字符串
     */
    private String getValidException(MethodArgumentNotValidException ex) {
        Stream<String> stream = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> e.getField() + ":" + e.getDefaultMessage());
        return reduceException(stream);
    }

    /**
     * webflux 把校验异常转换为字符串
     * @param ex 具体异常
     * @return 异常字符串
     */
    private String getValidException(WebExchangeBindException ex) {
        Stream<String> stream = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> e.getField() + ":" + e.getDefaultMessage());
        return reduceException(stream);
    }

    /**
     * 转换异常消息字符串
     */
    private String reduceException(Stream<String> stream) {
        return stream.reduce("", (total, item) -> {
            if (StringUtils.isNotEmpty(total)) {
                total = total + "\n";
            }
            return total + item;
        });
    }

}
