package classifier;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TextFileReader {
	private static final FeatureType yn = new FeatureType("YesNo",new String[]{"yes","no"});
	private static final String TRAINING_SET = "trainingset.txt";
	private static final String FEATURE_SET = "featureset.txt";
	
	//needed for creating a decision tree
	private Map<Item, String> trainingsSet = new HashMap<Item, String>();
	private Map<String, FeatureType> features = new HashMap<String, FeatureType>();

	public TextFileReader(){
		//create buffered reader for reading the files
		InputStream trainingSetInput = getClass().getResourceAsStream(TRAINING_SET);
		BufferedReader trainingSetReader = new BufferedReader(new InputStreamReader(trainingSetInput));
		
		InputStream featureSetInput = getClass().getResourceAsStream(FEATURE_SET);
		BufferedReader featureSetReader = new BufferedReader(new InputStreamReader(featureSetInput));
		
	}
	
	
	public Map<String, FeatureType> getFeatures() {
		return features;
	}
	
	/**
	 *create a set of features, retrieved from a textfile
	 * @param features
	 */
	public void setFeatures(Map<String, FeatureType> features) {
		this.features = generateFeatures();
	}
	
	private Map<String, FeatureType> generateFeatures() {
		
	}


	public Map<Item, String> getTrainingsSet() {
		return trainingsSet;
	}
	
	/**
	 * create a set of items, retrieved from a textfile
	 * @param trainingsSet
	 */
	public void setTrainingsSet(Map<Item, String> trainingsSet) {
		this.trainingsSet = trainingsSet;
	}
}
