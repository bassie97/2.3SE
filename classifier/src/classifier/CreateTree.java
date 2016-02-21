package classifier;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class CreateTree {
	
	public static void main(String[] args) throws FileNotFoundException {
		TextFileReader textFileReader = new TextFileReader();
		
		//retrieve the required information for the creation of the decision tree.
		Map<Item, String> trainingSet = textFileReader.getTrainingsSet();
		Map<String, FeatureType> features = textFileReader.getFeatures();
		
		new DecisionTree(trainingSet, features);		
				
	}

}
