public class q15 {
    public int divide(int d, int div) {
        if (d == 1 << 31 && div == -1) return (1 << 31) - 1;
        return (int)Math.ceil(d/div);
    }


        //https://leetcode.com/problems/divide-two-integers/discuss/1516367/Complete-Thinking-Process-or-Intuitive-Explanation-or-All-rules-followed-or-C%2B%2B-code
    
        public int divide_(int d, int div) {
    
            if(d==div) return 1;
            
             if (d == 1 << 31 && div == -1) return (1 << 31) - 1;
            
            boolean isPos = (d<0 == div<0); // both are of same sign ans will be positive
            
            int a = Math.abs(d);
            int b = Math.abs(div);
            
            int ans = 0;
            
            while(a>=b){
                
                int q = 0;
                
                while(a > (b<<(q+1)))
                    q++;
                
                
                ans +=(1<<q);
                
                a = a - (b<<q);
                
            }
            
            if(ans == (1<<31) && isPos) return Integer.MAX_VALUE;
            
            return isPos ? ans : -ans;
        }
}
