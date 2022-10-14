import java.util.*;
import java.io.*;

public class C888 {

    public static boolean solve(char[] a ,int l , char c){

        int[] fm = new int[26];

        for(int i=0;i<l;i++){
            fm[a[i]-'a']++;
        }

        if(fm[c-'a']==0) return false;

        for(int i=l;i<a.length;i++){
            
            // character getting removed
            fm[a[i-l]-'a']--;
            fm[a[i]-'a']++;
            if(fm[c-'a']==0) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        char[] s = scn.next().toCharArray();

        int res = s.length;
        // 26nlogn
        for (int i = 0; i < 26; i++) {

            char ctf = (char) ('a' + i);

            int si = 1;
            int ei = s.length;
            int ans = s.length;
            while(si<=ei){

                int l = (si+ei)/2;

                if(solve(s,l, ctf)){
                    ans = l;
                    ei = l-1;

                }else{
                    si = l+1;
                }
            }

            res = Math.min(res,ans);
        }

        System.out.println(res);

    }
}
