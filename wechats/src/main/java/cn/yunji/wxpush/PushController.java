package cn.yunji.wxpush;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

@Controller
public class PushController {
	 /*
     * 微信测试账号推送
     * */
    @GetMapping("/push")
    public void push(String encodingAESKey,String token,String content,String msgId) {
    	System.out.println(token+"   "+encodingAESKey+"  "+content+"  "+msgId );
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId("wx77bb69292323a000");//
        wxStorage.setSecret("29bd368145806115ad6820133e62806e");//
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);

        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("o5kho6DgC7SDry8zCmXuvHJGvrgI")//要推送的用户openid
                .templateId("Tpln-Eue2obJ0B-8JNkgkiRJaDMPgVeIgGxna982xrg")//模版id
                .url("https://30paotui.com/")//点击模版消息要访问的网址
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        //        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        //                templateMessage.addData(new WxMpTemplateData(name2, value2, color2));
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }

    }



}
