import java.util.*;


public class recursion3{

    public static ArrayList<String> subsequence(String str){
        if(str.length() == 0 )
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> recAns = subsequence(str.substring(1));

        ArrayList<String> myAns = new ArrayList<>(recAns);
        for(String s : recAns)
        {
            myAns.add(ch +s);
        }

        return myAns;
    }


    public static ArrayList<String> decodeWaysRec(String str)
    {
        
       if(str.length() == 0)
       {
           ArrayList<String> base = new ArrayList<>();
           base.add("");
           return base;
       }

       if(str.charAt(0) == '0') return new ArrayList<>();

       char ch1 = str.charAt(0);
       ArrayList<String> myAns = new ArrayList<>();
       ArrayList<String> rec1LenAns = decodeWaysRec(str.substring(1));
       for(String s : rec1LenAns) {
           myAns.add((char)('a' + ch1 - 1 ) + s);
       }

       if(str.length() > 1)
       {
           int num = (ch1 - '0')*10+(str.charAt(1) - '0');
           if(num<=26)
           {
            ArrayList<String> rec2LenAns = decodeWaysRec(str.substring(2));
            for(String s : rec2LenAns) {
                myAns.add((char)('a' + num - 1 ) + s);
            }
           }
       }

      return myAns;
    }


    static String[] numCodes = {",;" , "abc" , "def" , "ghi" , "jkl", "mno", "pqrs", "tuv" , "wx" , "yz" , "+-*" , "?/%"};

      /* keypad + decode ways*/
    public static ArrayList<String> decodeWays2(String str)
    {  
        
        if(str.length() == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }


        char ch1 = str.charAt(0);
        
        ArrayList<String> myAns = new ArrayList<>();
        ArrayList<String> rec1Ans = decodeWays2(str.substring(1));
        
        String code = numCodes[ch1 - '0'];
         
        for(int  i = 0 ; i < code.length() ; i++)
        {
            char chCode = code.charAt(i);
            for(String e : rec1Ans)
            {
                myAns.add(chCode +e);
            }
        }

        if(str.length() > 1)
        {
            char ch2 = str.charAt(1);
            int num = (ch1 - '0')* 10 + (ch2-'0');//double digits num

            if(num == 10 || num==11)
            {
                ArrayList<String> rec2Ans = decodeWays2(str.substring(2));
                 code = numCodes[num];
                for(int  i = 0 ; i < code.length() ; i++)
                {
                    char chCode = code.charAt(i);
                    for(String e : rec2Ans)
                    {
                        myAns.add(chCode + e);
                    }
                }
            }
        }

       return myAns;  
    }


    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(decodeWays2(str));
    }
    
}
