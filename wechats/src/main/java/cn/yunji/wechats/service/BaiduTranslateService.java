package cn.yunji.wechats.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cn.yunji.wechats.pojo.TranslateResult;
import cn.yunji.wechats.util.MD5Util;
/**
 * 
 **/

public class BaiduTranslateService {
	/**
	 * 发起 http 请求获取返回结果
	 * * @param requestUrl 请求地址
	 * @return
	 */
	public static TranslateResult httpRequest(String requestUrl) {
		String res="";
		TranslateResult translateResult = null;
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection urlCon= (HttpURLConnection)url.openConnection(); 
			if(200==urlCon.getResponseCode()){
				InputStream is = urlCon.getInputStream();
				InputStreamReader isr = new InputStreamReader(is,"utf-8");
				BufferedReader br = new BufferedReader(isr);

				String str = null;
				while((str = br.readLine())!=null){
					buffer.append(str);
				}
				br.close();
				isr.close();
				is.close();
				res = buffer.toString();
				translateResult= new Gson().fromJson(res, TranslateResult.class);
			
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		return translateResult;
	}/**
	 * utf 编码
	 * * @param source
	 * @return
	 */
	public static String urlEncodeUTF8(String source) {
		String result = source;
		try {
			result = java.net.URLEncoder.encode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 翻译（中->英 英->中 日->中 ）
	 * * @param source
	 * appid+q+salt+密钥 的MD5值
	 * 9VoLP9oidO0Mj4TenMcd
	 */
	public static String translate(String source) {
		String dst = null;
		// 组装查询地址
		String requestUrl = "http://api.fanyi.baidu.com/api/trans/vip/translate?q={keyWord}&from=auto&to=auto&appid=20190713000317546&salt=1435660288&sign={MD5}";
		// 对参数 q 的值进行 urlEncode utf-8 编码
		requestUrl = requestUrl.replace("{keyWord}", urlEncodeUTF8(source));
		//TODO
		String my = MD5Util.getMd5(urlEncodeUTF8(source));
		requestUrl = requestUrl.replace("{MD5}",my);
		// 查询并解析结果
		try {
			// 查询并获取返回结果
			TranslateResult translateResult =  httpRequest(requestUrl);
			// 取出 translateResult 中的译文
			System.err.println(translateResult);
		} catch (Exception e) {
			e.printStackTrace();}
		if (null == dst)
			dst = "翻译系统异常，请稍候尝试！";
		return dst;
	}
	public static void main(String[] args) {
		// 翻译结果：The network really powerful
		System.out.println(translate("网络真强大")); 

	}
}