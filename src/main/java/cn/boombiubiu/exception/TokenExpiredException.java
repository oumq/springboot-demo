package cn.boombiubiu.exception;

/**
 * @author oumq
 */
public class TokenExpiredException extends RuntimeException {

    public TokenExpiredException (String msg) {
        super(msg);
    }
}
