public class recursion2{

    public static void printRevArr(int[] arr , int s)
    {
        if(s>arr.length-1) return;

        printRevArr(arr, s+1);
        System.out.println(arr[s]);

    }

    public static void printArrRecur(int[] arr, int s){
        if(s>arr.length-1) return;

        System.out.println(arr[s]);
        printArrRecur(arr, s+1);

    }

    public static int firstIndex(int[] arr , int s, int data)
    {
         if(arr[s] == data) return s;
        
        
        return firstIndex(arr ,s+1,data);
          
    }

   public static void main(String[] args) {
       int[] arr = {1,3,7,11,9,2,3,4,5,2,6,7,8};
    //    printRevArr(arr,0);
       System.out.println(firstIndex(arr, 0,2));
   }

}

