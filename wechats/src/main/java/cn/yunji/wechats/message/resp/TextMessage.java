package cn.yunji.wechats.message.resp;
/**
 * 文本消息
 * @author hy
 *
 */
public class TextMessage extends BaseMessage {
	
	// 回复的消息内�?
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
	
}
