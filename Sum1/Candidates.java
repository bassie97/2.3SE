import java.util.LinkedList;
import java.util.Iterator;
public class Candidates extends LinkedList<Candidate>
{

public Candidates()
{
    add(new Candidate(1));
    add(new Candidate(2));
    add(new Candidate(6));
    add(new Candidate(7));
    add(new Candidate(10));
    add(new Candidate(12));
}    

public String toString()
{
    Iterator it=iterator(); 
    String rS="";
    while (it.hasNext())
    {
        rS+=it.next()+" ";
    }
    return rS;
}

}

    
    
