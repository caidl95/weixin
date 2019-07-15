package cn.yunji.wechats.util;



import org.springframework.util.DigestUtils;

/**
 * 
 */
public class MD5Util {
	
	private static String my ="9VoLP9oidO0Mj4TenMcd";
	
	private static String appid ="20190713000317546";
	
	private  static String salt ="1435660288";
	/**
	 * 获取执行MD5加密后的密码
	 * appid+q+salt+密钥 的MD5值
	 */
	public static String getMd5(String q) {
		String result = appid+q+salt+my;
		result = DigestUtils.md5DigestAsHex(result.getBytes()).toUpperCase();
		return result;
	}

  
}
