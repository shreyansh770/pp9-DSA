import java.util.*;

public class q8 {

    Integer[] dp ;
    int mod = (int)1e9+7;
    public int rec(String s, int pos) {

        if (pos == s.length())
            return 1;

        if(dp[pos]!=null) return dp[pos];
        
        char ch1 = s.charAt(pos);
        
        int ans = 0;

        if(ch1 == '0') return 0;

        ans += rec(s,pos+1);

        if(pos<s.length()-1){

            char ch2 = s.charAt(pos+1);

            int num = (ch1-'0')*10 + (ch2-'0');

            if(num<=26){
                ans += rec(s,pos+2);
            }

        }

        return dp[pos] = (ans%mod);

        

    }

    public int CountWays(String str) {
        // code here
        dp = new Integer[str.length()];
        return rec(str, 0);
    }
}
