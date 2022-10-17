import java.util.*;
import java.io.*;

public class A{
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int t  =scn.nextInt();
            while(t-->0){

                int n = scn.nextInt();

                int[] a = new int[n];
                for(int i=0;i<n;i++){
                    a[i]  = scn.nextInt();
                }

                char[] s = scn.next().toCharArray();

                HashMap<Integer,Character> map = new HashMap<>();

                boolean flag = true;
                for(int i=0;i<n;i++){
                    
                    if(map.containsKey(a[i])){

                        char ch = map.get(a[i]);
                        if(ch!=s[i]) {
                            flag = false;
                            break;
                        }
                    }else{
                        map.put(a[i],s[i]);
                    }
                }

                if(!flag){
                    System.out.println("NO");
                }else{
                    System.out.println("YES");
                }
            }
    }
}