package cn.yunji.wxpush.util;

import java.util.Map;

/**
 * 构造响应消息
 * @author Administrator
 *
 */
public class BuilMessageUtil {

	/**
	 * 默认text消息回复
	 * @param map
	 * @param replyText
	 * @return
	 */
	public static String buildTextMessage(String fromUserName, String toUserName,String replyText) {
		
		return String.format("<xml>" +
                "<ToUserName><![CDATA[%s]]></ToUserName>" +
                "<FromUserName><![CDATA[%s]]></FromUserName>" +
                "<CreateTime>%s</CreateTime>" +
                "<MsgType><![CDATA[text]]></MsgType>" +
                "<Content><![CDATA[%s]]></Content>" + "</xml>", 
                fromUserName, toUserName, System.currentTimeMillis(), replyText);
	}
	
	/**
	 * 根据用户输入的音乐text返回一首歌
	 * @param fromUserName
	 * @param toUserName
	 * @param item
	 * @return
	 */
	public static String buildMusicMessage(String fromUserName, String toUserName,NewsItem item) {
		return String.format(
                "<xml>" +
                "<ToUserName><![CDATA[%s]]></ToUserName>" +
                "<FromUserName><![CDATA[%s]]></FromUserName>" +
                "<CreateTime>%s</CreateTime>" +
                "<MsgType><![CDATA[music]]></MsgType>" +
                "<Music>" +
                "   <Title><![CDATA[%s]]></Title>" +
                "   <Description><![CDATA[%s]]></Description>" +
                "   <MusicUrl>< ![CDATA[%s] ]></MusicUrl>" +  //非必须项 音乐链接
                "   <HQMusicUrl><![CDATA[%s]]></HQMusicUrl>"+ //非必须项 高质量音乐链接，WIFI环境优先使用该链接播放音乐
                "</Music>" +
                "</xml>",
                fromUserName,toUserName, System.currentTimeMillis(), item.getTitle(), item.getDescription(),
                item.getHqMusicUrl(),item.getHqMusicUrl()
        );
	}

	/**
	 * 生成一条文章消息
	 * @param item 图文记录对象
	 * @return
	 */
	public static String buildSingleItem(NewsItem item) {
		String itemContent = String.format(
				"<item>\n" + "<Title><![CDATA[%s]]></Title> \n" + "<Description><![CDATA[%s]]></Description>\n"
				+ "<PicUrl><![CDATA[%s]]></PicUrl>\n" + "<Url><![CDATA[%s]]></Url>\n" + "</item>",
				item.getTitle(), item.getDescription(), item.getPicUrl(), item.getUrl());
		return itemContent;
	}
	
	/**
	 * 构造图文消息
	 * @param map 封装了解析结果的map
	 * @param ArticleCount 文章总数
	 * @param itemContent 文章列表拼接的XML字符串
	 * @return String 图文消息的XML字符串
	 */
	public static String BuildNewsMessage(String fromUserName, String toUserName,int ArticleCount,String itemContent) {

		String content = String.format(
				"<xml>\n" + "<ToUserName><![CDATA[%s]]></ToUserName>\n"
						+ "<FromUserName><![CDATA[%s]]></FromUserName>\n" + "<CreateTime>%s</CreateTime>\n"
						+ "<MsgType><![CDATA[news]]></MsgType>\n" + "<ArticleCount>%s</ArticleCount>\n" + "<Articles>\n"
						+ "%s" + "</Articles>\n" + "</xml> ",
				fromUserName, toUserName, System.currentTimeMillis(), ArticleCount, itemContent);
		return content;
	}
}
