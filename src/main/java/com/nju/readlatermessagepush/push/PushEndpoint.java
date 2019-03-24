package com.nju.readlatermessagepush.push;

import com.nju.readlatermessagepush.push.data.PushRequest;
import com.nju.readlatermessagepush.push.data.ShareContent;
import com.nju.readlatermessagepush.push.data.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

/**
 * created by yanjunjie
 */
@RestController
public class PushEndpoint {
    @Inject
    private PushManagement pushManagement;

    @POST
    @RequestMapping(value = "sendMessagePush",method = RequestMethod.POST)
    public String changeReadStatus() {
//        pushManagement.pushMessage(user.getUserId());
        pushManagement.pushMessage("yanjunjie");
        return ReturnInfo.success;
    }
}

