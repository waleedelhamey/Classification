import java.util.ArrayList;
import java.util.Iterator;

public class DataSet {
	ArrayList<Record>dataset;
	ArrayList<Feature> features;
	float accuracy=0;
	public DataSet() {
		super();
		dataset = new ArrayList<Record>();
		features = new ArrayList<Feature>();
		features.add(new Feature("Buying price"));
		features.add(new Feature("Maintenance price"));
		features.add(new Feature("Number of doors"));
		features.add(new Feature("Capacity"));
		features.add(new Feature("Size of luggage boot"));
		features.add(new Feature("Car safety"));
		features.add(new Feature("Car acceptability"));
		

	}
	/**
	 * Counting the appearance of each value in a feature
	 */
	public void countingValuesOfFeatures() {
		for(int i=0;i<dataset.size();++i) {
			features.get(0).valuesFrequency.merge(dataset.get(i).getBuyingPriceVal()+","+dataset.get(i).getCarAccVal(),
					 (float) 1, Float::sum);
			features.get(1).valuesFrequency.merge(dataset.get(i).getMaintenancePriceVal()+","+dataset.get(i).getCarAccVal(),
					(float) 1, Float::sum);
			features.get(2).valuesFrequency.merge(dataset.get(i).getNumofDoorsVal()+","+dataset.get(i).getCarAccVal(),
					(float) 1, Float::sum);
			features.get(3).valuesFrequency.merge(dataset.get(i).getCapacityVal()+","+dataset.get(i).getCarAccVal(),
					(float) 1, Float::sum);
			features.get(4).valuesFrequency.merge(dataset.get(i).getSizeofLuggageBootVal()+","+dataset.get(i).getCarAccVal(),
					(float) 1, Float::sum);
			features.get(5).valuesFrequency.merge(dataset.get(i).getCarSafetyVal()+","+dataset.get(i).getCarAccVal(),
					(float) 1, Float::sum);
			features.get(6).valuesFrequency.merge(dataset.get(i).getCarAccVal(), (float) 1, Float::sum);
		}
	}
	public void calculatingProbabilitiesOfValuesOfEachFeatures() {
		for(int i=0;i<features.size()-1;++i) {
			for (Iterator<String> keys = features.get(i).valuesFrequency.keySet().iterator(); keys.hasNext();) {
				String key = keys.next();
		        String[] keyArr = key.split(",");
		        Float val = features.get(i).valuesFrequency.get(key);
		    
		        for (Iterator<String> keysofLabel = features.get(6).valuesFrequency.keySet().iterator(); keysofLabel.hasNext();) {
		        	String keyOfLabel = keysofLabel.next();
		        	Float vals = features.get(6).valuesFrequency.get(keyOfLabel);
		        	if(keyArr[1].equalsIgnoreCase(keyOfLabel)) {
			        	features.get(i).valuesProbabilites.put(keyArr[0]+"/"+keyOfLabel, (val/vals));
		        	}else {
			        	features.get(i).valuesProbabilites.put(keyArr[0]+"/"+keyOfLabel, (float)0.0000001);

		        	}
		        }
	        }
		}
		for (Iterator<String> keysofLabel = features.get(6).valuesFrequency.keySet().iterator(); keysofLabel.hasNext();) {
        	String keyOfLabel = keysofLabel.next();
        	Float vals = features.get(6).valuesFrequency.get(keyOfLabel);
	        features.get(6).valuesProbabilites.put(keyOfLabel, (vals/dataset.size()));
        	
        }
	}

	public void testingDataset(DataSet testingSet) {
		for(int i=0;i<testingSet.dataset.size();++i) {
			Record testRecord = new Record(testingSet.dataset.get(i)); // get the record from the testing dataset
			ArrayList<Float>unaccValues = new ArrayList<Float>();
			ArrayList<Float>accValues = new ArrayList<Float>();
			ArrayList<Float>vgoodValues = new ArrayList<Float>();
			ArrayList<Float>goodValues = new ArrayList<Float>();
			float unaccResult=0,accResult=0,vgoodResult=0,goodResult=0;
			// for all values in the training set with label unacc
			for(int j=0;j<features.size()-1;++j) {
				if(features.get(j).featureName.equalsIgnoreCase("Buying price")) {
					unaccValues.add(features.get(j).valuesProbabilites.get(testRecord.getBuyingPriceVal()+"/unacc"));
					accValues.add(features.get(j).valuesProbabilites.get(testRecord.getBuyingPriceVal()+"/acc"));
					vgoodValues.add(features.get(j).valuesProbabilites.get(testRecord.getBuyingPriceVal()+"/vgood"));
					goodValues.add(features.get(j).valuesProbabilites.get(testRecord.getBuyingPriceVal()+"/good"));
					
				}else if(features.get(j).featureName.equalsIgnoreCase("Maintenance price")) {
					unaccValues.add(features.get(j).valuesProbabilites.get(testRecord.getMaintenancePriceVal()+"/unacc"));
					accValues.add(features.get(j).valuesProbabilites.get(testRecord.getMaintenancePriceVal()+"/acc"));
					vgoodValues.add(features.get(j).valuesProbabilites.get(testRecord.getMaintenancePriceVal()+"/vgood"));
					goodValues.add(features.get(j).valuesProbabilites.get(testRecord.getMaintenancePriceVal()+"/good"));
					
				}else if(features.get(j).featureName.equalsIgnoreCase("Number of doors")) {
					unaccValues.add(features.get(j).valuesProbabilites.get(testRecord.getNumofDoorsVal()+"/unacc"));
					accValues.add(features.get(j).valuesProbabilites.get(testRecord.getNumofDoorsVal()+"/acc"));
					vgoodValues.add(features.get(j).valuesProbabilites.get(testRecord.getNumofDoorsVal()+"/vgood"));
					goodValues.add(features.get(j).valuesProbabilites.get(testRecord.getNumofDoorsVal()+"/good"));
					
				}else if(features.get(j).featureName.equalsIgnoreCase("Capacity")) {
					unaccValues.add(features.get(j).valuesProbabilites.get(testRecord.getCapacityVal()+"/unacc"));
					accValues.add(features.get(j).valuesProbabilites.get(testRecord.getCapacityVal()+"/acc"));
					vgoodValues.add(features.get(j).valuesProbabilites.get(testRecord.getCapacityVal()+"/vgood"));
					goodValues.add(features.get(j).valuesProbabilites.get(testRecord.getCapacityVal()+"/good"));
					
				}else if(features.get(j).featureName.equalsIgnoreCase("Size of luggage boot")) {
					unaccValues.add(features.get(j).valuesProbabilites.get(testRecord.getSizeofLuggageBootVal()+"/unacc"));
					accValues.add(features.get(j).valuesProbabilites.get(testRecord.getSizeofLuggageBootVal()+"/acc"));
					vgoodValues.add(features.get(j).valuesProbabilites.get(testRecord.getSizeofLuggageBootVal()+"/vgood"));
					goodValues.add(features.get(j).valuesProbabilites.get(testRecord.getSizeofLuggageBootVal()+"/good"));
					
				}else if(features.get(j).featureName.equalsIgnoreCase("Car safety")) {
					unaccValues.add(features.get(j).valuesProbabilites.get(testRecord.getCarSafetyVal()+"/unacc"));
					accValues.add(features.get(j).valuesProbabilites.get(testRecord.getCarSafetyVal()+"/acc"));
					vgoodValues.add(features.get(j).valuesProbabilites.get(testRecord.getCarSafetyVal()+"/vgood"));
					goodValues.add(features.get(j).valuesProbabilites.get(testRecord.getCarSafetyVal()+"/good"));
					
				}
		
			}
			unaccValues.add(features.get(6).valuesProbabilites.get("unacc"));
			accValues.add(features.get(6).valuesProbabilites.get("acc"));
			vgoodValues.add(features.get(6).valuesProbabilites.get("vgood"));
			goodValues.add(features.get(6).valuesProbabilites.get("good"));
			
			unaccResult = calculateProbabilities(unaccValues);
			accResult = calculateProbabilities(accValues);
			vgoodResult = calculateProbabilities(vgoodValues);
			goodResult = calculateProbabilities(goodValues);
			String res = checkBiggerLabelValue(unaccResult, accResult, vgoodResult, goodResult);

			if(res.equalsIgnoreCase(testRecord.carAccVal)) {
				
				accuracy++;
			}


		}
		accuracy = (accuracy/testingSet.dataset.size())*100;
	}
	public String checkBiggerLabelValue(float unaccResult,float accResult,float vgoodResult,float goodResult) {
		if(unaccResult>accResult && unaccResult>vgoodResult && unaccResult>goodResult) {
			return "unacc";
		}
		else if(accResult>unaccResult && accResult>vgoodResult && accResult>goodResult) {
			return "acc";
		}
		else if(vgoodResult>unaccResult && vgoodResult>accResult && vgoodResult>goodResult) {
			return "vgood";
		}
		else if(goodResult>unaccResult && goodResult>accResult && goodResult>vgoodResult) {
			return "good";
		}
		return "acc";
	}
	public float calculateProbabilities(ArrayList<Float> values) {
		float res=1;
		for(int i=0;i<values.size();++i) {
			res*=values.get(i);
		}
		return res;
	}
	public void printDataSet() {
		for(int i =0;i<dataset.size();++i) {
			System.out.println(dataset.get(i).getBuyingPriceVal()+" , "+
				dataset.get(i).getMaintenancePriceVal()+" , "+dataset.get(i).getNumofDoorsVal()+" , "+
				dataset.get(i).getCapacityVal()+" , "+dataset.get(i).getSizeofLuggageBootVal()+" , "+
				dataset.get(i).getCarSafetyVal()+" , "+dataset.get(i).getCarAccVal());
			
		}
	}
	public void printAllValuesOfEachFeature() {
		for(int i=0;i<features.size();++i) {
			features.get(i).printValuesFrequency();
			System.out.println("__________________________________________");

		}
	}
	public void printAllProbabilitiesOfValuesOfEachFeature() {
		for(int i=0;i<features.size();++i) {
			features.get(i).printProbabilitiesOfValues();
			System.out.println("__________________________________________");

		}
	}
}
