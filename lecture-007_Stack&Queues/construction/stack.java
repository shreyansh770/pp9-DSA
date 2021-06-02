public class stack {
    private int[] arr;
    private int tos;// top of stack
    private int size;
    private int maxSize;

    private void initilize(int len) {
        this.arr = new int[len];
        this.tos = -1;
        this.size = 0;
        this.maxSize = len;
    }

    public stack() {
        
        initilize(5);
    }

    public stack(int size) {

        initilize(size);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = tos ; i >=0 ; i--)
        {
            sb.append(this.arr[i]);
            if(i!=0){
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }


    /*********************************************************/

    // infected funtion
    private void stackIsEmptyException() throws Exception {
        if (this.size == 0)
            throw new Exception("stackisEmptyException : -1");
    }

    private void stackOverFlowException() throws Exception {
        if (this.size == this.maxSize)
            throw new Exception("stackOverFlowException : -1");
    }

    /*********************************************************/

    //O(1)
    public int size() {
        return this.size;
    }

    //O(1)
    public boolean isEmpty() {
        return this.size == 0;
    }

    /*********************************************************/

    private void push_(int data) {
        this.arr[++this.tos] = data;
        this.size++;
    }

    //O(1)
    public void push(int data) throws Exception {
        stackOverFlowException();
        push_(data);
    }

    /*********************************************************/
    private int pop_() {
        int rv = this.arr[this.tos];
        this.arr[this.tos--] = 0;
        this.size--;
        return rv;
    }

    //O(1)
    public int pop() throws Exception {
        stackIsEmptyException();
        return pop_();
    }

    /*********************************************************/

    /*
     * top is also infected becoz it calls ->stackIsEmptyException(); any function
     * that will call top will also be infected
     */

    //O(1)
    public int top() throws Exception {
        stackIsEmptyException();
        return this.arr[this.tos];
    }

};