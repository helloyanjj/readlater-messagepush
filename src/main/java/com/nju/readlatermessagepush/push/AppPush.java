package com.nju.readlatermessagepush.push;

/**
 * created by yanjunjie
 */

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.nju.readlatermessagepush.push.data.Patterns;
import com.nju.readlatermessagepush.push.data.ShareContent;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;


@Component
public class AppPush {
    @Inject
    private PushManagement pushManagement;

    //定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
    private static String appId = "MdrWiZrbQF8tBP0APimz53";
    private static String appKey = "Ghc3wX9giW9Zv5dvjEVs74";
    private static String masterSecret = "XiAduXb78P6ozlQROPo2e1";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    public void push() {
//        ShareContent shareContent = pushManagement.getContent("yanjunjie");
        try {
            IGtPush push = new IGtPush(url, appKey, masterSecret);

            // 定义"点击链接打开通知模板"，并设置标题、内容、链接
            LinkTemplate template = new LinkTemplate();
            template.setAppId(appId);
            template.setAppkey(appKey);
            template.setTitle("您有未读完内容");
            template.setText("既然武术套路不能用于实战，那么武术套路的存在意义是什么？ - 可以直接打我的回答 - 知乎\n" +
                    "https://www.zhihu.com/question/305173373/answer/555789791");
//            template.setUrl("www.baidu.com");
//            template.setText(shareContent.getContent());

            Matcher matcher = Patterns.WEB_URL.matcher("既然武术套路不能用于实战，那么武术套路的存在意义是什么？ - 可以直接打我的回答 - 知乎\n" +
                    "https://www.zhihu.com/question/305173373/answer/555789791");
            if (matcher.find()) {
                System.out.println(matcher.group());
                String linkUrl = matcher.group();
                template.setUrl(linkUrl);
            }



            List<String> appIds = new ArrayList<String>();
            appIds.add(appId);

            // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
            AppMessage message = new AppMessage();
            message.setData(template);
            message.setAppIdList(appIds);
            message.setOffline(true);
            message.setOfflineExpireTime(1000 * 600);

            IPushResult ret = push.pushMessageToApp(message);
            System.out.println(ret.getResponse().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



