import java.lang.reflect.Array;
import java.util.*;

public class infosysQues {

    // checking palindrome

    static boolean isPalindrome(String str)
    {

        int i = 0, j = str.length() - 1;
 
        while (i < j) {

            if (str.charAt(i) != str.charAt(j))
                return false;
 
            i++;
            j--;
        }
 

        return true;
    }



    // finding substring

    public static int SubString(String str, int n,ArrayList<String> ans) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                 String palin = str.substring(i, j);
                if(isPalindrome(palin) && palin.length() ==1 ){
                     count++;
                     ans.add(palin);
                }
            }
        }

        return count;
    }

    // find all the possible permutation with represnt

    public static void comb(String ques, int i, String asf, ArrayList<String> ans, int idx) {

        if (i >= ques.length() || idx == 0) {

            ans.add(asf);

            return;
        }

        comb(ques, i, asf + ques.charAt(i), ans, idx - 1);

        comb(ques, i + 1, asf, ans, idx);

    }

    public static void main(String[] args) {

        ArrayList<String> res = new ArrayList<>();
        String str = "456789";

        comb(str, 0, "", res, str.length());
        int count = 0;
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
              count+=SubString(res.get(i), res.get(i).length(),ans);
        }

        System.out.println(count);
        System.out.println(ans);
    }
}
