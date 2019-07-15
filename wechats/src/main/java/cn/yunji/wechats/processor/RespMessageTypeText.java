package cn.yunji.wechats.processor;

import org.apache.commons.lang3.StringUtils;

import cn.yunji.wechats.commom.MainMenu;
import cn.yunji.wechats.commom.RespTypeMessage;
import cn.yunji.wechats.message.resp.Music;
import cn.yunji.wechats.message.resp.TextMessage;
import cn.yunji.wechats.service.BaiduMusicService;
import cn.yunji.wechats.service.TodayInHistoryService;
import cn.yunji.wechats.util.MessageUtil;
import cn.yunji.wechats.util.TextUtil;

/**
 * 文本消息处理
 * @author hy
 *
 */
public class RespMessageTypeText {

	private static boolean isSeek = false;

	public static String respText(String fromUserName,String toUserName, String content) {
		if(StringUtils.isBlank(content)) 
			return MessageUtil.textMessageToXml(RespTypeMessage.getTextMessage(fromUserName,toUserName,"请求处理异常，请稍候尝试！"));

		// 判断用户发送的是否是单个 QQ 表情
		else if(TextUtil.isQqFace(content)) {
			// 用户发什么 QQ 表情，就返回什么 QQ 表情
			TextMessage textMessage = RespTypeMessage.getTextMessage(fromUserName,toUserName,content);
			// 将文本消息对象转换成 xml 字符串
			return MessageUtil.textMessageToXml(textMessage);
		}
		// 判断用户发送的是否含有问号
		else if(TextUtil.isVarChar(content,"?")) {
			content = MainMenu.getMainMenu();
			return MessageUtil.textMessageToXml(RespTypeMessage.getTextMessage(fromUserName,toUserName,content));
		}
		else if(TextUtil.isVarChar(content,"历史上的今天")) {
			content = TodayInHistoryService.getTodayInHistoryInfo();
			return MessageUtil.textMessageToXml(RespTypeMessage.getTextMessage(fromUserName,toUserName,content));
		}
		else if(TextUtil.isVarChar(content,"音乐")) {//判断字符串中是否含有音
			Music music = new Music();
			music.setTitle("小编推荐");
			music.setDescription("因为我不知道下一辈子还是否能遇见你");
			music.setMusicUrl("https://music.163.com/#/song?id=28111646");
			return MessageUtil.musicMessageToXml(RespTypeMessage.getMusicMessage(fromUserName,toUserName,music));
		}
		// 如果以“歌曲”2 个字开头
		else if (content.startsWith("歌曲")) {// 将歌曲 2 个字及歌曲后面的+、空格、-等特殊符号去掉
			String keyWord = content.replaceAll("^歌曲[\\+ ~!@#%^-_=]?", "");
			if ("".equals(keyWord)) // 如果歌曲名称为空
				isSeek = true;
			else {
				String[] kwArr = keyWord.split("@");
				String musicTitle = kwArr[0];	// 歌曲名称
				String musicAuthor = "";// 演唱者默认为空
				if (2 == kwArr.length)
					musicAuthor = kwArr[1];
				// 搜索音乐
				Music music = BaiduMusicService.searchMusic(musicTitle, musicAuthor);
				if (null == music) // 未搜索到音乐
					isSeek = true;
				else // 音乐消息
					return MessageUtil.musicMessageToXml(RespTypeMessage.getMusicMessage(fromUserName,toUserName,music));
			}
			// 未搜索到音乐时返回使用指南
			if (isSeek) {
				content = "对不起，没有找到你想听的歌曲。\\n\\n" + MainMenu.getMusicUsage();
				return MessageUtil.textMessageToXml(RespTypeMessage.getTextMessage(fromUserName,toUserName,content));
			}
		}
		else if (content.startsWith("翻译")) { 
			String keyWord = content.replaceAll("^翻译", "").trim(); 
			if ("".equals(keyWord)) {
				
			} else {
				
			}
		}
	

	return MessageUtil.textMessageToXml(RespTypeMessage.getTextMessage(fromUserName,toUserName,content));
}

}