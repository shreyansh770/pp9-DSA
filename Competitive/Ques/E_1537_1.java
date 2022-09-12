import java.util.*;


public class E_1537_1{

    public static String help(String s , int k){

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(sb.length()<k){

            sb.append(s.charAt(i));
            i++;
            i%=s.length();
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        String s = scn.next();
        ArrayList<String> sub = new ArrayList<>();

        for(int i=0;i<n;i++){
            sub.add(s.substring(0,i+1));
        }

        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(help(sub.get(i), k));
           
        }

        Collections.sort(res);   

        System.out.println(res.get(0));

    }
}