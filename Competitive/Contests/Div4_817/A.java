import java.util.*;

public class A{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while(t-->0){
            int n = scn.nextInt();
            String s  =scn.next();

            HashSet<Character> set = new HashSet<>();

            if(n!=5){
                System.out.println("NO");
            }else{

                String check = "Timur";

                for(int i=0;i<5;i++){
                    char ch = check.charAt(i);
                    set.add(ch);
                }

                boolean flag = true;
                for(int i=0;i<5;i++){
                    char ch = s.charAt(i);
                    
                    if(ch=='t' || ch=='I' || ch == 'M' || ch == 'U' || ch=='R'){
                        // System.out.println("NO");
                        flag = false;
                        break;
                    }else{
                        if(set.contains(ch)){
                             set.remove(ch);
                        }
                    }
                }

                if(flag && set.size()==0) System.out.println("YES");
                else {
                    System.out.println("NO");
                }
            }

        }
    }
}