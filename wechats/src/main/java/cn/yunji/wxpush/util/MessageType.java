package cn.yunji.wxpush.util;

/**
 * @author xiaowf
 * @description 微信公众号消息类型
 */
public enum MessageType {
	
	/**
	 * 文本消息
	 */
	TEXT,
	
	/**
	 * 图片消息
	 */
	IMAGE,
	
	/**
	 * 视频消息
	 */
	VIDEO,
	
	/**
	 * 语音消息
	 */
	VOICE,
	
	/**
	 * 小视频消息
	 */
	SHORTVIDEO,
	
	/**
	 * 地理位置消息
	 */
    LOCATION,
    
    /**
     * 链接消息
     */
    LINK,
    
    /**
     * 事件消息
     */
    EVENT,
    
}
