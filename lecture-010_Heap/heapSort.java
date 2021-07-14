public class heapSort {

    public static int compareTo(int[] arr,int t, int o , boolean isInc) {
        if (isInc) {
            return arr[t] - arr[o];
        } else {
            return arr[o] - arr[t];
        }
    }


    public static int swap(int i , int j ){
        return i;
    }

    public static void downHeapify(int[] arr, int pi,int lidx ,boolean isInc) {
       
        int maxIdx = pi , lci = 2*pi+1 , rci = 2*pi+2;

        if(lci<=lidx && compareTo(arr, lci, maxIdx, isInc)>0){
               maxIdx = lci;
        }

        if(rci<=lidx && compareTo(arr, rci, maxIdx, isInc)>0){
            maxIdx = rci;
        }

        if(maxIdx!=pi){
            arr[maxIdx] =  swap(arr[pi], arr[pi] = arr[maxIdx]);
            downHeapify(arr, maxIdx, lidx, isInc);
        }


    }

    public static void heapSort(int arr[], boolean isInc) {
          
        int n = arr.length , lidx = n-1;
        for(int i = lidx;i>=0;i--){
            downHeapify(arr, i, lidx, isInc);
        }

        while(lidx>=0){
            arr[lidx] = swap(arr[0], arr[0] = arr[lidx]);
            downHeapify(arr, 0,  --lidx, isInc);
        }
    }

    public static void display(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1,2,-4,3,7,19,4};

        boolean isInc = false;

        heapSort(arr, isInc);
        display(arr);

    }
}
