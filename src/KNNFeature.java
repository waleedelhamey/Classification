import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KNNFeature {
	String featureName;
    Map<String, Integer> featureValues = new ConcurrentHashMap<>();
    public KNNFeature() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KNNFeature(String featureName) {
		super();
		this.featureName = featureName;
		if(featureName.equalsIgnoreCase("Buying price")) {
			this.featureValues.put("vhigh", 0);
			this.featureValues.put("high", 1);
			this.featureValues.put("med", 2);
			this.featureValues.put("low", 3);
		}else if(featureName.equalsIgnoreCase("Maintenance price")){
			this.featureValues.put("vhigh", 0);
			this.featureValues.put("high", 1);
			this.featureValues.put("med", 2);
			this.featureValues.put("low", 3);
		}else if(featureName.equalsIgnoreCase("Number of doors")){
			this.featureValues.put("2", 0);
			this.featureValues.put("3", 1);
			this.featureValues.put("4", 2);
			this.featureValues.put("5more", 3);
		}else if(featureName.equalsIgnoreCase("Capacity")){
			this.featureValues.put("2", 0);
			this.featureValues.put("4", 1);
			this.featureValues.put("more", 2);
		}else if(featureName.equalsIgnoreCase("Size of luggage boot")){
			this.featureValues.put("small", 0);
			this.featureValues.put("med", 1);
			this.featureValues.put("big", 2);
		}else if(featureName.equalsIgnoreCase("Car safety")){
			this.featureValues.put("low", 0);
			this.featureValues.put("med", 1);
			this.featureValues.put("high", 2);
		}
	}
    
	public KNNFeature(String featureName, Map<String, Integer> featureValues) {
		super();
		this.featureName = featureName;
		this.featureValues = featureValues;
	}
	
	public void printFeatureValues() {
		System.out.println("********"+featureName+"********");
		for (Iterator<String> keys = featureValues.keySet().iterator(); keys.hasNext();) {
	        String key = keys.next();
	        Integer val = featureValues.get(key);
	        System.out.println(key+" = "+val);
	    }
		
	}
}
