package classifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DecisionTreeBuilder {
	private FeatureType yn = new FeatureType("YesNo",new String[]{"yes","no"});
	private Map<Item, String> trainingsSet = new HashMap<Item, String>();
	
	public DecisionTreeBuilder() throws FileNotFoundException{
//		try {
//			new DecisionTree(createTrainingSet(), defineFeatures());				
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
		createTrainingSet();
	}
	
	private Map<Item, String> createTrainingSet() throws FileNotFoundException {
		//create a file instance
		File file = makeAbsoluteFilename("CatText.txt");
		
		// create a Scanner for the file
		Scanner input = new Scanner(file);
		
		// use ; as delimeter
		input.useDelimiter(";");
		
		int featureCount = 0;
		int itemCount = 0;
		
		if(input.next() == "Features"){
			featureCount = input.nextInt();
		}
		
		if(input.next() == "Items"){
			itemCount = input.nextInt();
		}
		
		System.out.println(itemCount + ", " + featureCount );
		//read the data from the file
		while(input.hasNext()){
			
		}
		
		//close the file
		input.close();
		return trainingsSet;
	}

	private Item createItem(String ac, String abs){
		Feature[] featureValues = new Feature[]{ 
													new Feature("AC",ac,yn),
													new Feature("ABS",abs,yn)
		                                       };

		return new Item("car", featureValues);
	}
	
	public Map<String, FeatureType> defineFeatures(){
		Map<String, FeatureType> features = new HashMap<String, FeatureType>();
		
		features.put("AC", yn);
		features.put("ABS", yn);
		features.put("Spoiler", yn);
		features.put("NOS", yn);
		features.put("Lederen bekleding", yn);
		features.put("Audio plus", yn);
		features.put("Beast motor", yn);
		features.put("Chrome wheels", yn);
		
		return features;

	}
	
	private File makeAbsoluteFilename(String filename)
    {
        File file = new File(filename);
        if(!file.isAbsolute()) {
            file = new File(getProjectFolder(), filename);
        }
        return file;
    }
	
	private File getProjectFolder()
    {
         String myClassFile = getClass().getName() + ".class";
         URL url = getClass().getResource(myClassFile);
         return new File(url.getPath()).getParentFile();
    }

}
