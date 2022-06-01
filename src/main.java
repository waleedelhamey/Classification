import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		DataSet allRecords = new DataSet();
		DataSet trainingSet = new DataSet();
		DataSet testingSet = new DataSet();
		KNN knnAllRecords = new KNN();
		KNN knnTrainingSet = new KNN();
		KNN knnTestingSet = new KNN();

	    Scanner scanner = new Scanner(new File("car_data.txt"));
		String line;
	    while(scanner.hasNextLine()){//Create candidate 1
	    	line = scanner.nextLine();	    	
	    	String[] str = line.split("\t");
	    	Record rec = new Record(str[0],str[1],str[2],str[3],str[4],str[5],str[6]);
	    	KNNRecord knnRec = new KNNRecord(str[0],str[1],str[2],str[3],str[4],str[5],str[6]);
	    	allRecords.dataset.add(rec);
	    	knnAllRecords.dataset.add(knnRec);
	    }
	    scanner.close();
	    Collections.shuffle(allRecords.dataset); //Shuffle the dataset for Bayesian classifier
	    Collections.shuffle(knnAllRecords.dataset); //Shuffle the dataset for knn classifier

	    // set the 75% of the dataset as training set
	    for(int i=0;i<(allRecords.dataset.size()*0.75);i++) {
	    	trainingSet.dataset.add(allRecords.dataset.get(i));
	    	knnTrainingSet.dataset.add(knnAllRecords.dataset.get(i));
	    }
	    
	    // set the rest of the dataset (i.e. 25%) as testing set
	    for(int i=(int) (allRecords.dataset.size()*0.75);i<allRecords.dataset.size();i++) {
	    	testingSet.dataset.add(allRecords.dataset.get(i));
	    	knnTestingSet.dataset.add(knnAllRecords.dataset.get(i));

	    }
//	    trainingSet.printDataSet();
//
	    trainingSet.countingValuesOfFeatures();
//	    //trainingSet.printAllValuesOfEachFeature();
//	    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	    trainingSet.calculatingProbabilitiesOfValuesOfEachFeatures();
//	    //trainingSet.printAllProbabilitiesOfValuesOfEachFeature();
//	    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//
	    trainingSet.testingDataset(testingSet);

	    System.out.println("Accuracy in Naïve Bayesian classifier = "+trainingSet.accuracy+"%");

	    knnTestingSet.calculateDistance(knnTrainingSet);
	    System.out.println("Accuracy in KNN classifier = "+knnTestingSet.accuracy+"%");
	    if(trainingSet.accuracy>knnTestingSet.accuracy) {
	    	System.out.println("Naïve Bayesian classifier is better");
	    }else {
	    	System.out.println("KNN classifier is better");
	    }

	}


}
