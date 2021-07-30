import java.util.*;

public class recursion_02 {
    
    static int getGold(int[][] M , int sr , int sc , int  n , int m , int[][] dir){
        
        int gold = 0;
        int val = M[sr][sc];
        for(int[] d: dir){
            int r = sr + d[0];
            int c = sc + d[1];
            
            
            if(r>=0 && c>=0 && r<n && c<m){
                int rval = getGold(M , r, c ,n , m , dir);
                
                if(rval > gold) gold = rval;
            }
        }
        
        return gold + val;
    }
    
    static int maxGold(int n, int m, int M[][])
    {
        
        int[][] dir = {{0,1},{1,1},{-1,1}};
        int gold = 0;
        
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                
                int ans = getGold(M , i , j , n , m,dir);
                if(ans>gold) gold = ans;
            }
        }
        return gold;
    }

	public static boolean isPalindrome(String str) {
		int i =  0 , j = str.length() - 1;
		while(i < j) {
			char ith = str.charAt(i);
			char jth = str.charAt(j);
			if(ith != jth) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

    public static void allPalindromicSubsequence(String str,String ans){
        
        if(str.length() == 0 && isPalindrome(ans)){
            System.out.println(ans);
            return;
        }


        for(int i=0;i<str.length();i++){
            String ros = str.substring(0,i) + str.substring(i+1);
             allPalindromicSubsequence(ros,ans+str.charAt(i));
        }
    }

    public static void palindromicPartion(String str , String asf){

        if(str.length() == 0){
            System.out.println(asf);
            return;
        }  

        for(int i=0;i<str.length();i++){

            String palin = str.substring(0, i+1);// first call me ek char second me 2 char ans so on

            String ros = str.substring(i+1);

            if(isPalindrome(palin)){
                palindromicPartion(ros,asf + palin);
            }
        }
         

    }

    public static void main(String[] args){
        
    }
}
