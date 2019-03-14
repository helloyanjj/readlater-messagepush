package com.nju.readlatermessagepush.push;

import com.nju.readlatermessagepush.push.data.PushRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.POST;

/**
 * created by yanjunjie
 */
@RestController
public class PushEndpoint {
    @Inject
    private PushManagement pushManagement;

    @POST
    @RequestMapping("sendMessagePush")
    public String changeReadStatus() {
        pushManagement.pushMessage();
        return ReturnInfo.success;
    }
}

