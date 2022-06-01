
public class Distance {
	String labelValue;
	float distance;
	public Distance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Distance(String labelValue, float distance) {
		super();
		this.labelValue = labelValue;
		this.distance = distance;
	}
	
	public String getLabelValue() {
		return labelValue;
	}
	public void setLabelValue(String labelValue) {
		this.labelValue = labelValue;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	
}
