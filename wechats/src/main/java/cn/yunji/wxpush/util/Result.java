package cn.yunji.wxpush.util;

public class Result {
	
	//"响应状态为
	private String statusLine;
	//"响应内容长度为:
	private Long contentLength;
	//"响应内容为:"
	private String content;
	
	public Result() {
	}
	
	public Result(String statusLine, Long contentLength, String  content) {
		super();
		this.statusLine = statusLine;
		this.contentLength = contentLength;
		this. content =  content;
	}

	public String getStatusLine() {
		return statusLine;
	}
	public void setStatusLine(String statusLine) {
		this.statusLine = statusLine;
	}
	public Long getContentLength() {
		return contentLength;
	}
	public void setContentLength(Long contentLength) {
		this.contentLength = contentLength;
	}
	public String getContent() {
		return  content;
	}
	public void setContent(String  content) {
		this.content =  content;
	}

	@Override
	public String toString() {
		return "Result [statusLine=" + statusLine + ", contentLength=" + contentLength + ", content=" + content + "]";
	}
	
	
}
