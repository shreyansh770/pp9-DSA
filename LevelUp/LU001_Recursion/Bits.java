public class Bits {

    // 0 -> off/unset bit
    // 1 -> oN/set bit

    // 0->1 , 1->1 // true->true false->true // arr[idx] = true;
    // k position of bit
    // we start counting bit from behind
    public static void offToOn(int n, int k) {

        int mask = (1<<k);
        n |= mask;
        System.out.println(n);
    }

    // 0->0 , 1->0 //  arr[idx] = false;
    public static void onToOff(int n, int k) {
          
        int mask = (1<<k);
        n &= (~mask);
        System.out.println(n);
    }

    public static int countSetBits(int n){

        int count = 0;
        for(int i=0;i<32;i++){
            int mask = (1<<i); // 1 10 100 1000 ....
            if((n & mask)!=0) count++;
            
        }
        return count;
    }

    public static int countSetBits_02(int n){
        int count = 0;
        while(n!=0){
            if((n & 1)!=0) count++;
            n>>>=1;
        }

        return count;
    }

    public static int countSetBits_03(int n){
        int count = 0;
        while(n!=0){
            count++;
            n &= (n-1);
        }

        return count;
    }

    public boolean isPowerOfTwo(int n) {
        return n>0 && (n &(n-1)) == 0 ? true : false;
    }

    public boolean isPowerOfFour(int n) {
        if(n<=0 || (n &(n-1)) != 0 ) return false;
          
          int count = 0;
        while(n!=1){
            count++;
            n>>>=1;
        }
          
         return (count & 1) == 0;
    }

    public int missingNumber(int[] nums) {
        int ans = 0;
        int i=0;
        for(int ele: nums) {
            ans ^=ele;
            ans ^= i;
            i++;
        }
        
        return ans ^ i;
    }

    public int singleNumber(int[] nums) {
        
        int ans = 0;
        for(int ele : nums) ans ^= ele;
        return ans;
    }

    public int[] singleNumber_III(int[] nums) {
        int xor = 0;
        for(int ele : nums) xor ^= ele;
        int xor_mask = (xor) &(-xor);
        int A = 0 , B=0;
        for(int ele:nums){
            if((ele&xor_mask)!=0){
                A^=ele;
            }else{
                B^=ele;
            }
        }
        
        return new int[]{A,B};
    }



    // public static int missingNumber_02(int[] nums){

    // }
    
    public int reverseBits(int n) {
        var rev = 0;
            
        return rev;
    }

    public static void main(String[] args) {
        
         System.out.println(countSetBits_02(13));
    }
}
