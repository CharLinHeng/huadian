package com.xzsd.app.util;

import java.io.Serializable;

/**
 * <p>系统统一返回格式</p>
 * <p>创建日期：2020-3-24</p>
 * @author zhc
 */
public class ResponceData<T> implements Serializable {

    /**
     * 返回编码
     */
    private int code;


    /**
     * 消息描述
     */
    private String msg;

    /**
     * 返回内容
     */
    private T data;


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public ResponceData(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static <T> AppResponseBuilder builder() {
        return new AppResponseBuilder<T>();
    }

    /**
     *
     * @return
     */
    public static ResponceData success() {
        return builder().code(ResponceDataState.SUCCESS).build();
    }

    public static class AppResponseBuilder<T> {

        private int code;

        private String msg;
        private T data;


        public ResponceData build() {
            ResponceData appResponse = new ResponceData<>(this.code, this.msg, this.data);
            return appResponse;
        }

        public AppResponseBuilder code(ResponceDataState status) {
            this.code = status.code;
            return this;
        }

        public AppResponseBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public AppResponseBuilder data(T data) {
            this.data = data;
            return this;
        }
    }

}
