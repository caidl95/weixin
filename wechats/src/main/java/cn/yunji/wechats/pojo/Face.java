package cn.yunji.wechats.pojo;


/**
 * Face Model
 */
public class Face implements Comparable<Face> {
	
	private String imageId;
	// 性别
	private String gender;
	// 年龄估计值
	private int age;
	
	// smile 笑容分析
	private String smile;
	//人脸姿势分析结果。返回值包含以下属性，每个属性的值为一个 [-180, 180] 的浮点数，小数点后 6 位有效数字。单位为角度。
	private Object headpose;
	/**
	 * 眼睛状态信息。返回值包含以下属性：
		 left_eye_status：左眼的状态
		right_eye_status：右眼的状态
		每个属性都包含以下字段。每个字段的值都是一个浮点数，范围 [0,100]，小数点后 3 位有效数字。字段值的总和等于 100。
		occlusion：眼睛被遮挡的置信度
		no_glass_eye_open：不戴眼镜且睁眼的置信度
		normal_glass_eye_close：佩戴普通眼镜且闭眼的置信度
		normal_glass_eye_open：佩戴普通眼镜且睁眼的置信度
		dark_glasses：佩戴墨镜的置信度
		no_glass_eye_close：不戴眼镜且闭眼的置信度
	 */
	private Object eyestatus;
	/**
	 * 情绪识别结果。返回值包含以下字段。每个字段的值都是一个浮点数，范围 [0,100]，小数点后 3 位有效数字。每个字段的返回值越大，则该字段代表的状态的置信度越高。字段值的总和等于 100
	 */
	private Object emotion;
	// 人脸质量判断
	private double facequality;
	// 人种：Asian/White/Black
	private String ethnicity;
	// 颜值颜值识别结果。返回值包含以下两个字段。每个字段的值是一个浮点数，范围 [0,100]，小数点后 3 位有效数字。male_score：男性认为的此人脸颜值分数。值越大，颜值越高。female_score：女性认为的此人脸颜值分数。值越大，颜值越高。
	private Object beauty;
	/**
	 * 嘴部状态信息，包括以下字段。每个字段的值都是一个浮点数，范围 [0,100]，小数点后 3 位有效数字。字段值的总和等于 100。
		surgical_mask_or_respirator：嘴部被医用口罩或呼吸面罩遮挡的置信度
		other_occlusion：嘴部被其他物体遮挡的置信度
		close：嘴部没有遮挡且闭上的置信度
		open：嘴部没有遮挡且张开的置信度
	 */
	private Object mouthstatus;
	/**
	 * 眼球位置与视线方向信息。返回值包括以下属性：
	 *left_eye_gaze：左眼的位置与视线状态
	 *right_eye_gaze：右眼的位置与视线状态
	 *每个属性都包括以下字段，每个字段的值都是一个浮点数，小数点后 3 位有效数字。
	 *position_x_coordinate: 眼球中心位置的 X 轴坐标。
	 *position_y_coordinate: 眼球中心位置的 Y 轴坐标。
	 *vector_x_component: 眼球视线方向向量的 X 轴分量。
	 *vector_y_component: 眼球视线方向向量的 Y 轴分量。
	 *vector_z_component: 眼球视线方向向量的 Z 轴分量。
	 */
	private Object eyegaze;
	/**
	 * 面部特征识别结果，包括以下字段。每个字段的值都是一个浮点数，范围 [0,100]，小数点后 3 位有效数字。每个字段的返回值越大，则该字段代表的状态的置信度越高。
	 *	health：健康
	 *	stain：色斑
	 *	acne：青春痘
	 *	dark_circle：黑眼圈
	 */
	private Object skinstatus;
	
	
	
	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	@Override
	public int compareTo(Face o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	public String getSmile() {
		return smile;
	}

	public void setSmile(String smile) {
		this.smile = smile;
	}

	public Object getHeadpose() {
		return headpose;
	}

	public void setHeadpose(Object headpose) {
		this.headpose = headpose;
	}

	public Object getEyestatus() {
		return eyestatus;
	}

	public void setEyestatus(Object eyestatus) {
		this.eyestatus = eyestatus;
	}

	public Object getEmotion() {
		return emotion;
	}

	public void setEmotion(Object emotion) {
		this.emotion = emotion;
	}

	public double getFacequality() {
		return facequality;
	}

	public void setFacequality(double facequality) {
		this.facequality = facequality;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public Object getBeauty() {
		return beauty;
	}

	public void setBeauty(Object beauty) {
		this.beauty = beauty;
	}

	public Object getMouthstatus() {
		return mouthstatus;
	}

	public void setMouthstatus(Object mouthstatus) {
		this.mouthstatus = mouthstatus;
	}

	public Object getEyegaze() {
		return eyegaze;
	}

	public void setEyegaze(Object eyegaze) {
		this.eyegaze = eyegaze;
	}

	public Object getSkinstatus() {
		return skinstatus;
	}

	public void setSkinstatus(Object skinstatus) {
		this.skinstatus = skinstatus;
	}

	
	
}