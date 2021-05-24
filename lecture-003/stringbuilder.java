import java.util.*;

public class stringbuilder {
    
   public static void stringbuilderFun(){
       StringBuilder sb = new StringBuilder();
       sb.append("a");
       sb.append("abc");
       System.out.println(sb.toString());
       sb.setCharAt(1, 'e');
       System.out.println(sb.toString());
       sb.deleteCharAt(2);
       System.out.println(sb.toString());

       System.out.println(sb.charAt(2));
   }

   public static void main(String[] args) {
    stringbuilderFun();
   }

}
