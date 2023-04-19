import java.util.*;

public class max_vac_days {


    public int solve(int start , int week , int[][] flights , int[][] days,int n,int k){

        if(week==k+1){
            return 0;
        }

        int ans = 0;
        int max = 0;
        for(int next=0;next<n;next++){

            if(flights[start][next]==1 && start!=next){
              ans+= solve(next, week+1, flights, days, next,k)+days[start][week];
              max = Math.max(ans,max);
            }
        }

        return max;
    }

    public int maxVacationDays(int[][] flights, int[][] days) {

        solve(0, 0, flights, days, 0, 0);
    
        return 8;
    }
    
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
    }
}
