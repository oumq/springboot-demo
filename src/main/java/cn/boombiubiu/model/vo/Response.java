package cn.boombiubiu.model.vo;

import cn.boombiubiu.enums.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author oumq
 * @param <T>
 */
@Data
@Builder
@AllArgsConstructor
public class Response<T> {

    private int code;

    private String message;

    private T data;

    public Response(ResponseCode responseCodeEnum, T data) {
        this.code = responseCodeEnum.getCode();
        this.message = responseCodeEnum.getMessage();
        this.data = data;
    }

}
