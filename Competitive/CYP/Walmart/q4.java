public class q4 {

    static int[][] dir = {{1,0},{0,1}};
 
    public static int rec(int sr , int sc ,int a , int b){

        if(sr==a-1 && sc==b-1) return 1;

        int count = 0;
        for(int[] d : dir){
            int x = sr + d[0];
            int y = sc + d[1];

            if(x>=0 && y>=0 && x<a && y<b){
                count+=rec(x,y,a,b);
            }
        }

        return count;
    }

    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        return rec(0,0,a,b);
    }
}
