import java.util.*;

public class q1{

    /// check if digit has repeated digit

    static int[] digitCount;
    public static int check(int n){
        HashSet<Integer> set = new HashSet<>();
        int rem ;
        while(n!=0){
            rem = n%10;

            if(set.contains(rem)) return 0;

            set.add(rem);
            n/=10;
        }

        return 1;
    }


    public static void main(String[] args) {
         
        Scanner scn = new Scanner(System.in);

        int l = scn.nextInt();
        int r = scn.nextInt();

        digitCount = new int[10001];

        digitCount[0] = 0;
        digitCount[1] = check(1);

        for(int i =2;i<=10000;i++){
            digitCount[i] = check(i) + digitCount[i-1];
        }

        int cnt = 0;

        cnt = digitCount[r] - digitCount[l-1];

        System.out.println(cnt);
    }
}