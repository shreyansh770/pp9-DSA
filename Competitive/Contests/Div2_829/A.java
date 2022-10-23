import java.util.*;
import java.io.*;
public class A{
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int t = scn.nextInt();

            while(t-->0){

                int n = scn.nextInt();

                char[] ch = scn.next().toCharArray();

 
               LinkedList<Character> s  =new LinkedList<>();

               boolean flag = true;
                for(char c : ch){

                   if(c=='Q') s.addFirst(c);
                   else {
                      if(s.size()!=0){
                          s.removeLast();
                      }
                   }
                }
                if(s.isEmpty()){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }

                
            }
    }
}