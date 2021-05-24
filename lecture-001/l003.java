import java.util.*;

public class l003 {
    public static Scanner scn = new Scanner(System.in);

    public static void test1(int n) {
        // type[] nameOfArray = new type[size]; with default value 0.
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void display1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " "); // get
        }
    }

    public static void display2(int[] arr) {

        // forEach loop used for :
        // 1. only for get, if you try to set value ypu get a beutifull error.
        // 2. automatically increment by 1
        // 3. always in forward direction
        // 4. range of loop : [0 , n - 1]

        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static void input1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt(); // set
        }
    }

    public static int[] input2(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt(); // set
        }

        return arr;
    }

    public static int maximum(int[] arr){
        int maxv = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>maxv){
                maxv = arr[i];
            }
        }

        return maxv;
    }

    public static int minimum(int[] arr){
        int minv = Integer.MAX_VALUE;                  
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<minv){
                minv = arr[i];
            }
        }

        return minv;
    }

    // if you found return index, otherwise return -1.
    public static int find(int[] arr,int data){
        int index = -1;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]== data){
                index= i;
                break;
            }
        }

        return index;
    }


    // public static int[] rotate(int[] arr){


    //     return null;
    // }


    public static void sumOfTwoArray(int[] arr1 , int[] arr2,int n1 , int n2){


            int[] ans = new int[n1];

            int i = n1-1,j = n2-1 , k = n1-1;

            int c = 0 , sum = 0;

            while(j>=0)
            {
                sum = arr1[i] + arr2[i] + c;
                ans[k] = (sum%10); // remainder

                c = sum/10;//quoient
                k--;
                i--;
                j--;

            }

            while(i>=0)
            {
                sum = arr1[i] + c;
                ans[k] = sum%10;
                c = sum/10;
                i--;
                k--;
            }

            // int res = 0;

            // if(c!=0){
            //     res = 10;
            // }
    }

    public static void diffOfTwoArray(int[] arr1 , int[] arr2){
        
    }


    public static void calc(int[] arr1 , int[] arr2)
    {
        if(arr1.length>=arr2.length){
            sumOfTwoArray(arr1,arr2,arr1.length,arr2.length);
        }
        else{
            sumOfTwoArray(arr1,arr2,arr2.length,arr1.length);
        }
    }

    public static void main(String[] args) {
        int n1 = scn.nextInt();
        int[] arr1 = input2(n1);
        int n2 = scn.nextInt();
        int [] arr2 = input2(n2);

        calc(arr1, arr2);

    }
}
