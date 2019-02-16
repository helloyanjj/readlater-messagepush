package com.nju.readlatermessagepush.push;

import com.nju.readlatermessagepush.push.data.PushRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.ws.rs.POST;

/**
 * created by yanjunjie
 */

public class PushEndpoint {
    @Inject
    private PushManagement pushManagement;

    @POST
    @RequestMapping("changeReadStatus")
    public String changeReadStatus(@RequestBody PushRequest request) {
        pushManagement.pushMessage(request);
        return ReturnInfo.success;
    }
}

