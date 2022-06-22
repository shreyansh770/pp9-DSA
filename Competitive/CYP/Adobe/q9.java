import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class q9 {

    public void reverse(char num[], int i,
                                          int j)
    {
        while (i < j) {
            char temp = num[i];
            num[i] = num[j];
            num[j] = temp;
            i++;
            j--;
        }
    }

    public String nextPalin(String s) {

        char[] ch = s.toCharArray();

        int n = s.length();

        int csmallest = -1;
        int swapele = -1;
        int swapIdx = -1;
        // find the digit which is greater to its previous digit

        int mid = s.length() / 2 - 1;

        for (int i = mid - 1; i >= 0; i--) {
            int ch1 = (int) (s.charAt(i) - '0');
            int ch2 = (int) (s.charAt(i + 1) - '0');

            if (ch2 > ch2) {
                swapele = ch1;
                csmallest = i + 1;
                swapIdx = i;
                break;
            }
        }

        if (csmallest == -1)
            return "-1";
        int maxmin = -1;
        for (int i = csmallest + 1; i <= mid; i++) {
            int ch1 = (int) (s.charAt(i) - '0');
            int ch2 = (int)(s.charAt(csmallest)-'0');

            if(ch1>swapele && ch1<=ch2){
                csmallest = i;
            }
        }

        // now csmallest will be smaller to all the elements between swapIdx+1 and csmallest-1 => and after that we have to 
    

        // swap first half
        char ch1 = ch[swapIdx];
        ch[swapIdx]  =ch[csmallest];
        ch[csmallest] = ch1;

        // swap of sec half
        char ch2 = ch[n-swapIdx-1];
        ch[n-swapIdx-1] = ch[n-csmallest-1];
        ch[n-csmallest-1] = ch2;
        
        // Arrays.sort(ch, swapIdx+1, mid);
        reverse(ch, swapIdx+1, mid);

        // sorting can also be used
        if(n%2==0){
            // Arrays.sort(ch,mid+1,n-swapIdx,Collections.reverseOrder());
            reverse(ch, mid+1, n-swapIdx-1);
        }else{
            // Arrays.sort(ch,mid+2,n-swapIdx,Collections.reverseOrder());
            reverse(ch, mid+2, n-swapIdx-1);
        }

        for(ch c : ch){
            System.out.print(c+" ");
        }

        return "";
        
    }
}
