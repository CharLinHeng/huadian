package com.xzsd.pc.util;

import java.io.Serializable;

/**
 * <p>系统统一返回格式</p>
 * <p>创建日期：2020-3-24</p>
 * @author zhc
 */
public class ResponceListData<T> implements Serializable {

    /**
     * 返回编码
     */
    private int code;


    /**
     * 消息描述
     */
    private String msg;

    /**
     * 页数
     */
    private int pageNum;
    /**
     * 数量
     */
    private int pageSize;
    /**
     * 总数量
     */
    private int total;
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

    public int getPageNum() {
        return pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotal() {
        return total;
    }

    public ResponceListData(int code, String msg, int pageSize, int pageNum, int total, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.total = total;
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
