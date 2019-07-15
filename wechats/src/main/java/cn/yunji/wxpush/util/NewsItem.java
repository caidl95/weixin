package cn.yunji.wxpush.util;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 回复图文消息实体.
 * @author Administrator
 *
 */
@XmlRootElement(name = "xml")
public class NewsItem implements Serializable{

	private static final long serialVersionUID = 6866923593261106234L;
	
	private HttpServletRequest request;

	//开头
	private String Title;

	//描述
	private String Description;

	private String PicUrl;

	private String Url;
	
	//默认回复语句
	private String ReplyText;
	
	//音乐网址
	private String HqMusicUrl;
	
	//开发者微信号
	private String ToUserName;
	
	//发送方账号
	private String FromUserName;
	
	//消息类型
	private String MsgType;
	
	//消息内容
	private String Content;
	
	//上传资料id
	private String MediaId;
	
	//CLICK事件的key值
	private String EventKey;
	
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getReplyText() {
		return ReplyText;
	}

	public void setReplyText(String replyText) {
		ReplyText = replyText;
	}

	public String getHqMusicUrl() {
		return HqMusicUrl;
	}

	public void setHqMusicUrl(String hqMusicUrl) {
		HqMusicUrl = hqMusicUrl;
	}

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	@Override
	public String toString() {
		return "NewsItem [request=" + request + ", Title=" + Title + ", Description=" + Description + ", PicUrl="
				+ PicUrl + ", Url=" + Url + ", ReplyText=" + ReplyText + ", HqMusicUrl=" + HqMusicUrl + ", ToUserName="
				+ ToUserName + ", FromUserName=" + FromUserName + ", MsgType=" + MsgType + ", Content=" + Content
				+ ", MediaId=" + MediaId + "]";
	}
	

	
	

}
