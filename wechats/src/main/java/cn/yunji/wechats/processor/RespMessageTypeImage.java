package cn.yunji.wechats.processor;

import org.apache.commons.lang3.StringUtils;

import cn.yunji.wechats.commom.Const;
import cn.yunji.wechats.commom.MainMenu;
import cn.yunji.wechats.commom.RespTypeMessage;
import cn.yunji.wechats.service.FaceService;
import cn.yunji.wechats.util.MessageUtil;

public class RespMessageTypeImage {
	
	public static String respImage(String fromUserName,String toUserName,String picUrl) {
		// 取得图片地址
		String detectResult = FaceService.detect(picUrl);
		if(StringUtils.isNoneBlank(detectResult))// 人脸检测
			return  MessageUtil.textMessageToXml(RespTypeMessage.getTextMessage(fromUserName,toUserName,detectResult));
		else 
			return  MessageUtil.textMessageToXml(RespTypeMessage.getTextMessage(fromUserName,toUserName,MainMenu.getFaceUsage()));	

	}
	
}	

