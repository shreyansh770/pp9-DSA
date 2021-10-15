import java.util.ArrayList;
public class heap{
    private ArrayList<Integer> arr;
    private int size = 0;
    boolean isMax;

    public heap(boolean isMax){
        this.arr = new ArrayList<>();
        this.isMax = isMax;
    }

    // n + nlog(n) -> O(N)[Mathmatical Proof]
    public heap(int[] arr , boolean isMax){

        this(isMax);
        for(int ele : arr) this.arr.add(ele);

        for (int i = this.arr.size() - 1; i >= 0; i--)
            downHeapify(i);
    }

    public int size() {
        return this.arr.size();
    }

    public boolean compareTo(int x , int y){
      if(isMax)
          return  this.arr.get(x) > this.arr.get(y);
      else
         return  this.arr.get(y) > this.arr.get(x);
    }

    private void swap(int x , int y){
        int v1 = this.arr.get(x);
        int v2 = this.arr.get(y);

        this.arr.set(x,v2);
        this.arr.set(y,v1);
    }

    // parent elemet -> child index
    private void downHeapify(int pi){
        int lci = 2*pi +1;
        int rci = 2*pi +2;
        int mi = pi;

        if(lci < arr.size() && compareTo(lci, mi)){
             mi = lci;
        }

        if(rci < arr.size() && compareTo(rci, mi)){
            mi = rci;
        }

        if(pi !=mi){
            swap(mi , pi);
            downHeapify(mi);
        }
    }

    private void upHeapify(int ci){

        int pi = (ci -1)/2;

        if(pi>=0 && compareTo(ci, pi)){
            swap(ci, pi);
            upHeapify(pi);
        }

    }


    //Log(n)
    public int remove(){
        int re = this.arr.get(0);
        swap(0 , this.arr.size()-1);
        this.arr.remove(this.arr.size()-1);
        downHeapify(0);
        return re;

    }


    //log(n)
    public void add(int data){

        this.arr.add(data);
        upHeapify(this.arr.size() - 1);
    }


    //Log(n)
    public int peek(){
        return this.arr.get(0);
    }

}