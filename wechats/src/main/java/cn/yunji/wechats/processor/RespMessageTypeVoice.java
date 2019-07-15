package cn.yunji.wechats.processor;

import cn.yunji.wechats.commom.RespTypeMessage;
import cn.yunji.wechats.util.MessageUtil;

public class RespMessageTypeVoice {
	
	public static String respLocation(String fromUserName,String toUserName, String content) {
		return MessageUtil.textMessageToXml(RespTypeMessage.getTextMessage(fromUserName,toUserName,"您发送的是音频消息！"));
	}
}
