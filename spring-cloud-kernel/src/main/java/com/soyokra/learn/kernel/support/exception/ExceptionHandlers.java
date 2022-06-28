package com.soyokra.learn.kernel.support.exception;

import com.soyokra.learn.kernel.support.utils.ResponseUtils;
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
    private static final String LOG_TAG = "system";
    
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public ResponseUtils<Object> baseException(HttpServletRequest request, BaseException e) {
        log.error("[{}] ExceptionHandlers baseException, message: {}", LOG_TAG, e.getMessage(), e);
        return ResponseUtils.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = AuthException.class)
    @ResponseBody
    public ResponseUtils<Object> authException(HttpServletRequest request, AuthException e) {
        log.error("[{}] ExceptionHandlers authException, message: {}", LOG_TAG, e.getMessage(), e);
        return ResponseUtils.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseUtils<Object> exception(HttpServletRequest request, Exception e) {
        log.error("[{}] ExceptionHandlers exception, message: {}", LOG_TAG, e.getMessage(), e);
        ExceptionModel exceptionModel = ExceptionModel.SERVER;
        return ResponseUtils.error(exceptionModel.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseUtils<Object> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("[{}] ExceptionHandlers methodArgumentNotValidException, message: {}", LOG_TAG, e.getMessage(), e);
        ExceptionModel exceptionModel = ExceptionModel.CLIENT_VALIDATE;

        List<ObjectError> errorList = e.getBindingResult().getAllErrors();
        String message = "参数错误";
        for (ObjectError objectError: errorList) {
            message = objectError.getDefaultMessage();
            break;
        }
        return ResponseUtils.error(exceptionModel.getCode(), message);
    }
}
