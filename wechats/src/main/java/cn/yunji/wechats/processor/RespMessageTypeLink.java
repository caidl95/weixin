package cn.yunji.wechats.processor;

import cn.yunji.wechats.commom.RespTypeMessage;
import cn.yunji.wechats.util.MessageUtil;

public class RespMessageTypeLink {
	
	/**
	 * 无聊内容 
	 **/
	public static String getHTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<a href=\"https://weibo.com/p/1005052879892455/home?from=page_100505&mod=TAB&is_all=1#place\">栋良的微博</a>");
		return buffer.toString();
	}
	
	public static String respLink(String fromUserName,String toUserName,String HTML) {
		return  MessageUtil.textMessageToXml(RespTypeMessage.getTextMessage(fromUserName,toUserName,getHTML()));	
	}
	
	
}
