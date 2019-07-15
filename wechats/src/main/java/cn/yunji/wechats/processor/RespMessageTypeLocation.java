package cn.yunji.wechats.processor;

import cn.yunji.wechats.commom.RespTypeMessage;
import cn.yunji.wechats.util.MessageUtil;

public class RespMessageTypeLocation {
	
	
	public static String respLocation(String fromUserName,String toUserName, String content) {
		return MessageUtil.textMessageToXml(RespTypeMessage.getTextMessage(fromUserName,toUserName,"您发送的是地理位置消息！"));
	}
}
