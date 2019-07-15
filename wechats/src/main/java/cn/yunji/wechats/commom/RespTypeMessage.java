package cn.yunji.wechats.commom;

import java.util.Date;

import cn.yunji.wechats.message.resp.Music;
import cn.yunji.wechats.message.resp.MusicMessage;
import cn.yunji.wechats.message.resp.TextMessage;

public class RespTypeMessage {
	
	public static TextMessage getTextMessage(String fromUserName,String toUserName,String content) {
		// 回复文本消息
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(Const.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);
		textMessage.setContent(content);
		return textMessage;
	}

	public static MusicMessage getMusicMessage(String fromUserName,String toUserName,Music music) {
		MusicMessage musicMessage = new MusicMessage();
		musicMessage.setToUserName(fromUserName);
		musicMessage.setFromUserName(toUserName);
		musicMessage.setCreateTime(new Date().getTime());
		musicMessage.setMsgType(Const.RESP_MESSAGE_TYPE_MUSIC);
		musicMessage.setMusic(music);
		return musicMessage;
	}
}
