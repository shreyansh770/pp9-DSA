import java.util.*;
import java.io.*;
public class C {

    static int upper_bound(List<Integer> arr, int key)
    {
        int mid, N = arr.size();
  

        int low = 0;
        int high = N;
  

        while (low < high && low != N) {

            mid = low + (high - low) / 2;

            if (key >= arr.get(mid)) {
                low = mid + 1;
            }

            else {
                high = mid;
            }
        }
  

        if (low == N ) {
            return -1;     
        }
  

        return low;
    }
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int t = scn.nextInt();
            while(t-->0){

                int n = scn.nextInt();

                char c = scn.next().charAt(0);
                // char[] lights = scn.next().toCharArray();
                String s = scn.next();
                List<Integer> c_ = new ArrayList<>();
                List<Integer> g= new ArrayList<>();

                if(c=='g'){
                    System.out.println(0);
                }else{

                    int res = 0;
                    for(int i=0;i<n;i++){
                        
                        if(s.charAt(i)==c){
                            c_.add(i);
                        }else if(s.charAt(i)=='g'){
                               g.add(i);
                        }
                        
                    }

                    for(int i=0;i<c_.size();i++){

                        int idx = upper_bound(g, c_.get(i));
                        int val = (idx >=0 ? g.get(idx) : -1);
                        idx = val;
                        if(idx!=-1){
                            res = Math.max(res,idx-c_.get(i));
                        }else{
                            res = Math.max(res , (g.get(0)+1)+(n-1-c_.get(i)));
                        }
                    }
                    System.out.println(res);
                }

                

            }
    }
}
