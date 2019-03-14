package com.nju.readlatermessagepush.push;

import com.nju.readlatermessagepush.push.data.PushRequest;
import com.nju.readlatermessagepush.push.data.ShareContent;
import com.nju.readlatermessagepush.push.dto.ContentRespository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * created by yanjunjie
 */

@Component
public class PushManagement {
    @Inject
    private AppPush appPush;

    @Inject
    private ContentRespository contentRespository;

    public String pushMessage() {
        appPush.push();
        return ReturnInfo.success;
    }

//    public ShareContent getContent(String userId) {
//        return contentRespository.findShareContentByUserIdAndId(userId,"false");
//    }


}

