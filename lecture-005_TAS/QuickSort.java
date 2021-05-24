import java.util.*;
public class QuickSort {
    
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    public static int partitionOverPivot(int[] arr , int si,int ei,int pIdx)
    {
        swap(arr,pIdx,ei);// generic code ke liye

        int p = si - 1 , itr=si;
        while(itr<=ei)
        {
            if(arr[itr]<=arr[ei]) swap(arr, itr, ++p); //pIdx = ei

            itr++;
        }

        return p;
    }

    public static void quickSort(int[] arr , int si , int ei)
    {

        if(si>ei) return;

        int pIdx = ei;// we take last Index as pivot and then sort
        int p = partitionOverPivot(arr, si, ei, pIdx);
        quickSort(arr, si, p-1);
        quickSort(arr, p+1, ei);

    }

    public static int quickSelect(int[] arr , int si ,int ei,int k)
    {

        if(si >=ei) return 0;

        int pIdx = ei;// we take last Index as pivot and then sort
        int p = partitionOverPivot(arr, si, ei, pIdx);

        if(k == p) return arr[p];


        // pivot p<k call on the rigth half
        else if(p<k) return quickSelect(arr,p+1,ei,k);

        // else call on left half
        else return quickSelect(arr, si, p-1, k);
        
    }
    public static void main(String[] args) {
        int [] arr = {-12,2,7,4,34,23,0,1,-1,-50,16,23,7,4,2,3};
        quickSort(arr, 0, arr.length-1);
        for(int e : arr)
        {
            System.out.print(e + " ");
        }
    }
}
