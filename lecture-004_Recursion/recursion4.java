

//Recursion on the way up
public class recursion4 {
    

    public static void printStairPaths(int n, String path) {
        
        if(n==0)
        {
            System.out.println(path);
            return;
        }
        
        if(n<0) return;
        
        printStairPaths(n-1,path + 1);
        printStairPaths(n-2,path + 2);
        printStairPaths(n-3,path + 3);
        
    }

    public static void printSS(String str, String ans) {
        
        if(str.length() == 0 )
        {
            System.out.println(ans);
            return ; 
        }
        
        char ch = str.charAt(0);
        
        printSS(str.substring(1) , ans + ch);
        printSS(str.substring(1) , ans);
        
        
    }


    static String[] numCodes = {".;" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tu" , "vwx" , "yz"};

    public static void printKPC(String str, String asf) {
        if(str.length() == 0 )
        {
            System.out.println(asf);
            return;
        }
        
        char ch = str.charAt(0);
        String code = numCodes[ch - '0'];
        
        for(int i = 0 ; i < code.length() ; i++){
            printKPC(str.substring(1) , asf + code.charAt(i));
        }
    }

    public static void permutation(String str , String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return;
        }

        for(int i = 0 ; i <str.length() ; i++)
        {
            String ros = str.substring(0,i) + str.substring(i+1);
            permutation(ros, ans + str.charAt(i));
        }


    }


    public static void permutationWoRep(String str , String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return;
        }


        /*******************************************/

        // SORTING THE STRING(str);

        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];

        for(int  i = 0; i <str.length() ; i++){
            freq[str.charAt(i) - 'a']++;
        }

        for(int i=0;i<26;i++)
        {
            for(int j = 0 ; j <freq[i];j++)
            {
                sb.append((char)(i + 'a'));
            }
        }

        String s = sb.toString();

        /*******************************************/

        char pre = '$';

        for(int i = 0 ; i <s.length() ; i++)
        {
            
            if(pre != s.charAt(i)) 
            {
              String ros = s.substring(0,i) + s.substring(i+1);
              permutationWoRep(ros, ans + s.charAt(i));
            }

            pre = s.charAt(i);
        }

    }
    

    public static void decodeWays(String str , String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        if(ch == '0')
        {
            return;
        }

        decodeWays(str.substring(1), ans+(char)('a'+ ch - '1'));

        if(str.length() >1)
        {
            int num = (ch - '0')*10+(str.charAt(1) - '0');
            if(num<=26)
            {
                decodeWays(str.substring(2),ans+(char)('a'+ num - 1));
            }
        }
    }


    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
         
        // int n  = scn.nextInt();

        // String str = scn.next();
        // printKPC(str , "");
        
        // printStairPaths(n , "");

        permutation("aabc", "");

        // permutationWoRep("aabc","");
        // decodeWays("112043", "");
    }
}
