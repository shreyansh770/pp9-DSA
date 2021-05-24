import java.util.*;


public class twoDArray {
    public static Scanner scn = new Scanner(System.in);

    public static int maximum(int[][] arr){
       int maxV = -(int)1e9;

       int n = arr.length;
       int m = arr[0].length;

       for(int i= 0;i<n;i++)
       {
           for(int j=0;j<m;j++)
           {
               maxV = Math.max(maxV , arr[i][j]);
           }
       }

       return maxV;
    }

    public static int minimum(int[][] arr){
        int minV = (int)1e9;

        int n = arr.length;
        int m = arr[0].length;
 
        for(int i= 0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                minV = Math.min(minV , arr[i][j]);
            }
        }
 
        return minV;       
    }

    public static boolean find(int[][] arr , int data){
        int n = arr.length;
        int m = arr[0].length;
 
        for(int i= 0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(data == arr[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
      
        int n  = scn.nextInt();
        int m  = scn.nextInt();
        

        int[][] arr = new int[n][m];

        for(int i= 0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }

        

        System.out.println(maximum(arr));
        System.out.println(minimum(arr));

        int d = scn.nextInt();

        System.out.println(find(arr, d));


    }
}
