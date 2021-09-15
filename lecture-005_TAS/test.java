import java.util.*;
    /*
    
    // i ,j -> indexes to be swapped
    swap(int[] arr,int i ,int j){
          temp = arr[i] // stores the first element
          arr[i] = arr[j] // putting jth elemnt on ith index
          arr[j] = temp //  putting ith element on jth index
    }
    

    // pIdx index to be partitioned over
    partitionOverPivot(int[] arr , int si,int ei,int pIdx)
    {
        swap(arr,pIdx,ei);// to make the code generic so that it works for any pivot Index

        int p = si - 1 , itr=si;
        while(itr<=ei)
        {
            if(arr[itr]<=arr[ei]) swap(arr, itr, ++p); //pIdx = ei

            itr++;
        }

        return p;
    } 
    
    
    // ei - > ending index ,  si -> starting index
    quickSort(arr[], si, ei){
    
        
        if(si>ei) return;

        int pIdx = ei;// we take last Index as pivot and then sort
        int p = partitionOverPivot(arr, si, ei, pIdx);
        quickSort(arr, si, p-1); //  before p
        quickSort(arr, p+1, ei); // after p
    
   }
    
    
    
    */




public class test {




    // This is the function to swap 
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

    public static void algorithm(int[] arr){
        

        quickSort(arr,0,arr.length-1);

        for(int e : arr){
            System.out.print(e+" ");
        }
    }


    public static void main(String[] args) {
        
        int[] arr = {83,1,45,95,45,52,11,47,0,45,67,82};
        algorithm(arr);
    }
}
