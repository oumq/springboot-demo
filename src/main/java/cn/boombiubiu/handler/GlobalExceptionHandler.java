package cn.boombiubiu.handler;

import cn.boombiubiu.enums.ResponseCode;
import cn.boombiubiu.exception.TokenExpiredException;
import cn.boombiubiu.exception.TokenInvalidException;
import cn.boombiubiu.exception.TokenNotFoundException;
import cn.boombiubiu.model.vo.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author oumq
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @ResponseBody
    @SuppressWarnings ("unchecked")
    @ResponseStatus (HttpStatus.OK)
    @ExceptionHandler (TokenNotFoundException.class)
    public Response handleTokenNotFoundException (TokenNotFoundException e) {
        logger.error("缺少token", e);
        return new Response(ResponseCode.TOKEN_NOT_FOUND, e.getMessage());
    }


    @ResponseBody
    @SuppressWarnings ("unchecked")
    @ResponseStatus (HttpStatus.OK)
    @ExceptionHandler (TokenInvalidException.class)
    public Response handleTokenInvalidException (TokenInvalidException e) {
        logger.error("token验证不通过", e);
        return new Response(ResponseCode.TOKEN_INVALID, e.getMessage());
    }

    @ResponseBody
    @SuppressWarnings ("unchecked")
    @ResponseStatus (HttpStatus.OK)
    @ExceptionHandler (TokenExpiredException.class)
    public Response handleTokenExpiredException (TokenExpiredException e) {
        logger.error("token失效", e);
        return new Response(ResponseCode.TOKEN_EXPIRED, e.getMessage());
    }

    @ResponseBody
    @SuppressWarnings ("unchecked")
    @ResponseStatus (HttpStatus.OK)
    @ExceptionHandler (MissingServletRequestParameterException.class)
    public Response handleMissingServletRequestParameterException (MissingServletRequestParameterException e) {
        logger.error("缺少请求参数", e);
        return new Response(ResponseCode.PARAMETER_NOTFOUND, "缺少请求参数: " + e.getParameterName());
    }


    @ResponseBody
    @SuppressWarnings ("unchecked")
    @ResponseStatus (HttpStatus.OK)
    @ExceptionHandler (MethodArgumentNotValidException.class)
    public Response handleMethodArgumentNotValidException (MethodArgumentNotValidException e) {
        logger.error("参数验证不通过", e);
        FieldError error = e.getBindingResult().getFieldError();
        return new Response(ResponseCode.PARAMETER_INVALID, error.getDefaultMessage());
    }

    @ResponseBody
    @SuppressWarnings ("unchecked")
    @ResponseStatus (HttpStatus.OK)
    @ExceptionHandler (HttpMediaTypeNotSupportedException.class)
    public Response handleHttpMediaTypeNotSupportedException (HttpMediaTypeNotSupportedException e) {
        logger.error("媒体类型不支持", e);
        return new Response(ResponseCode.MEDIATYPE_NOTSUPPORTED, "媒体类型: " + e.getContentType() + " 不支持");
    }

    @ResponseBody
    @SuppressWarnings ("unchecked")
    @ResponseStatus (HttpStatus.OK)
    @ExceptionHandler (HttpRequestMethodNotSupportedException.class)
    public Response handleHttpRequestMethodNotSupportedException (HttpRequestMethodNotSupportedException e) {
        logger.error("请求方法不支持", e);
        return new Response(ResponseCode.METHOD_NOT_ALLOWED, "请求方法: " + e.getMethod() + " 不支持");
    }

    @ResponseBody
    @SuppressWarnings ("unchecked")
    @ResponseStatus (HttpStatus.OK)
    @ExceptionHandler (NoHandlerFoundException.class)
    public Response handleNoHandlerFoundException (NoHandlerFoundException e) {
        logger.error("请求路径不存在", e);
        return new Response(ResponseCode.NOT_FOUND, "路径: " + e.getRequestURL() + " 不存在");
    }
}
