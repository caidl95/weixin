package cn.yunji.wechats.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;import java.util.Collections;
import java.util.List;
import cn.yunji.wechats.pojo.Face;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 人脸检测服务
 */
public class FaceService {
	/**
	 * 发送 http 请求
	 * * @param requestUrl 请求地址
	 * @return String
	 */
	private static String httpRequest(String requestUrl) {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection urlCon= (HttpURLConnection)url.openConnection(); 
			urlCon.setRequestMethod("POST");// 提交模式
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
			urlCon.setDoOutput(true);
			urlCon.setDoInput(true);
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

		} catch(IOException e){
			e.printStackTrace();
		}

		return buffer.toString();
	}
	/**
	 * 调用 Face++ API 实现人脸检测
	 * * @param picUrl 待检测图片的访问地址
	 * @return List<Face> 人脸列表
	 */
	private static List<Face> faceDetect(String picUrl) {
		List<Face> faceList = new ArrayList<Face>();
		try {
			// 拼接 Face++人脸检测的请求地址https://api-cn.faceplusplus.com/facepp/v3/detect" -F "api_key=<api_key>" \
			String queryUrl = "https://api-cn.faceplusplus.com/facepp/v3/detect?image_url=URL&api_secret=API_SECRET&api_key=API_KEY";
			// 对 URL 进行编码
			queryUrl = queryUrl.replace("URL", java.net.URLEncoder.encode(picUrl, "UTF-8"));
			queryUrl = queryUrl.replace("API_KEY", "Zu4632dpBLbb94mkNB63iypl_AsNcn3S");
			queryUrl = queryUrl.replace("API_SECRET", "JSLP66E4H6Xtt8pQTLLOxHJ4rbirSryr");
			// 调用人脸检测接口
			String json = httpRequest(queryUrl);
			// 解析返回 json 中的 Face 列表
			JSONArray jsonArray = JSONObject.fromObject(json).getJSONArray("faces");
			// 遍历检测到的人脸
			for (int i = 0; i < jsonArray.size(); i++) {
				// face
				JSONObject faceObject = (JSONObject) jsonArray.get(i);
				// attributes
				JSONObject attrObject = faceObject.getJSONObject("attributes");
				// position
				JSONObject rectangleObject = faceObject.getJSONObject("face_rectangle");
				Face face = new Face();
				face.setGender(genderConvert(attrObject.getJSONObject("gender").getString("value")));
				face.setAge(attrObject.getJSONObject("age").getInt("value"));
				face.setSmile(attrObject.getJSONObject("smile").getString("value"));
				face.setSmile(raceConvert(attrObject.getJSONObject("ethnicity").getString("value")));
				faceList.add(face);
			}
			// 将检测出的 Face 按从左至右的顺序排序
			Collections.sort(faceList);
		} catch (Exception e) {
			faceList = null;
			e.printStackTrace();
		}
		return faceList;
	}

	/**
	 * 性别转换（英文->中文）
	 * . * @param gender
	 * @return
	 */
	private static String genderConvert(String gender) {
		String result = "男性";
		if ("Male".equals(gender))
			result = "男性";
		else if ("Female".equals(gender))
			result = "女性";

		return result;
	}
	/**
	 * 人种转换（英文->中文）
	 * . * @param race
	 * @return
	 */
	private static String raceConvert(String race) {
		String result = "黄色";
		if ("Asian".equals(race))
			result = "黄色";
		else if ("White".equals(race))
			result = "白色";
		else if ("Black".equals(race))
			result = "黑色";
		return result;
	}

	/**
	 * 根据人脸识别结果组装消息
	 * @param faceList 人脸列表
	 */
	private static String makeMessage(List<Face> faceList) {
		StringBuffer buffer = new StringBuffer();
		// 检测到 1 张脸
		if (1 == faceList.size()) {
			buffer.append("共检测到 ").append(faceList.size()).append(" 张人脸").append("\n");
			for (Face face : faceList) {
				buffer.append(face.getEthnicity()).append("人种,");
				buffer.append(face.getGender()).append(",");
				buffer.append(face.getAge()).append("岁左右").append("\n");
			}
		}
		// 检测到 2-10 张脸
		else if (faceList.size() > 1 && faceList.size() <= 10) {
			buffer.append("共检测到 ").append(faceList.size()).append(" 张人脸，按脸部中心位置从左至右依次为：").append("\n");
			for (Face face : faceList) {
				buffer.append(face.getEthnicity()).append("人种,");
				buffer.append(face.getGender()).append(",");
				buffer.append(face.getAge()).append("岁左右").append("\n");
			}
		}
		// 检测到 10 张脸以上
		else if (faceList.size() > 10) {
			buffer.append("共检测到 ").append(faceList.size()).append(" 张人脸").append("\n");
			// 统计各人种、性别的人数
			int asiaMale = 0;
			int asiaFemale = 0;
			int whiteMale = 0;
			int whiteFemale = 0;
			int blackMale = 0;
			int blackFemale = 0;
			for (Face face : faceList) {
				if ("黄色".equals(face.getEthnicity()))
					if ("男性".equals(face.getGender()))
						asiaMale++;
					else
						asiaFemale++;
				else if ("白色".equals(face.getEthnicity()))
					if ("男性".equals(face.getGender()))
						whiteMale++;
					else
						whiteFemale++;
				else if ("黑色".equals(face.getEthnicity()))
					if ("男性".equals(face.getGender()))
						blackMale++;
					else
						blackFemale++;
			}
			if (0 != asiaMale || 0 != asiaFemale)
				buffer.append("黄色人种：").append(asiaMale).append("男").append(asiaFemale).append("女").append("\n");
			if (0 != whiteMale || 0 != whiteFemale)
				buffer.append("白色人种：").append(whiteMale).append("男").append(whiteFemale).append("女").append("\n");
			if (0 != blackMale || 0 != blackFemale)
				buffer.append("黑色人种：").append(blackMale).append("男").append(blackFemale).append("女").append("\n");
		}
		// 移除末尾空格
		buffer = new StringBuffer(buffer.substring(0, buffer.lastIndexOf("\n")));
		return buffer.toString();
	}


	/**
	 * 提供给外部调用的人脸检测方法
	 * * @param picUrl 待检测图片的访问地址
	 * @return String
	 */
	public static String detect(String picUrl) {
		// 默认回复信息
		String result = "未识别到人脸，请换一张清晰的照片再试！";
		List<Face> faceList = faceDetect(picUrl);
		if (null != faceList) {
			result = makeMessage(faceList);
		}
		return result;
	}
	public static void main(String[] args) {
		String picUrl = "http://pic11.nipic.com/20101111/6153002_002722872554_2.jpg";
		System.out.println(detect(picUrl));
	}

}