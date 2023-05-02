import java.util.*;

public class SOE {

    // soe
    public static void soe(int n) {

        boolean[] num = new boolean[n + 1];

        for (int i = 2; i * i <= n; i++) {

            if (num[i]) {

                for (int j = i * i; j <= n; j += i) {
                    num[i] = false;
                }
            }
        }

        for (int i = 0; i < n; i++) {

            if (num[i])
                System.out.println(num[i]); // prime numbers
        }

    }

    // prime factors using soe
    public static List<Integer> getPrimeFactors(int num) {

        int[] spf = new int[num + 1]; // smallest prime factors for all numbers till n

        for (int i = 0; i <= num; i++) {

            spf[i] = i; // intially smallest pf of i =i
        }

        for (int i = 2; i * i <= num; i++) {

            if (spf[i] == i) {

                for (int j = i * i; j <= num; j += i) {
                    if (spf[j] == j)
                        spf[j] = i;
                }
            }

        }

        List<Integer> primeFactors = new ArrayList<>();

        while (num != 1) {

            primeFactors.add(spf[num]);

            num = num / spf[num];
        }

        return primeFactors;

    }

    // segemented soe : find number of primes numbers in the range

    static boolean[] prime;
    static int n = 1000000;

    public static void sieve() {

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[i] = true;
                }
            }
        }

    }

    public static List<Integer> genratePrimes(int r) {

        List<Integer> pn = new ArrayList<>();

        for (int i = 2; i <= n; i++) {

            if (!prime[i])
                pn.add(i);
        }

        return pn;

    }

    public static void segementedSeive(int l, int r) {

        int len = r-l+1;

        // step 1 : generate all prime till sqrt(r)
        List<Integer> pn = genratePrimes((int)Math.sqrt(r));

        // step2 : make a dummy array
        int[] arr = new int[len];
        Arrays.fill(arr,1);

        // step3 : for all primes numbers in pn mark its multiple as false

        for(int i =0;i<pn.size();i++){

            int pr = pn.get(i);

            int firstMultiple = (l/pr)*pr; // first multiple of that prime number in range [l,r]
            if(firstMultiple<l) firstMultiple+=pr;
            for(int j=Math.max(pr*pr,firstMultiple);j<=r;j+=pr){
                int dummyIdx = j-l;
                arr[dummyIdx] = 0;

            }
        }

        for(int i=l;i<=r;i++){

            if(arr[i]==1){
                 System.out.println(i); // prime number
            }
        }
       


    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int l = scn.nextInt();
        int r = scn.nextInt();
        prime = new boolean[n + 1];
        sieve();
    }
}
