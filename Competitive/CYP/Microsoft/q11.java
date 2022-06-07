public class q11 {
    static String bitWise(int i){
        
        StringBuilder sb = new StringBuilder();
        
        while(i!=0){
            sb.append(i%2);
            i/=2;
        }
        
        return sb.reverse().toString();
    }
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N)
    {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        
        for(int i=1;i<=N;i++){
            res.add(bitWise(i));
        }
        
        return res;
    }
}
