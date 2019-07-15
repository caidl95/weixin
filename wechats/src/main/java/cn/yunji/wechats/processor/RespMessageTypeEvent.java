package cn.yunji.wechats.processor;

import cn.yunji.wechats.commom.Const;
import cn.yunji.wechats.commom.RespTypeMessage;
import cn.yunji.wechats.util.MessageUtil;
import cn.yunji.wxpush.util.BuilMessageUtil;

public class RespMessageTypeEvent {
	
	public static String respEvent(String fromUserName,String toUserName,String eventType) {
		String content="";
		// 订阅
		if (eventType.equals(Const.EVENT_TYPE_SUBSCRIBE)) {
			content = "谢谢您的关注！";
			return MessageUtil.textMessageToXml(RespTypeMessage.getTextMessage(fromUserName, toUserName, content));
		}
		// 取消订阅
		else if (eventType.equals(Const.EVENT_TYPE_UNSUBSCRIBE)) {
			// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需消息
		}
		// 自定义菜单点击事件
		else if (eventType.equals(Const.EVENT_TYPE_CLICK)) {
			// TODO 自定义菜单权没有开放，暂不处理该类消息
		}
		
		return MessageUtil.textMessageToXml(RespTypeMessage.getTextMessage(fromUserName, toUserName, content));
	}
}
