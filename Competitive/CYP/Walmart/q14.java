import java.math.BigInteger;

public class q14 {
    

	static String max;
    public static String swap(String str,int i,int j){
           StringBuilder sb = new StringBuilder(str);
           sb.setCharAt(i, str.charAt(j));
           sb.setCharAt(j, str.charAt(i));
           return sb.toString();
    }	
	
	
	public static void findMaximum(String str, int k) {
        BigInteger n1 = new BigInteger(str); 
	     BigInteger n2 = new BigInteger(max);
        if(n1>n2){
               max = str;
        }

        if(k==0) return ;

        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(j)>str.charAt(i)){
                    str = swap(str,i,j);
                    findMaximum(str, k-1);
                    str = swap(str, i, j);
                }
            }
            
        }
		
	}


}
