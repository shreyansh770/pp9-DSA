public class queue {
    private int[] arr;
    private int maxSize;
    private int size;
    private int front;
    private int back;

    private void initialize(int len)
    {
        this.arr= new int[len];
        this.front = 0;
        this.back = 0;
        this.size = 0;
        this.maxSize = len;
    }

    public queue(){
      initialize(5);
    }

    public queue(int size){
        initialize(size);
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < this.size ; i++)
        {
            int idx = (i+this.front) % this.maxSize;
            sb.append(this.arr[idx]);
            if(i != this.size-1) sb.append(", ");
        }

        sb.append("]");

        return sb.toString();
    }



    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void queueIsOverflowException() throws Exception{
        if(this.size == this.maxSize){
            throw new Exception("queueIsOverflowException : -1");
        }
    }

    public void queueIsEmptyException() throws Exception{
        if(this.size == 0){
            throw new Exception("stackIsEmptyException : -1");
        }
    }


    private void add_(int data){
         this.arr[this.back] = data;
         this.back = (this.back + 1) % this.maxSize;
         this.size++;
    }

    public void add(int data) throws Exception{
        queueIsOverflowException();
        add_(data);
    }

    public int peek() throws Exception{
        queueIsEmptyException();
        return this.arr[this.front];
    }


    private int remove_(){
       int rv = this.arr[this.front];
       this.arr[this.front] = 0;
       this.front = (this.front + 1) % this.maxSize;
       this.size--;
       return rv;
    }

    public int remove() throws Exception{
        queueIsEmptyException();
        return remove_();
    }


}
