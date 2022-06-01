import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Feature {
	String featureName;
    Map<String, Float> valuesFrequency = new ConcurrentHashMap<>();
    Map<String, Float> valuesProbabilites = new ConcurrentHashMap<>();
    
	public Feature() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feature(String featureName) {
		super();
		this.featureName = featureName;
	}
    
	public Feature(String featureName, Map<String, Float> valuesFrequency, Map<String, Float> valuesProbabilites) {
		super();
		this.featureName = featureName;
		this.valuesFrequency = valuesFrequency;
		this.valuesProbabilites = valuesProbabilites;
	}
	public void printValuesFrequency() {
		System.out.println("********"+featureName+"********");
		for (Iterator<String> keys = valuesFrequency.keySet().iterator(); keys.hasNext();) {
	        String key = keys.next();
	        Float val = valuesFrequency.get(key);
	        System.out.println(key+" = "+val);
	    }
		
	}
	public void printProbabilitiesOfValues() {
		System.out.println("********Probabilities in "+featureName+"********");
		for (Iterator<String> keys = valuesProbabilites.keySet().iterator(); keys.hasNext();) {
	        String key = keys.next();
	        Float val = valuesProbabilites.get(key);
	        System.out.println(key+" = "+val);
	    }
		
	}
    
    

}
