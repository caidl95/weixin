package cn.yunji.wxpush.util;

/**
 * 对不同类型的消息进行响应
 * @author Administrator
 *
 */
public class HandleMessageUtil {

	/**
	 * 响应接收到的文本信息
	 * @param map
	 * @return
	 */
	public static String handlerTextMessage(NewsItem item) {
		String responseMessage = null;
		String content = item.getContent();
		//发送方微信账号
		String fromUserName = item.getFromUserName();
		//开发者微信号
		String toUserName = item.getToUserName();
		
		if(content.matches(".*图.*")) {//判断字符串中是否含有图
			item.setTitle("测试图文");
			item.setDescription("这是一条用于 微信测试的图文消息");
			item.setPicUrl("http://upload-images.jianshu.io/upload_images/7855203-b9e9c9ded8a732a1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
			item.setUrl("https://blog.csdn.net/a1786223749/article/details/80787379?tdsourcetag=s_pcqq_aiomsg#3access_token_401");
			String itemContent = BuilMessageUtil.buildSingleItem(item);
			responseMessage = BuilMessageUtil.BuildNewsMessage(fromUserName, toUserName, 1, itemContent);
		}else if(content.matches(".*音.*")) {//判断字符串中是否含有音
			item.setTitle("小编推荐");
			item.setDescription("因为我不知道下一辈子还是否能遇见你");
			item.setHqMusicUrl("https://music.163.com/#/song?id=28111646");
			responseMessage = BuilMessageUtil.buildMusicMessage(fromUserName, toUserName, item);
		}else if(content.matches(".*在.*")) {
			item.setReplyText("您好！有什么可以帮到您？");
			responseMessage = BuilMessageUtil.buildTextMessage(fromUserName, toUserName,item.getReplyText());
		}else {
			item.setReplyText("然后呢?");
			responseMessage = BuilMessageUtil.buildTextMessage(fromUserName, toUserName,item.getReplyText());
		}
		return responseMessage;
	}

	/**
	 * 响应接收到的图片消息
	 * @param 
	 * @return
	 */
	public static String handlerImageMessage(NewsItem item) {
		String fromUserName = item.getFromUserName();
		String toUserName = item.getToUserName();
		/*返回指定的图片(该图片是上传为素材的,获得其media_id)*/
		/*返回用户发过来的图片*/
		String media_id = item.getMediaId();
		return String.format(
				"<xml>" +
						"<ToUserName><![CDATA[%s]]></ToUserName>" +
						"<FromUserName><![CDATA[%s]]></FromUserName>" +
						"<CreateTime>%s</CreateTime>" +
						"<MsgType><![CDATA[image]]></MsgType>" +
						"<Image>" +
						"   <MediaId><![CDATA[%s]]></MediaId>" +
						"</Image>" +
						"</xml>",
						fromUserName,toUserName, System.currentTimeMillis(),media_id
				);
	}

	/**
	 * 响应接收到的语音消息
	 * @param map
	 * @return
	 */
	public static String buildVoiceMessage(NewsItem item) {
		String fromUserName =item.getFromUserName();
		String toUserName = item.getToUserName();
		/*返回指定的语音(该语音是上传为素材的,获得其media_id)*/
		/*返回用户发过来的语音*/
		String media_id = item.getMediaId();
		return String.format(
				"<xml>" +
						"<ToUserName><![CDATA[%s]]></ToUserName>" +
						"<FromUserName><![CDATA[%s]]></FromUserName>" +
						"<CreateTime>%s</CreateTime>" +
						"<MsgType><![CDATA[voice]]></MsgType>" +
						"<Voice>" +
						"   <MediaId><![CDATA[%s]]></MediaId>" +
						"</Voice>" +
						"</xml>",
						fromUserName,toUserName, System.currentTimeMillis(),media_id
				);
	}

	public static String buildVideoMessage(NewsItem item) {
		String fromUserName = item.getFromUserName();
		String toUserName = item.getToUserName();
		String title = "客官发过来的视频哟~~";
		String description = "客官您呐,客官不可以, 嘻嘻?";
		/*返回用户发过来的视频*/
		String media_id = item.getMediaId();
		return String.format(
				"<xml>" +
						"<ToUserName><![CDATA[%s]]></ToUserName>" +
						"<FromUserName><![CDATA[%s]]></FromUserName>" +
						"<CreateTime>%s</CreateTime>" +
						"<MsgType><![CDATA[video]]></MsgType>" +
						"<Video>" +
						"   <MediaId><![CDATA[%s]]></MediaId>" +
						"   <Title><![CDATA[%s]]></Title>" +
						"   <Description><![CDATA[%s]]></Description>" +
						"</Video>" +
						"</xml>",
						fromUserName,toUserName, System.currentTimeMillis(),media_id,title,description
				);
	}
	public static String buildEventMessage(NewsItem item) {
		String eventKey= item.getEventKey();
		String responseMessage = null;
		String fromUserName = item.getFromUserName();
		String toUserName = item.getToUserName();
		if(eventKey.equals("V1001_GOOD")) {
			item.setReplyText("你真棒！");
			responseMessage = BuilMessageUtil.buildTextMessage(fromUserName, toUserName,item.getReplyText());
			
		}else if(eventKey.equals("V1001_TODAY_MUSIC")) {
			item.setTitle("今日歌曲");
			item.setDescription("今日首榜");
			item.setHqMusicUrl("https://music.163.com/#/song?id=1345848098");
			responseMessage = BuilMessageUtil.buildMusicMessage(fromUserName, toUserName, item);
		}
		return responseMessage;
				
	}
	
}
