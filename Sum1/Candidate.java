public class Candidate
{
    private int value;
    
    public Candidate(int value)
    {
        this.value=value;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public String toString()
    {
        if (value<10)
        {
            return "0"+value;
        }
        else
        {
            return ""+value;
        }
    }
        

}
