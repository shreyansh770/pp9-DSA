import java.util.*;

public class A1276 {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        int t  =scn.nextInt();

        while(t-->0){

            String str = scn.next();

            
            // now only three types of string will create problem for us

            // {one , two , twone} 
            // for one remove 'n'
            // for two remove 'w'
            // for twone remove 'o'\
            int cnt = 0;
            StringBuilder res = new StringBuilder();
			for (int i=0;i<str.length();)
			{
				if (i+5<=str.length() && str.substring(i,i+5).equals("twone"))
				{
					res.append((i+3)+" ");
					cnt++;
					i=i+5;
				}
				else if (i+3<=str.length() && (str.substring(i , i+3).equals("one")||str.substring(i , i+3).equals("two")))
				{
					res.append((i+2)+" ");
					cnt++;
					i = i+3;
				}
				else
				i++;
			}
			System.out.println(cnt);
			System.out.println(res);
        }
    }
}
