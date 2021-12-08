package com.association.common.config.cache;

/**
 * RedisException
 * @author zhangfang
 * @date 2017年9月15日 下午2:05:30
 */
public class RedisException extends RuntimeException {

    public RedisException() {
    }

    public RedisException(Throwable cause) {
        super(cause);
    }

    public RedisException(String message) {
        super(message);
    }

    public RedisException(String message, Throwable cause) {
        super(message, cause);
    }
}
