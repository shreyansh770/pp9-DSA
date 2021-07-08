import java.util.*;

public class Basic {

    public static Scanner scn = new Scanner(System.in);

    public static void Int_minPQ() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();// by default min priority queue
        for (int i = 10; i >= 1; i--)
            pq.add(i * 10);

        while (pq.size() != 0)
            System.out.println(pq.remove());
    }

    public static void Int_maxPq(){

        //this - other ->default behaviour
        //other - this ->opp. to default behaviour
        // a ->this->iske basis pe hoti hai comparison hmesha
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });//max PQ
        for (int i = 10; i >= 1; i--)
            pq.add(i * 10);

        while (pq.size() != 0)
            System.out.println(pq.remove());
    }

    public static void sortArrOnBasisOfCol(int[][] arr){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });

        for(int i=0;i<arr.length;i++){
           pq.add(arr[i]);
        }

        while(pq.size()!=0){
            int[] a = pq.remove();
            for(int e : a)
                  System.out.print(e+" ");
            System.out.println();
        }
       

    }

    public static class mobilePhone{
        String company = "";
        String model = "";
        int ram  = 0;
        int storage = 0;
        int batteryBackUp = 0;

         mobilePhone(String company , String model,int ram,int storage,int batteryBackUp){
             this.company = company;
             this.model = model;
             this.ram = ram;
             this.storage = storage;
             this.batteryBackUp = batteryBackUp;
         }

         mobilePhone(){

         }

         @Override
         public String toString(){
             StringBuilder sb = new StringBuilder();
             sb.append("Comapany: "+ this.company +"\n");
             sb.append("Model: "+ this.model +"\n");
             sb.append("rAM: "+ this.ram +"\n");
             sb.append("Storage: "+ this.storage +"\n");
             sb.append("Battery: "+ this.batteryBackUp +"\n");
             return sb.toString();
         }
    }

    public static void mobileDetails(){
    
        int n = scn.nextInt();

        PriorityQueue<mobilePhone> pq = new PriorityQueue<>((a,b)->{
            if(a.ram!=b.ram) return b.ram - a.ram;
            else if(a.storage != b.storage) return b.storage - a.storage;
            else return b.batteryBackUp - a.batteryBackUp;
        });

        for(int i=0;i<n;i++){
            pq.add(new mobilePhone(scn.next(), scn.next(), scn.nextInt(), scn.nextInt(), scn.nextInt()));
        }

        while(pq.size()!=0){
            System.out.println(pq.remove());
        }


    }

    public static void main(String[] args) {
        int[][] arr = {{1 ,7 ,2},
                       {3,4,5},
                       {-1,-1,5}
                      };
        
         mobileDetails();
        // sortArrOnBasisOfCol(arr);
    }

}