import java.util.*;

public class sorting {

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
    public static boolean isGreater(int[] arr, int j, int i) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
          return true;
        } else {
          return false;
        }
      }


    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int n = arr1.length, m = arr2.length;
        int[] ans = new int[n + m];

        while (i < n && j < m) {
            if (arr1[i] < arr2[j])
                ans[k++] = arr1[i++];
            else
                ans[k++] = arr2[j++];
        }

        while (i < n)
            ans[k++] = arr1[i++];
        while (j < m)
            ans[k++] = arr2[j++];

        return ans;
    }
    

    public static int[] bubbleSort(int[] a) {

        // O(N^2)
        for (int li = a.length - 1; li > 0; li--) {
            boolean flag = false;//
            for (int i = 1; i <= li; i++)
                if (a[i] < a[i - 1]) {
                    swap(a, i, i - 1);
                    flag = true;
                }

            if (!flag)
                break;
        }

        return a;
    }


    public static void selectionSort(int[] a) {
      
      
        for (int li = 0; li < a.length; li++) {
          for (int i = li+1; i <a.length; i++)
              if (a[i] < a[li]) {
                  swap(a, li, i);
              }

      }
  
    }

    public static void insertionSort(int[] arr) {
        for(int i = 1;i<arr.length;i++)
        {
           for(int j =i-1;j>=0;j--)
           {
               if(isGreater(arr,j,j+1))
               {
                   swap(arr,j,j+1);
               }else{
                   break;
               }
           }
        }
      
    }

    public static void PartionAnArray(int[] arr,int data)
    {
           int p = -1 , itr = 0;
           while(itr<=arr.length-1)
           {
               if(arr[itr]<=data) swap(arr, itr,++p);
               itr++;
           }
    }

    public static void PartionOverPivot(int[] arr ,int pivotIdx)
    {
        int n = arr.length ; 
        swap(arr,pivotIdx,n-1);

        int itr = 0 , p = -1 , li = n-2;
        while(itr<=li)
        {
            if(arr[itr]<=arr[li]) swap(arr, itr, ++p);

            itr++;
        }

        // swap(arr,++p,li);

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
       int[] arr = {7,-2,4,1,3};
       int data = 3;
       PartionAnArray(arr, data);
       print(arr);
    }
}