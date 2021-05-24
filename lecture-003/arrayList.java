import java.util.*;

public class arrayList {

    public static Scanner scn = new Scanner(System.in);

    public static void arrayListFun(){

      ArrayList<Integer> arr = new ArrayList<>();
      arr.add(10);
      arr.add(20);
      arr.add(30);

      for(Integer e : arr)
      System.out.println(e);
  

      System.out.println(arr.get(1));
      System.out.println(arr.size());
      arr.remove(2);
      System.out.println(arr);


    }


    // O(N*N)
    public static void removeData(ArrayList<Integer> arr , int d){

         for(Integer i=0 ; i<arr.size();i++){
             if(arr.get(i) == d){
                arr.remove(arr.get(i));
             }
         }

        System.out.println(arr);
    
    }

//     public static void removeDataO1(ArrayList<Integer> arr , int d){

      

//        System.out.println(arr);
//    }

    public static void main(String[] args) {
        // arrayListFun();

        ArrayList<Integer> arr = new ArrayList<>();

        int n = scn.nextInt();

        for(Integer i = 0 ; i < n ; i ++){
            int a = scn.nextInt();
            arr.add(a);
        }

        int data = scn.nextInt();

        removeData(arr, data);
    }
}
