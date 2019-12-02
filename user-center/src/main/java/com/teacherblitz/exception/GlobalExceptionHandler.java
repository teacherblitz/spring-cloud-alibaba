package com.teacherblitz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author teacherblitz
 * @since 2019/11/30
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> globalError(Exception e){
        if(e instanceof CustomException){
            return new ResponseEntity<String>(
                    "Token验证失败",
                    HttpStatus.UNAUTHORIZED
            );
        }
        return new ResponseEntity<String>(
                "网关超时",
                HttpStatus.GATEWAY_TIMEOUT
        );
    }
}
