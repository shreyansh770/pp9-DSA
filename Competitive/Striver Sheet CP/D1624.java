import java.util.Scanner;

public class D1624 {
    

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-->0){
            int n = scn.nextInt();
            int k = scn.nextInt();

            String s = scn.next();

            int[] freq = new int[26];

            // int pair_count = 0;
            
            for(int i=0;i<s.length();i++){

                char ch = s.charAt(i);

                freq[ch-'a']++;
            }

            int pair_count =0;
            int ind_count = 0;
            for(int i=0;i<26;i++){

                 pair_count+= freq[i]/2;
                 ind_count += freq[i]%2;
            }

            if(pair_count<k){
                System.out.println('1');
            }else{

                // what will be the length of a palindrome 
                int pu = (pair_count/k); // no of pairs allocated to each of the k strings

                int len_of_string = pu*2 ; // 
                int pairs_left = (pair_count%k);

                ind_count+=(pairs_left)*2; // since now they are individual we will count pairs as ind

                if(ind_count>=k) len_of_string++; // distribute each of individual numbers into each of the k strings

                System.out.println(len_of_string);

                
            }
        }
    }
}
