package cn.yunji.wxpush.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 消息处理工具类
 * @author hy
 *
 */
public class MessageHandlerUtil {

	/**
	 * 将微信服务器发送过来的XML信息解析成map
	 * @param request 封装了请求信息的HttpServletRequest对象
	 * @return 解析结果
	 * @throws IOException
	 * @throws DocumentException
	 */
	@SuppressWarnings("unchecked")
	public static NewsItem paseXml(NewsItem item) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		
		InputStream inputStream = item.getRequest().getInputStream();
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();
		for(Element e : elementList) {
			map.put(e.getName(), e.getText());
		}
		System.out.println(map);
		inputStream.close();
		inputStream = null;
		//将解析到的所有消息赋值到item
		item.setFromUserName(map.get("FromUserName"));
		item.setToUserName(map.get("ToUserName"));
		item.setMediaId(map.get("MediaId"));
		item.setMsgType(map.get("MsgType"));
		item.setContent(map.get("Content"));
		item.setEventKey(map.get("EventKey"));
		return item;
	}
	
	/**
	 * 根据消息类型返回消息
	 * @param map
	 * @return
	 */
	public static String buildResponseMessage(NewsItem item) {
		// 响应消息
		String responseMessage = null;
		// 得到消息类型
		String msgType = item.getMsgType();
		// 消息类型
		MessageType messageType = MessageType.valueOf(MessageType.class,msgType.toUpperCase());
		switch (messageType) {
		case TEXT:
			responseMessage = HandleMessageUtil.handlerTextMessage(item);
			break;
		case  IMAGE:
			responseMessage = HandleMessageUtil.handlerImageMessage(item);
			break;
		case VOICE:
			responseMessage = HandleMessageUtil.buildVoiceMessage(item);
			break;
		case VIDEO:
			responseMessage = HandleMessageUtil.buildVideoMessage(item);
			break;
		case EVENT:
			responseMessage = HandleMessageUtil.buildEventMessage(item);
			break;
		default:
			break;
		}
		return  responseMessage;
	}
}
