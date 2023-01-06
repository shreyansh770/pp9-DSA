import java.util.*;
import java.io.*;
public class ques{
    public static List<List<Integer>> twoSum(int[] arr, int target) {
      
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();

        List<List<Integer>> res = new ArrayList<>(); 
        for(int num : arr){
            if(set.contains(target-num) && !seen.contains(num)){
                List<Integer> r = new ArrayList<>();
                r.add(num);
                r.add(target-num);
                res.add(r);
                seen.add(num);
                seen.add(target-num);
            }

            set.add(num);
        }
        
        return res;
    }
  
    // ~~~~~~~~~~Input Management~~~~~~~~~~
    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
      }
      int target = scn.nextInt();
      List<List<Integer>> res = twoSum(arr, target);
      ArrayList<String> finalResult = new ArrayList<>();
      for (List<Integer> list : res) {
        Collections.sort(list);
        String ans = "";
        for (int val : list) {
          ans += val + " ";
        }
        finalResult.add(ans);
      }
      Collections.sort(finalResult);
      for (String str : finalResult) {
        System.out.println(str);
      }
    }
}