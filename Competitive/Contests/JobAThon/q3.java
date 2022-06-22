import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class q3 {

    static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }

    String kPeriodic(String s, int K) 
    { 
        // code here
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }

        int g = gcd(s.length(),K);

        for(Map.Entry<Character,Integer> e : map.entrySet()){

            if(e.getValue()%g!=0) return "-1";
        }

        StringBuilder res = new StringBuilder();
        HashMap<Character,Integer> set = new HashSet<>();

        for(Map.Entry<Character,Integer> e : map.entrySet()){

            int val = e.getValue()/g;
            while(val-->0){
                set.put(e.getKey(), set.getOrDefault(e.getKey(), 0)+1);
            }
        }

        for(Map.Entry<Character,Integer> e : set.entrySet()){
              
            int val = e.getValue();
            while(val-->0){
                res.append(e.getKey());
            }
        }

        StringBuilder ans = new StringBuilder();

        while(ans.length()<s.length()){
            ans.append(res.toString());
        }
        
        return ans.toString();
    }
}
