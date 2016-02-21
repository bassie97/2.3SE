package classifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TextFileReader {
	private static final FeatureType yn = new FeatureType("YesNo",new String[]{"yes","no"});
	private static final String TRAINING_SET = "trainingset.txt";
	private static final String FEATURE_SET = "featureset.txt";
	private BufferedReader trainingSetReader;
	private BufferedReader featureSetReader;
	
	//needed for creating a decision tree
	private Map<Item, String> trainingSet = new HashMap<Item, String>();
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
		try {
			this.features = generateFeatures();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * generate the set of features.
	 * @return featureSet
	 * @throws IOException
	 */
	private Map<String, FeatureType> generateFeatures() throws IOException {
		String line;
		Map<String, FeatureType> featureSet = new HashMap<String, FeatureType>();
		while((line = featureSetReader.readLine()) != null){
			featureSet.put(line, yn);
			System.out.println(line);
		}
		
		return featureSet;
	}


	public Map<Item, String> getTrainingSet() {
		return trainingSet;
	}
	
	/**
	 * create a set of items, retrieved from a textfile
	 * @param trainingsSet
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void setTrainingSet(Map<Item, String> trainingSet) throws NumberFormatException, IOException {
		this.trainingSet = generateTrainingSet();
	}
	
	private Map<Item, String> generateTrainingSet() throws NumberFormatException, IOException{
		int featureCount = Integer.parseInt(trainingSetReader.readLine().split(";")[1]);
		int itemCount = Integer.parseInt(trainingSetReader.readLine().split(";")[1]);
		
		String line;
		
		Map<Item, String> itemSet = new HashMap<Item, String>();
		while((line = trainingSetReader.readLine()) != null ) {
			
		}
		
		return itemSet;
	}
}
