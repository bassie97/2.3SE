package classifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	//needed for creating an array of features for an item
	private String[] stringFeatures;

	public TextFileReader() throws IOException{
		//create buffered reader for reading the files
		InputStream trainingSetInput = getClass().getResourceAsStream(TRAINING_SET);
		trainingSetReader = new BufferedReader(new InputStreamReader(trainingSetInput));
		
		InputStream featureSetInput = getClass().getResourceAsStream(FEATURE_SET);
		featureSetReader = new BufferedReader(new InputStreamReader(featureSetInput));
		
		generateFeatures();
		generateTrainingSet();
	}
	
	
	public Map<String, FeatureType> getFeatures() {
		return this.features;
	}
	
	/**
	 *create a set of features, retrieved from a textfile
	 * @param features
	 */
	public void setFeatures(Map<String, FeatureType> features) {
		this.features = features;
	}
	
	/**
	 * generate the set of features.
	 * @return featureSet
	 * @throws IOException
	 */
	private void generateFeatures() throws IOException {
		String line;
		Map<String, FeatureType> featureSet = new HashMap<String, FeatureType>();
		ArrayList<String> f = new ArrayList<String>();
		while((line = featureSetReader.readLine()) != null){
			featureSet.put(line, yn);
			f.add(line);
		}
		String[] fList = new String[f.size()];
		fList = f.toArray(fList);
		
		this.stringFeatures = fList;
		this.features = featureSet;
	}


	public Map<Item, String> getTrainingSet() {
		return this.trainingSet;
	}
	
	/**
	 * create a set of items, retrieved from a textfile
	 * @param trainingsSet
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void setTrainingSet(Map<Item, String> trainingSet) throws NumberFormatException, IOException {
		this.trainingSet = trainingSet;
	}
	
	public void generateTrainingSet() throws NumberFormatException, IOException{
		int featureCount = Integer.parseInt(trainingSetReader.readLine().split(";")[1]);
		int itemCount = Integer.parseInt(trainingSetReader.readLine().split(";")[1]);
		
		String line;
		
		Map<Item, String> itemSet = new HashMap<Item, String>();
		while((line = trainingSetReader.readLine()) != null ) {
			//create an array from the item information with a split on regex: ";"
			String[] lineArray = line.split(";");
			
			//name of the item
			String name = lineArray[0];
			
			//create an list of features that are included in the item
			ArrayList<Feature> itemFeatures = new ArrayList<Feature>();
			
			for(int i = 1; i < featureCount + 1; i++){
				Feature f;
				if(Integer.parseInt(lineArray[i]) == 1){
					f = new Feature(stringFeatures[i-1], "yes", yn);
					itemFeatures.add(f);
				}else if(Integer.parseInt(lineArray[i]) == 0){
					f = new Feature(stringFeatures[i-1], "no", yn);
					itemFeatures.add(f);
				}else{
					System.out.println("wrong value! " + lineArray[i]);
				}
				
			}
			Feature[] fArray = new Feature[itemFeatures.size()];
			fArray = itemFeatures.toArray(fArray);
			
			//create the item and put it in the itemSet
			Item item = new Item(name, fArray );
			System.out.println("Created: " + item.getName());
			itemSet.put(item, name);
		}
		this.trainingSet = itemSet;
	}
}
