package cn.yunji.wechats.processor;

import java.util.Map;
import cn.yunji.wxpush.util.MessageType;
/*
 * if (msgType.equals(Const.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息内容 String content =
 * requestMap.get("Content"); respMessage =
 * RespMessageTypeText.respText(fromUserName,toUserName,content); } // 图片消息 else
 * if (msgType.equals(Const.REQ_MESSAGE_TYPE_IMAGE)){ String picUrl =
 * requestMap.get("PicUrl"); respMessage =
 * RespMessageTypeImage.respImage(fromUserName, toUserName, picUrl); } // 地理位置消息
 * else if (msgType.equals(Const.REQ_MESSAGE_TYPE_LOCATION)){ respMessage =
 * RespMessageTypeLocation.respLocation(fromUserName, toUserName, null); } //
 * 链接消息 else if (msgType.equals(Const.REQ_MESSAGE_TYPE_LINK)) { respMessage =
 * RespMessageTypeLink.respLink(fromUserName, toUserName, null); } // 音频消息 else
 * if (msgType.equals(Const.REQ_MESSAGE_TYPE_VOICE)) { respMessage =
 * RespMessageTypeVoice.respLocation(fromUserName, toUserName, null); } // 事件推送
 * else if (msgType.equals(Const.REQ_MESSAGE_TYPE_EVENT)) { String eventType =
 * requestMap.get("Event"); respMessage =
 * RespMessageTypeEvent.respEvent(fromUserName,toUserName, eventType); }
 */
public class ProcessRequestUtil {

	/**
	 * 处理微信发来的请求
	 * * @param request
	 * @return
	 */
	public static String processRequest(Map<String, String> requestMap) {
		String respMessage = null;
		// 默认返回的文本消息内容
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		// 文本消息
		// 消息类型
		MessageType messageType = MessageType.valueOf(MessageType.class,msgType.toUpperCase());
		switch (messageType) {
		case TEXT:
			String content = requestMap.get("Content");
			respMessage = RespMessageTypeText.respText(fromUserName,toUserName,content);
			break;
		case IMAGE:
			String picUrl = requestMap.get("PicUrl");
			respMessage = RespMessageTypeImage.respImage(fromUserName, toUserName, picUrl);
			break;
		case VOICE:
			respMessage = RespMessageTypeVoice.respLocation(fromUserName, toUserName, null);
			break;
		case VIDEO:
			respMessage = RespMessageTypeVoice.respLocation(fromUserName, toUserName, null);
			break;
		case LINK:
			respMessage = RespMessageTypeLink.respLink(fromUserName, toUserName, null);
			break;
		case LOCATION:
			respMessage = RespMessageTypeLocation.respLocation(fromUserName, toUserName, null);
			break;
		case EVENT:
			String eventType = requestMap.get("Event");
			respMessage = RespMessageTypeEvent.respEvent(fromUserName,toUserName, eventType);	
			break;
		default:
			break;
		}
		return respMessage;
	}
}
