import java.util.*;

public class B651 {



    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> l = new HashSet();
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            // if(map.get(key)) 
            l.add(arr[i]);
        }

        int ans = 0;
        while (l.size() != 0) {

            int count = 0;
            for (int key  : map.keySet()) {
                if(!l.contains(key)) continue;
                map.put(key, map.getOrDefault(key, 0)-1);
                count++;
                if(map.get(key)==0) l.remove(key);
            }

            ans += count-1;
        }

        System.out.println(ans);

    }
}
