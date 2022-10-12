import java.util.*;

public class D {

    static int count = 0;
    public static int merge(int[] a , int l , int r , int mid){

        int n1 = mid-l+1;
        int n2 = r-mid;
        int[] L = new int[mid-l+1];
        int[] R = new int[r-mid];

        for(int i=0;i<mid-l+1;i++){
            L[i] = a[l+i];
        }

        for(int i=0;i<r-mid;i++){
            R[i] = a[mid+1+i];
        }

        int i=0;
        int j = 0;

        int k = 0;
        boolean flag = true;
        while(i<n1 && j<n2){

            if(L[i]<=R[i]){
                a[k++] = L[i];
                i++;
            }else{
                if(i>0) {flag=false;break;}
                a[k++] = R[j];
                j++;
            }
        }

        if(!flag) return -1;
        while(i<n1){
            a[k++] = L[i++];
        }

        while(j<n2){
            a[k++] = R[j++];
        }


        return 1;
    }

    public static int mergeSort(int[] a, int l, int r) {

        if (l < r) {

            int mid = (l + r) / 2;

            int lr = mergeSort(a, l, mid);
            int rl = mergeSort(a, mid + 1, r);

            if (lr == -1 || rl == -1)
                return -1;
            int res = merge(a, l, r, mid);
            if (res == -1)
                return -1;
            else count++;
        }

        return l>r ? -1: 1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while (t-- > 0) {

            int m = scn.nextInt();

            int[] p = new int[m];
            for (int i = 0; i < m; i++) {
                p[i] = scn.nextInt();
            }

            int ans = mergeSort(p, 0,m-1);

            if(ans==-1){
                System.out.println(-1);
            }else{
                System.out.println(count);
            }
        }

    }
}