import java.util.*;

public class C978 {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        long[] no_of_rooms = new long[n];
        for(int i=0;i<n;i++){
            no_of_rooms[i] = scn.nextLong();
        }

        long[] room_no = new long[m];
        long[] pre = new long[n];

        for(int i=0;i<m;i++){
            room_no[i] = scn.nextLong();
        }

        pre[0] = no_of_rooms[0];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + no_of_rooms[i];
        }

        // mlogn
        // finding the dometry in which room will lie

        for(long ri : room_no){

            int si = 0;
            int ei = n-1;

            int d_id = 0;
            while(si<=ei){

                int mid = (si+ei)/2;

                if(pre[mid]<ri){
                   si = mid+1;
                }else{
                    d_id = mid;
                    ei = mid-1;
                }
            }

            // cal ans
            if(d_id==0){

                System.out.print(d_id+1+" "+ri );
            }else{

                long norb = ri - pre[d_id-1];
                System.out.print(d_id+1 + " " + norb);
            }

            System.out.println();

        }

    }
}
