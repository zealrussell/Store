package com.zeal.store.util;

import java.io.Serializable;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/8 15:59
 */
public class JSONResult<E> implements Serializable {
    /** 状态码 **/
    private Integer state;
    /** 描述信息 **/
    private String message;
    /** 数据 **/
    private E data;

    public JSONResult() {
    }

    public JSONResult(Integer state) {
        this.state = state;
    }
    public JSONResult(Throwable e) {
        this.message = e.getMessage();
    }
    public JSONResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

}
