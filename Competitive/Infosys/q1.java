import java.util.*;


public class q1 {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int e = scn.nextInt();
        int n = scn.nextInt();
        Integer[] arr = new Integer[n];

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0;i<n;i++){
            arr[i]  =scn.nextInt();
            map.put(i,0);
        }

        Arrays.sort(arr,Collections.reverseOrder());


         int idx = 0;
         int exc = 0;
         boolean done =false;
         while(map.size() > 0 && e>0){

            int ex = arr[idx];

            map.put(idx , map.getOrDefault(idx, 0)+1);

            if(map.get(idx)>2){
                map.remove(idx);
                idx++; // we cannot perform this exercise
            }else{
                e-=ex;
                exc++;
                if(e<=0) {
                    done = true;
                    break;
                }
            }

         }


        //  return (done==true ? exc ? -1);
        if(done || e<=0){
            System.out.println(exc);
        }else{
            System.out.println(-1);
        }



         


    }
}
