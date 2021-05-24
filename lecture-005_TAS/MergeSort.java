import java.io.*;
import java.util.*;
public class MergeSort {
    
    public static int[] merge(int[] lh ,int[] rh ){

        int[] ans = new int[lh.length + rh.length];

        int i = 0, j=0,k=0;

        while(i<lh.length && j<rh.length)
        {
            if(lh[i]<rh[j]){
               ans[k++] = lh[i++];
            }else{
                ans[k++] = rh[j++];
            }
        }

        while(i<lh.length)
        {
            ans[k++] = lh[i++];
        }

        while(j<rh.length)
        {
            ans[k++] = rh[j++];
        }

        return ans;
    }

    public static int[] mergeSort(int[] arr , int si ,int ei){
     
       if(si==ei) {
           return new int[] { arr[si] };
       }

       int mid = (si+ei)/2;

      int[] lh = mergeSort(arr,si,mid);
      int[] rh =  mergeSort(arr, mid+1, ei);

      return merge(lh, rh);

    }

    public static void targetSumPair1(int[] arr , int target)
    {
       arr =  mergeSort(arr, 0, arr.length-1);

       int i = 0,j = arr.length-1;

       while(i<j)
       {
           if(arr[i] + arr[j] < target)
           {
               i++;
           }else if(arr[i] + arr[j] > target)
           {
             j--;
           }else{
               System.out.println(arr[i]+","+arr[j]);
               i++;
               j--;
           }
       }

    }

   

    public static void main(String[] args) {
        int[] arr = {1,-4,34,7,-5,0,1,2,4,-21,89,3};

       arr =mergeSort(arr, 0, arr.length-1);

        for(int e:arr)
        {
           System.out.print(e + " ");
        }
    }
}
