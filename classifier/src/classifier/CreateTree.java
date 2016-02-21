package classifier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class CreateTree {
	public static void main(String[] args) throws NumberFormatException, IOException {
		TextFileReader textFileReader = new TextFileReader();
		Map<Item, String> trainingSet = textFileReader.getTrainingSet();
		Map<String, FeatureType> featureSet = textFileReader.getFeatures();
		
		DecisionTree tree = new DecisionTree(trainingSet, featureSet);
	}

}
