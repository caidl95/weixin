package cn.yunji.wechats.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.yunji.wechats.entity.Sign;
import cn.yunji.wechats.main.MenuManager;
import cn.yunji.wechats.service.WechatService;
import cn.yunji.wechats.util.SignUtil;

@RestController
@RequestMapping("/wechats")
public class WchatController {

	@Autowired
	private WechatService wechatService;
	
	/**
	 * 接收和回复消息
	 * @throws Exception 
	 */
	@PostMapping("/wechatSigna")
	public String doPost(HttpServletRequest request) throws Exception {
		return wechatService.doPost(request);
	}
	
	/**
	 * 校验签名
	 */
	@GetMapping("/wechatSigna")
	public String doGet(Sign sign)  {
		if (SignUtil.checkSignature(sign.getSignature(), sign.getTimestamp(), sign.getNonce())) {
			MenuManager.main();
			return sign.getEchostr();
		}
		return null;
	}
	
}
