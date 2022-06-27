package com.soyokra.common.support.exception;

import com.soyokra.common.support.lib.StdResponse;
import com.soyokra.common.support.log.LogTagConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public StdResponse<Object> baseException(HttpServletRequest request, BaseException e) {
        log.error("[{}] ExceptionHandlers baseException, message: {}", LogTagConst.SYSTEM, e.getMessage(), e);
        return StdResponse.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = AuthException.class)
    @ResponseBody
    public StdResponse<Object> authException(HttpServletRequest request, AuthException e) {
        log.error("[{}] ExceptionHandlers authException, message: {}", LogTagConst.SYSTEM, e.getMessage(), e);
        return StdResponse.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public StdResponse<Object> exception(HttpServletRequest request, Exception e) {
        log.error("[{}] ExceptionHandlers exception, message: {}", LogTagConst.SYSTEM, e.getMessage(), e);
        ExceptionModel exceptionModel = ExceptionModel.SERVER;
        return StdResponse.error(exceptionModel.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public StdResponse<Object> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("[{}] ExceptionHandlers methodArgumentNotValidException, message: {}", LogTagConst.SYSTEM, e.getMessage(), e);
        ExceptionModel exceptionModel = ExceptionModel.CLIENT_VALIDATE;

        List<ObjectError> errorList = e.getBindingResult().getAllErrors();
        String message = "参数错误";
        for (ObjectError objectError: errorList) {
            message = objectError.getDefaultMessage();
            break;
        }
        return StdResponse.error(exceptionModel.getCode(), message);
    }
}
