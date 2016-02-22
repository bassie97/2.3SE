public class Problem
{
    private Candidates candidates = new Candidates();
    private Solution   solution   = new Solution();

    
    public void solve()
{
     //System.out.println(candidates);
     //System.out.println(solution);
     //System.out.println();
     int index=0;
     while (index<candidates.size())
     {
         if (solution.fits(candidates.get(index)))
         {
             solution.record(candidates.remove(index)); //move candidate to solution
             if (solution.complete())
             {
                 solution.show();
             }
             else
             {
                 solve();
             }
             candidates.add(index,solution.eraseRecording()); //move candidate to candidates
  
           }
           index++;
        }
}

}
        
          
         









