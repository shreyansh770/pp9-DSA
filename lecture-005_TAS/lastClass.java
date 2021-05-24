import java.util.*;
public class lastClass {
    
    public static void swap(int[] arr,int i ,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int  partition(int[] arr ,int si,int ei,int pIdx)
    {
       swap(arr,pIdx,ei);

       int p = si-1,itr = si;

       while(itr<=ei)
       {
           if(arr[itr]<=arr[ei]) swap(arr,itr,++p);

           itr++;
       }

        return p;
    }

    public static void quickSort(int[] arr ,int si ,int ei)
    {
        if(si>=ei) return;

        int pIdx = ei;

        int p = partition(arr, si, ei, pIdx);

        quickSort(arr,si,p-1);
        quickSort(arr, p+1, ei);

    }


    public static void tripletTargSum(int[] arr ,int target)
    {
        quickSort(arr, 0, arr.length-1);

        int s ,e;
        
        for(int i =0;i<arr.length-2;i++)
        {
             s = i+1;
             e = arr.length-1;

            while(s<e)
            {
                if(arr[i]+arr[s]+arr[e] == target)
                {

                    System.out.println(arr[i] + " " + arr[s] + " " + arr[e]);
                    s++;
                    e--;
                }
                else if(arr[i]+arr[s]+arr[e] < target)
                {
                    s++;
                }else{
                    e--;
                }
            }
        }

        
    }

    public static void main(String[] args) {
        int[] arr = { -2, -3, 7, 5, 8, 15, 3, 2, 9, 10, 19 };


        tripletTargSum(arr, 25);
        
    }
}
