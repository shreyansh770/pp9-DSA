import java.util.*;

public class recursion_02 {
    
    public static void goldMine02(int[][] arr){

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
