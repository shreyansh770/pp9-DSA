import java.util.*;


public class D1324 {



    public static void main(String[] args) {

        Scanner fs = new Scanner(System.in);

        int n = fs.nextInt();

        long[] a = new long[n];
        long[] b = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = fs.nextLong();
        }

        Long[] c = new Long[n];
        for (int i = 0; i < n; i++) {
            b[i] = fs.nextLong();
            c[i] = a[i] - b[i];
        }


        // we have to maintain (ai-bi) > (aj-bj)

        Arrays.sort(c);
        long res = 0;
        int l = 0;
        int r = n-1;
        while(l<r){
			if ((c[r]+c[l])>0) {
				res+=r-l;
				--r;
			}
			else{
				++l;
			}
		}

        System.out.println(res);

    }
}