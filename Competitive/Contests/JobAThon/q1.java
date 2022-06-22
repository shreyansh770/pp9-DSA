import java.util.HashMap;

public class q1 {
    int solve(int N, int y, int [] A) {
	    
        HashMap<Integer,Integer> map = new HashMap<>();

        int maxFreq = 0;
        for(int e : A){
            map.put(e,map.getOrDefault(e, 0)+1);
            maxFreq = Math.max(map.get(e),maxFreq);
        }


        return maxFreq;

        
	}
}
