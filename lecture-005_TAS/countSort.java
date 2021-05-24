import java.util.*;


public class countSort {

    public static void countSortWithNegative(int[] arr, int ll, int ul) {
        int maxNum = -(int) 1e9;
        int minNum = (int) 1e9;
        
        for(int e : arr)
        {
            maxNum = Math.max(maxNum, e);
            minNum = Math.min(minNum, e);
        }

        int range = maxNum-minNum+1;
        int[] freq = new int[range];

        for(int ele : arr)
        {
            freq[ele + Math.abs(minNum)]++;
        }

        int idx = 0;
        for(int i = 0 ;i <range ;i++){
            while(freq[i]-- > 0)
            {
                arr[idx++] = i + minNum;
            }
        }
    }


    // 0 <= arr[i] <= 20 
    public static void countSort_(int[] arr)
    {
        int maxNum = -(int) 1e9;
        for(int e : arr)
        {
            maxNum = Math.max(maxNum, e);
        }

        int range = maxNum-0+1;//[0,20] = 20-0+1 nos
        int[] freq = new int[range];

        for(int ele : arr)
        {
            freq[ele]++;
        }

        int idx = 0;
        for(int i = 0 ;i <range ;i++){
            while(freq[i]-- > 0)
            {
                arr[idx++] = i;
            }
        }

    }
    
    public static void sortArrayWRecr(int[] arr,int i)
    {
        
    }
    
    
    public static void main(String[] args) {
        
    }
}
