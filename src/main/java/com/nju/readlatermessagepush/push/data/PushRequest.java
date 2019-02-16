package com.nju.readlatermessagepush.push.data;

/**
 * created by yanjunjie
 */

public class PushRequest {
    private long userId;
    private String time;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

