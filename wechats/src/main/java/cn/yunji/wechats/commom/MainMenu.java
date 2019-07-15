package cn.yunji.wechats.commom;

public class MainMenu {
	/**
	 * xiaoqrobot 的主菜单
	 * * @return
	 */
	public static String getMainMenu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("您好，我是小 q，请回复数字选择服务：").append("\n\n");
		buffer.append("1 天气预报").append("\n");
		buffer.append("2 公交查询").append("\n");
		buffer.append("3 周边搜索").append("\n");
		buffer.append("4 歌曲点播").append("\n");
		buffer.append("5 经典游戏").append("\n");
		buffer.append("6 美女电台").append("\n");
		buffer.append("7 人脸识别").append("\n");
		buffer.append("8 聊天唠嗑").append("\n\n");
		buffer.append("回复“?”显示此帮助菜单");
		return buffer.toString();
	}
	
	/**
	 * 人脸检测帮助菜单
	 */
	public static String getFaceUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("人脸检测使用指南").append("\n\n");
		buffer.append("发送一张清晰的照片，就能帮你分析出种族、年龄、性别等信息").append("\n");
		buffer.append("快来试试你是不是长得太着急");
		return buffer.toString();
	}
	
	/**
	 * 歌曲点播使用指南
	 * * @return
	 */
	public static String getMusicUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("歌曲点播操作指南").append("\n\n");
		buffer.append("回复：歌曲+歌名").append("\n");
		buffer.append("例如：歌曲存在").append("\n");
		buffer.append("或者：歌曲存在@汪峰").append("\n\n");
		buffer.append("回复“?”显示主菜单");
		return buffer.toString();
	}
	
}

