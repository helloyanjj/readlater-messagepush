package com.nju.readlatermessagepush.push;

import com.nju.readlatermessagepush.push.data.PushRequest;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * created by yanjunjie
 */

@Component
public class PushManagement {
    @Inject
    private AppPush appPush;
    public String pushMessage(PushRequest request) {
        appPush.push();
        return ReturnInfo.success;
    }
}

