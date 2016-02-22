import java.util.Stack;
import java.util.Iterator;

public class Solution extends Stack<Candidate> 
{

private int sumSofar=0;
private int sum=13; //sum of sequence

public Solution()
{
  
}


public boolean fits(Candidate candidate){
   if (!empty()&& peek().getValue()>= candidate.getValue()) return false;
   return sumSofar+candidate.getValue()<=sum;
}

public void record(Candidate candidate)
{
   sumSofar+=candidate.getValue();
   push(candidate);
}

public boolean complete()
{
   return sumSofar==sum;
}

public void show()
{
    System.out.println(this);
}

public Candidate eraseRecording()
{
  Candidate candidate=pop();
  sumSofar-=candidate.getValue();
  return candidate;
}

public String toString()
{
    Iterator it=iterator();
    String rS="";
    while (it.hasNext())
    {
        rS+=it.next() + " ";
    }
    return rS;
}





}
