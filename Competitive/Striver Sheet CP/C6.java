import java.util.*;

public class C6 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int[] alice = new int[n];
        int[] bob = new int[n];

        alice[0] = arr[0];
        bob[n - 1] = arr[n - 1];
        for (int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {
            alice[i] = alice[i - 1] + arr[i];
            bob[j] = bob[j + 1] + arr[j];
        }

        int a = 0;
        int b = 0;

        for(int i=0;i<n;i++){

            if(alice[i]<=bob[i]) a++;
            else b++;
        }

        System.out.println(a+" "+b);
    }
}
