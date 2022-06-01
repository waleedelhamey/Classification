
public class Record {
	String buyingPriceVal,maintenancePriceVal,numofDoorsVal,capacityVal,sizeofLuggageBootVal,carSafetyVal,carAccVal;

	public Record(String buyingPriceVal, String maintenancePriceVal, String numofDoorsVal, String capacityVal,
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
	public Record(Record rec) {
		super();
		this.buyingPriceVal = rec.buyingPriceVal;
		this.maintenancePriceVal = rec.maintenancePriceVal;
		this.numofDoorsVal = rec.numofDoorsVal;
		this.capacityVal = rec.capacityVal;
		this.sizeofLuggageBootVal = rec.sizeofLuggageBootVal;
		this.carSafetyVal = rec.carSafetyVal;
		this.carAccVal = rec.carAccVal;
	}
	public Record() {
		super();
		// TODO Auto-generated constructor stub
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
