
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
			gr.zitErinA(value);
			times += (tijd() - start);
		}
		int time = times / 50;
		
		System.out.println("A voltooid in " + (time) + " nanoseconden");
		
		times = 0;
		for(int i = 0; i<50; i++){		
			
			long start = tijd();
			gr.zitErinB(value);
			times += (tijd() - start);
		}
		int time1 = times / 50;
		
		System.out.println("B voltooid in " + (time1) + " nanoseconden");
		
		times =0;
		for(int i = 0; i<50; i++){		
			
			long start = tijd();
			gr.zitErinC(value);
			times += (tijd() - start);
		}
		int time2 = times / 50;
		
		System.out.println("C voltooid in " + (time2) + " nanoseconden");
		
		times= 0;
		for(int i = 0; i<50; i++){		
			
			long start = tijd();
			gr.zitErinD(value);
			times += (tijd() - start);
		}
		int time3 = times / 50;
		
		System.out.println("D voltooid in " + (time3) + " nanoseconden");
	}

	// Hulpmethode voor tijdsbepaling
	private static long tijd(){
		return System.nanoTime();
	}

}
