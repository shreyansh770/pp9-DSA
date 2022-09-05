import java.util.*;
public class B1130 {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();

        int[] size = new int[2*n+1];

        HashMap<Integer,Integer> m1 = new HashMap<>();
        HashMap<Integer,Integer> m2 = new HashMap<>();

        for(int i=1;i<=2*n;i++){
            size[i]  =scn.nextInt();

            if(m1.containsKey(size[i])){
                m2.put(size[i], i);
            }else{
                m1.put(size[i], i);
            }
        }

        int sp = m1.get(1);
        int dp = m2.get(1);

        long ans = sp+dp-2;
        for(int i=2;i<=n;i++){

            int t1 = m1.get(i);
            int t2 = m2.get(i);

            if(Math.abs(sp-t1)+Math.abs(dp-t2) <Math.abs(sp-t2)+Math.abs(dp-t1)){
                    ans+=Math.abs(sp-t1)+Math.abs(dp-t2);
                    sp=t1;
                    dp= t2;
            }else{
               ans+= Math.abs(sp-t2)+Math.abs(dp-t1);
                sp = t2;
                dp = t1;
            }
        }

        System.out.println(ans);

    }
}
