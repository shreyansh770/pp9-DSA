import java.util.*;

// Meet in the middle is a search technique used when the input size is small but not small enough to use direct brute force.

public class F1006{

    static int[][] dir ={{0,1},{1,0}};




    public static int dfs(long[][] arr , int i,int j,long sum,long k){
        
        if(i == arr.length-1 && j == arr[0].length-1){
            if(sum  == k)  return 1;
            else return 0;
        }
       
        int count =0;
        for(int[] d : dir){
            int r =i +d[0];
            int c = j + d[1];

            if(r>=0 && c>=0 && r<arr.length && c<arr[0].length){
               count += dfs(arr, r, c, (sum ^ arr[r][c]) , k) ;
            }
        }
        
        return count;
    }
    

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();
        long k = scn.nextLong();

        long[][] arr= new long[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = scn.nextLong();
            }
        }

        int res = dfs(arr,0,0,arr[0][0],k);
        System.out.println(res);

        // bfs

        LinkedList<Integer> q = new LinkedList<>();

        q.addLast(0);
        boolean[] vis = new boolean[n*m];
        int sum = 0;
        while(q.size()!=0){

        }

    }
}