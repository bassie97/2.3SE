package cards;
import java.util.Scanner;

public class Problem
{
private Candidates candidates = new Candidates();
private Solution   solution   = new Solution();
private Scanner    reader = new Scanner(System.in);
private int counter = 0;
    
    public void solve()
{
     //System.out.println(candidates);
     //System.out.println(solution);
     //reader.nextLine();
     int index=0;
     while (index<candidates.size())
     {
    	 if (solution.fits(candidates.get(index)))
         {
        	 System.out.println("fits");
             solution.record(candidates.remove(index)); //move candidate to solution
             if (solution.complete())
             {
            	 counter++;
            	 System.out.println("There are " + counter + " possible solutions");
                 solution.show();
                 
                 
             }
             else
             {
                 solve();
             }
             candidates.add(index, solution.eraseRecording()); //move candidate to candidates
         }
           index++;
        }
     }
}



