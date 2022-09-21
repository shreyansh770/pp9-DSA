import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t  =scn.nextInt();

        while(t-->0){

            int n = scn.nextInt();
            int x = scn.nextInt();
            int y = scn.nextInt();

            if(x>0 && y>0 || x==0 && y==0){
                System.out.println(-1);
            }else{

                int X = Math.max(x,y);
                int Y = Math.min(x,y);

                if((n-1)%X!=0){
                    System.out.println(-1);
                }else{

                    int win = 1;

                    int matches = 0;
                    for(int i=0;i<n-1;i++){
                        if(matches == X){
                            win = i+2;
                            matches = 0;
                        }
                        matches++;
                        System.out.print(win+" ");
                    }

                    System.out.println();
                }

            }
        }
    }
}
