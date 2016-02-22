
public class SnelheidOefening {

	/**
	 * @param args
	 */
	
	public static void main( String[] args){
		int value = 12345666;
		
		int times = 0;
		GetalRij gr = new GetalRij( 2000000, 2000000);
		for(int i = 0; i<50; i++){		
			
			long start = tijd();
			gr.zitErinB(value);
			times += (tijd() - start);
		}
		int time = times / 50;
		
		System.out.println("Voltooid in " + (time) + " nanoseconden");
	}

	// Hulpmethode voor tijdsbepaling
	private static long tijd(){
		return System.nanoTime();
	}

}
