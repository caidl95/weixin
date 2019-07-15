package cn.yunji.wechats;

/**
 * Face Model
 */
public class Face implements Comparable<Face> {
	// ��������ÿһ���������� Face++ϵͳ�еı�ʶ��
	private String faceId;
	// �������ֵ
	private int ageValue;
	// �������ֵ����������
	private int ageRange;
	// �Ա�Male/Female
	private String genderValue;
	// �Ա�����Ŀ��Ŷ�
	private double genderConfidence;
	// ���֣�Asian/White/Black
	private String raceValue;
	// ���ַ����Ŀ��Ŷ�
	private double raceConfidence;
	// ΢Ц�̶�
	private double smilingValue;
	// ����������ĵ�����
	private double centerX;
	private double centerY;
	public String getFaceId() {
		return faceId;
	}
	public void setFaceId(String faceId) {
		this.faceId = faceId;
	}
	public int getAgeValue() {
		return ageValue;
	}
	public void setAgeValue(int ageValue) {
		this.ageValue = ageValue;
	}
	public int getAgeRange() {
		return ageRange;
	}
	public void setAgeRange(int ageRange) {
		this.ageRange = ageRange;
	}
	public String getGenderValue() {
		return genderValue;
	}
	public void setGenderValue(String genderValue) {
		this.genderValue = genderValue;
	}
	public double getGenderConfidence() {
		return genderConfidence;
	}
	public void setGenderConfidence(double genderConfidence) {
		this.genderConfidence = genderConfidence;
	}
	public String getRaceValue() {
		return raceValue;
	}
	public void setRaceValue(String raceValue) {
		this.raceValue = raceValue;
	}
	public double getRaceConfidence() {
		return raceConfidence;
	}
	public void setRaceConfidence(double raceConfidence) {
		this.raceConfidence = raceConfidence;
	}
	public double getSmilingValue() {
		return smilingValue;
	}
	public void setSmilingValue(double smilingValue) {
		this.smilingValue = smilingValue;
	}
	public double getCenterX() {
		return centerX;
	}
	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}
	public double getCenterY() {
		return centerY;
	}
	public void setCenterY(double centerY) {
		this.centerY = centerY;
	}
	// �����������ĵ����������������
	public int compareTo(Face face) {
		int result = 0;
		if (this.getCenterX() > face.getCenterX())
			result = 1;
		else
			result = -1;
		return result;
	}
}