public class q7 {

    public boolean isPos(int w , int[] weights , int days){

        int d=0;

        int sum=0;
        for(int i=0;i<weights.length;i++){
              
            if(weights[i]>w) return false;

            sum+=weights[i];

            if(sum>w){
                d++;
                sum=weights[i];
            }

            if(d>days) return false;
        }

        d++;
        return d<=days;
    }

    public int shipWithinDays(int[] weights, int days) {


        int si = 1;

        int sum = 0;
        for(int w : weights){
            sum+=w;
        }

        int ei = sum;

        int ans = -1;
        while(ei<=si){
            int mid = (si+ei)/2;

            if(isPos(mid, weights, days)){
                ans = mid;
                ei = mid-1;
            }else{
                si = mid+1;
            }

        }

        return ans;
    }
}
