import java.lang.reflect.Array;
import java.util.*;

public class l001 {

    public static void hashMap() {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 98);
        map.put("USA", 99);
        map.put("UK", 99);
        map.put("Pak", 0);

        // if the key is not present we get 'null'

        if (map.containsKey("Uk")) {
            System.out.println(map.get("Uk"));
        }

        // map.remove("UK");

        // System.out.println(map);

        ArrayList<String> keys = new ArrayList<>(map.keySet());

        System.out.println(keys);

        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }

    public static void charFreq(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        // for(int i=0;i<str.length();i++){

        // char ch = str.charAt(i);
        // if(!map.containsKey(ch)){
        // map.put(ch, 1);
        // }else{
        // int count = map.get(ch);
        // count++;
        // map.put(ch, count);
        // }
        // }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // getOrDefault(key,defaultValue) -> agr key nhi hai to default value ayegi nhi
            // to jo uski value hai
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(map);

    }

    public static void indexOfChar(String str) {

        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        // ArrayList<Integer> idx = new ArrayList<>();
        // for(int i=0;i<str.length();i++){
        // char ch = str.charAt(i);
        // if(!map.containsKey(ch)){
        // map.put(ch,new ArrayList<Integer>(Arrays.asList(i)));
        // }else{
        // idx = map.get(ch);
        // idx.add(i);
        // map.put(ch, idx);
        // }
        // }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }

        System.out.println(map);
    }

    public static void intersectionWoDup(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> a1 = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            if (!a1.containsKey(arr1[i]))
                a1.put(arr1[i], 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr2.length; i++) {

            if (a1.containsKey(arr2[i])) {

                a1.remove(arr2[i]);
                ans.add(arr2[i]);
            }
        }

        for (int e : ans) {
            System.out.println(e);
        }

    }

    public static void intersectionWDupExp(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for (int val : arr1) {
            if (fmap.containsKey(val)) {
                int of = fmap.get(val);
                int nf = of + 1;
                fmap.put(val, nf);
            } else {
                fmap.put(val, 1);
            }
        }

        for (int val : arr2) {
            if (fmap.containsKey(val) && fmap.get(val) > 0) {
                System.out.println(val);
                fmap.put(val, fmap.get(val) - 1);
            }
        }
    }

    public static void highestFreq(String str){
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int maxFreq = 0;
        char res = '\u0000'; //-> char ke liye null hai ye
        for(char ch : map.keySet()){
            if(map.get(ch) >  maxFreq){
                maxFreq = map.get(ch);
                res = ch;
            }
        }

        System.out.println(res);
    }

    public static void longestConsecutiveSequence(int[] arr){
        
        // hashset me sirf 'key' hoti hai
        HashSet<Integer> set = new HashSet<>();
        int len=0;
        int head = 0;

        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }

        for(int ele : arr){
            if(!set.contains(ele)) continue;

            int left = ele -1 , right = ele +1;
            set.remove(ele);

            while(set.contains(left)){
                set.remove(left--);
            }

            while(set.contains(right)){
                set.remove(right++);
            }

            if(right-left-1>len){
                len = right-left-1;
                head = left+1;
            }
            
        }


        for(int i=0;i<len;i++){
            System.out.println(head+i);
        }
    }


    public static void main(String[] args) {
        charFreq("aaabbccabc");

    }
}