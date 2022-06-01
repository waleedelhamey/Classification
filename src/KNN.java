import java.util.ArrayList;

public class KNN {
	ArrayList<KNNFeature> features;
	ArrayList<KNNRecord>dataset;
	float accuracy=0;
	public KNN() {
		super();
		dataset = new ArrayList<KNNRecord>();
		features = new ArrayList<KNNFeature>();
		features.add(new KNNFeature("Buying price"));
		features.add(new KNNFeature("Maintenance price"));
		features.add(new KNNFeature("Number of doors"));
		features.add(new KNNFeature("Capacity"));
		features.add(new KNNFeature("Size of luggage boot"));
		features.add(new KNNFeature("Car safety"));
		features.add(new KNNFeature("Car acceptability"));

	}
	public void calculateDistance(KNN knnTrainingSet) {
		for(int i=0;i<dataset.size();++i) {
			dataset.get(i).calculateDistanceWithTrainingSet(knnTrainingSet);
			dataset.get(i).sortDistances();
			String majorLabel=dataset.get(i).majorityVoting();
			if(majorLabel.equalsIgnoreCase(dataset.get(i).getCarAccVal())) {
				accuracy++;
			}


			
		}
		accuracy = (accuracy/this.dataset.size())*100;
	}
	public void printDataSet() {
		for(int i =0;i<dataset.size();++i) {
			System.out.println(dataset.get(i).getBuyingPriceVal()+" , "+
				dataset.get(i).getMaintenancePriceVal()+" , "+dataset.get(i).getNumofDoorsVal()+" , "+
				dataset.get(i).getCapacityVal()+" , "+dataset.get(i).getSizeofLuggageBootVal()+" , "+
				dataset.get(i).getCarSafetyVal()+" , "+dataset.get(i).getCarAccVal());
				
		}
	}
	public void printFeatureValues() {
		for(int i=0;i<features.size()-1;++i) {
			features.get(i).printFeatureValues();
			
		}
	}
}
