import java.util.*;


public class l004 {
     public static Scanner scn = new Scanner(System.in);

     public static void digitFreq(long n , int[] query)
     {
         int[] freq = new int[10];

         while(n!=0)
         {
             long rem = n % 10;
             n/=10;
             freq[(int)rem] ++;
         }

        for(int q : query)
        {
            System.out.println(freq[q]);
        }
     }

     public static void main(String[] args) {
         long n = scn.nextLong();
         int[] q = new int[scn.nextInt()];

         for(int i =0;i<q.length;i++)
         {
             q[i] = scn.nextInt();
             
         }

         digitFreq(n, q);
     }


}
