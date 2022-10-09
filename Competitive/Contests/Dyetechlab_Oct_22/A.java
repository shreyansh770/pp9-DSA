import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t-->0){
            int n = scn.nextInt();
            int k = scn.nextInt();

            char[] s = scn.next().toCharArray();
            // Arrays.sort(s);
            HashMap<Character,Integer> map = new HashMap<>();
            int[] f = new int[26];
            for(char ch : s){
                f[ch-97]++;
            }

            StringBuilder sb = new StringBuilder();

            int len = n/k;
            for(int i=0;i<k;i++){
                int idx = 0;
                int l = 0;
                for(int j=0;j<26;j++,idx++){

                    if(f[j]>0){
                        l++;
                        f[j]--;
                        if(l==len) break;
                    }else{
                        sb.append((char)(97+j));
                        break;
                    }
                }

                if(l==len){
                    sb.append((char)(97+idx+1));
                }

             
            }

            System.out.println(sb.toString());
            

        }
    }
}