import java.util.*;

public class heap {
      private ArrayList<Integer> arr;
      private int noOfEle = 0;
      private boolean isMaxHeap = true; // max heap

      private void initilize(boolean isMaxHeap) {
            this.arr = new ArrayList<>();
            this.noOfEle = 0;
            this.isMaxHeap = isMaxHeap;
      }

      /* Constructor ------------------------------- */

      // 1
      public heap(boolean isMaxHeap) {
            initilize(isMaxHeap);
      }

      // 2 ->default constructor
      public heap() {

            /* construction chaining */
            this(true); // this will call 1
      }

      // 3
      public heap(int[] data, boolean isMaxHeap) {
            /* construction chaining */

            // this() ->this will call 2
            this(isMaxHeap); // this will also call 1

            for (int ele : data) {
                  this.arr.add(ele);
            }
            this.noOfEle = this.arr.size();

            for (int i = this.noOfEle - 1; i >= 0; i--) { // NLogN -> N
                  downHeapify(i);
            }
      }

      /* Exceptions ------------------------------- */

      private void underFlowException() throws Exception {
            if (this.noOfEle == 0)
                  throw new Exception("Heap UnderFlowException");
      }

      /* Basic Functions ------------------------------- */

      public int size() {
            return this.noOfEle;
      }

      public boolean isEmpty() {
            return this.noOfEle == 0;
      }

      /* Main functionality ------------------------------- */

      // default max-Heap
      public int compareTo(int t, int o) {
            if (isMaxHeap) {
                  return this.arr.get(t) - this.arr.get(o);
            } else {
                  return this.arr.get(o) - this.arr.get(t);
            }
      }

      private void swap(int i, int j) {
            int e1 = this.arr.get(i);
            int e2 = this.arr.get(j);

            this.arr.set(i, e2);
            this.arr.set(j, e1);
      }

      // O(LogN)
      private void downHeapify(int pi) {
            int maxIdx = pi, lci = 2 * pi + 1, rci = 2 * pi + 2;
            if (lci < this.noOfEle && compareTo(lci, maxIdx) > 0)
                  maxIdx = lci;
            if (rci < this.noOfEle && compareTo(rci, maxIdx) > 0)
                  maxIdx = rci;

            if (maxIdx != pi) {
                  swap(pi, maxIdx);
                  downHeapify(maxIdx);
            }
      }

      // O(LogN)
      private void upheapify(int ci) {
            int pi = (ci - 1) / 2;
            if (pi >= 0 && compareTo(ci, pi) > 0) {
                  swap(ci, pi);
                  upheapify(pi);
            }
      }

      public int peek() throws Exception {

            underFlowException();

            return this.arr.get(0);
      }

      // log(n)
      public int remove() throws Exception {
            underFlowException();
            int rem = this.arr.get(0);
            swap(0, this.noOfEle - 1);
            this.arr.remove(this.noOfEle - 1);
            this.noOfEle--;
            downHeapify(0);

            return rem;
      }



      
      // O(LogN)
      public void add(int data) {
            this.arr.add(data);
            this.noOfEle++;
            upheapify(this.noOfEle - 1);
      }

}
