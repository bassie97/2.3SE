import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class GetalRij {
	private int[] getallen;
	
	public GetalRij( int aantal, int max ){
		// Belangrijke aanname: aantal < max, anders kunnen de getallen niet uniek zijn.
		getallen = new int[aantal];
		vulArrayMetUniekeWaarden( aantal, max );
	}

	private void vulArrayMetUniekeWaarden(int aantal, int max) {
		// Vul een hulplijst met getallen 0, ..., max
		ArrayList hulpLijst = new ArrayList( max );
		for ( int i=0; i<max; i++){
			hulpLijst.add( i );
		}
		
		// Stop 'aantal' random waarden in getallen
		Random r = new Random();
		for ( int i=0; i<aantal; i++){
			// Het omzetten van Integer naar int gaat sinds Java 1.5 automatisch (unboxing).
			int getal = (Integer) (hulpLijst.remove( r.nextInt( hulpLijst.size())));
			getallen[i] = getal;
		}
	}
	
	/**
	 * De meeste simpele methode om een getal te vinden in een array.
	 * @param 	zoekWaarde	Het getal om naar te zoeken in getallen[].
	 * @return 				Returned of de zoekWaarde gevonden is in getallen[].
	 */
	public boolean zitErinA( int zoekWaarde ){
		boolean found = false;
		int iterator = 0;
		while(iterator < getallen.length){
			if(getallen[iterator] == zoekWaarde)
				found = true;
			iterator++;
		}
		return found;
	}
	
	/**
	 * Iets efficiënter dan zitErinA. Stopt met loopen zodra het getal gevonden is.  
	 * @param 	zoekWaarde	Het getal om naar te zoeken in getallen[].
	 * @return 				Returned of de zoekWaarde gevonden is in getallen[].
	 */
	public boolean zitErinB( int zoekWaarde ){
		int iterator = 0;
		while(iterator < getallen.length){ // Stop wanneer de zoekWaarde gevonden is
			if(getallen[iterator] == zoekWaarde)
				return true;
			iterator++;
		}
		return false;
	}
	
	/** 
	 * Hier gaan we blokken cijfers overslaan.
	 * @param 	zoekWaarde	Het getal om naar te zoeken in getallen[].
	 * @return 				Returned of de zoekWaarde gevonden is in getallen[].
	 */
	public boolean zitErinC( int zoekWaarde ){
		int iterator = 0;
		int skip = 50;
		int sentinel = 0;
		while(iterator < getallen.length){
			if(getallen[iterator] < zoekWaarde){
				sentinel = iterator; 
				iterator += skip;
			}
			else if(getallen[iterator] > zoekWaarde)
				iterator--;
			
			if(iterator == zoekWaarde)
				return true;
			if(iterator == sentinel && sentinel != 0) // Garandeerd dat de loop ooit stopt.
				return false;
		}	
		return false;
	}
/**
 * Binary Left Search.
 * @param zoekWaarde
 * @return
 */
	public boolean zitErinD( int zoekWaarde ){
		int low = 0;
		int high = getallen.length;
		int mid;
		while( low < high ){
			mid = (low + high) / 2;
			if(getallen[mid] > zoekWaarde)
				high = mid-1;
			else if(getallen[mid] < zoekWaarde)
				low = mid+1;
			else if(getallen[mid] == zoekWaarde)
				return true;
		}
		return false;
	}
	
	public void sorteer(){
		Arrays.sort( getallen);
	}
	
	public void print(){
		for( int i=0; i<getallen.length; i++)
			System.out.println(getallen[i]);
	}

}
