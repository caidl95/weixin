package cn.yunji.wechats.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import cn.yunji.wechats.processor.ProcessRequestUtil;
import cn.yunji.wechats.util.MessageUtil;

/**
 * 用来接收,处理用户通过微信客户端所发送的由微信服务器转发的信息
 */
@Service
public class WechatService {


	public String doPost(HttpServletRequest request) throws Exception {
		System.out.println("请求进入");
		//解析请求内容
		Map<String, String> requestMap = MessageUtil.parseXml(request);
		//响应
		return ProcessRequestUtil.processRequest(requestMap);
	}

	
}
