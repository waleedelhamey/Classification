import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KNNRecord {
	String buyingPriceVal,maintenancePriceVal,numofDoorsVal,capacityVal,sizeofLuggageBootVal,carSafetyVal,carAccVal;
	ArrayList<Distance> allDistances = new ArrayList<>();
	public KNNRecord(String buyingPriceVal, String maintenancePriceVal, String numofDoorsVal, String capacityVal,
			String sizeofLuggageBootVal, String carSafetyVal, String carAccVal) {
		super();
		this.buyingPriceVal = buyingPriceVal;
		this.maintenancePriceVal = maintenancePriceVal;
		this.numofDoorsVal = numofDoorsVal;
		this.capacityVal = capacityVal;
		this.sizeofLuggageBootVal = sizeofLuggageBootVal;
		this.carSafetyVal = carSafetyVal;
		this.carAccVal = carAccVal;
	}
	public KNNRecord(KNNRecord rec) {
		super();
		this.buyingPriceVal = rec.buyingPriceVal;
		this.maintenancePriceVal = rec.maintenancePriceVal;
		this.numofDoorsVal = rec.numofDoorsVal;
		this.capacityVal = rec.capacityVal;
		this.sizeofLuggageBootVal = rec.sizeofLuggageBootVal;
		this.carSafetyVal = rec.carSafetyVal;
		this.carAccVal = rec.carAccVal;
	}
	public void calculateDistanceWithTrainingSet(KNN knnTrainingSet) {
		for(int i=0;i<knnTrainingSet.dataset.size();++i) {
			float buyingPrice = (float) Math.pow(knnTrainingSet.features.get(0).featureValues.get(this.buyingPriceVal)
					-knnTrainingSet.features.get(0).featureValues.get(knnTrainingSet.dataset.get(i).buyingPriceVal), 2);
			
			float maintenancePrice = (float) Math.pow(knnTrainingSet.features.get(1).featureValues.get(this.maintenancePriceVal)
					-knnTrainingSet.features.get(1).featureValues.get(knnTrainingSet.dataset.get(i).maintenancePriceVal), 2);
			
			float numofDoors = (float) Math.pow(knnTrainingSet.features.get(2).featureValues.get(this.numofDoorsVal)
					-knnTrainingSet.features.get(2).featureValues.get(knnTrainingSet.dataset.get(i).numofDoorsVal), 2);
			
			float capacity = (float) Math.pow(knnTrainingSet.features.get(3).featureValues.get(this.capacityVal)
					-knnTrainingSet.features.get(3).featureValues.get(knnTrainingSet.dataset.get(i).capacityVal), 2);
			
			float sizeofLuggageBoot = (float) Math.pow(knnTrainingSet.features.get(4).featureValues.get(this.sizeofLuggageBootVal)
					-knnTrainingSet.features.get(4).featureValues.get(knnTrainingSet.dataset.get(i).sizeofLuggageBootVal), 2);
			
			float carSafety = (float) Math.pow(knnTrainingSet.features.get(5).featureValues.get(this.carSafetyVal)
					-knnTrainingSet.features.get(5).featureValues.get(knnTrainingSet.dataset.get(i).carSafetyVal), 2);
			float totalDistance = (float) Math.sqrt(buyingPrice+maintenancePrice+numofDoors+capacity+sizeofLuggageBoot+carSafety);
			allDistances.add(new Distance(knnTrainingSet.dataset.get(i).carAccVal, totalDistance));
			
		}
	}
	public KNNRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void printDistance() {
		for(int i=0;i<allDistances.size();++i) {
			System.out.println(allDistances.get(i).getLabelValue()+" and "+allDistances.get(i).getDistance());
		}
	}
	public void printRecord() {
		System.out.println(this.buyingPriceVal+" , "+this.maintenancePriceVal+" , "+this.numofDoorsVal+" , "
				+this.capacityVal+" , "+this.sizeofLuggageBootVal+" , "+this.carSafetyVal+" , "+this.carAccVal);
	}
	public void sortDistances() {
		int i, j;
		float key;
		String keyLabel;
	    for (i = 1; i < allDistances.size(); i++)
	    {
	        key = allDistances.get(i).getDistance();
	        keyLabel = allDistances.get(i).getLabelValue();

	        j = i - 1;

	        while (j >= 0 && allDistances.get(j).getDistance() > key)
	        {
	        	allDistances.get(j+1).setDistance(allDistances.get(j).getDistance());
	        	allDistances.get(j+1).setLabelValue(allDistances.get(j).getLabelValue());
	            j = j - 1;
	        }
	        allDistances.get(j+1).setDistance(key);
	        allDistances.get(j+1).setLabelValue(keyLabel);

	    }
	}
	public String majorityVoting() {
		int maxCount = 0;
        int index = -1; // sentinels
        for (int i = 0; i < 4; i++) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                if (allDistances.get(i) == allDistances.get(j))
                    count++;
            }
 
            // update maxCount if count of
            // current element is greater
            if (count > maxCount) {
                maxCount = count;
                index = i;
            }
        }
 
        // if maxCount is greater than n/2
        // return the corresponding element
        
        return allDistances.get(index).getLabelValue();
	}
	public String getBuyingPriceVal() {
		return buyingPriceVal;
	}

	public void setBuyingPriceVal(String buyingPriceVal) {
		this.buyingPriceVal = buyingPriceVal;
	}

	public String getMaintenancePriceVal() {
		return maintenancePriceVal;
	}

	public void setMaintenancePriceVal(String maintenancePriceVal) {
		this.maintenancePriceVal = maintenancePriceVal;
	}

	public String getNumofDoorsVal() {
		return numofDoorsVal;
	}

	public void setNumofDoorsVal(String numofDoorsVal) {
		this.numofDoorsVal = numofDoorsVal;
	}

	public String getCapacityVal() {
		return capacityVal;
	}

	public void setCapacityVal(String capacityVal) {
		this.capacityVal = capacityVal;
	}

	public String getSizeofLuggageBootVal() {
		return sizeofLuggageBootVal;
	}

	public void setSizeofLuggageBootVal(String sizeofLuggageBootVal) {
		this.sizeofLuggageBootVal = sizeofLuggageBootVal;
	}

	public String getCarSafetyVal() {
		return carSafetyVal;
	}

	public void setCarSafetyVal(String carSafetyVal) {
		this.carSafetyVal = carSafetyVal;
	}

	public String getCarAccVal() {
		return carAccVal;
	}

	public void setCarAccVal(String carAccVal) {
		this.carAccVal = carAccVal;
	}
}
