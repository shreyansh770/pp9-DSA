package Amazon;

import java.util.*;
import java.io.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });

        int n = scn.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
            pq.add(a[i]);
        }

        int k = scn.nextInt();

        // System.out.println(Math.ceil(5/2));
        int sum = 0;
        while (k-- >0) {

            int top = pq.remove();
            sum += top;
            pq.add((int) Math.ceil(top / 3)+1);
            
        }

        System.out.println(sum);
    }
}
