public class q5 {
    public boolean isUgly(int n) {
        
        if(n == 0 || n == 1) return n==1;
        
        if(n%2==0){
           return isUgly(n/2);
        }else if(n%3 == 0){
           return  isUgly(n/3);
        }else if(n%5==0){
            return isUgly(n/5);
        }else{
            return false;
        }
    }
}
