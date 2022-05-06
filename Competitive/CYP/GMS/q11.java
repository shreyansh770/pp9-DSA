import java.util.*;

class q11 {
    int[] findTwoElement(int arr[], int n) {
        // code here

        int[] ans = new int[2];
        // Arrays.sort(arr);
        // HashMap<Integer, Integer> map = new HashMap<>();
        int[] freq = new int[n+1];
        int mis = 1;
        int rep = 1;
        for (int i = 0; i < n; i++) {

            // map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            freq[arr[i]]++;
            if(freq[arr[i]]==2){
                rep = arr[i];
            }
        }

        for(int i=1;i<=n;i++){

            if(freq[i]==0){
                mis = i;
                break;
            }
        }

        ans[0] = rep;
        ans[1] = mis;
        return ans;
    } 
}
