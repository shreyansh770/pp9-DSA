import java.util.*;

public class q10 {
    void matchPairs(char nuts[], char bolts[], int n) {
        // code here

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(nuts[i],i);
        }

        for(int i=0;i<n;i++){

            if(map.containsKey(bolts[i])){

                nuts[i] = bolts[i];
                
            }
        }

        Arrays.sort(nuts);
        Arrays.sort(bolts);
    }
}
