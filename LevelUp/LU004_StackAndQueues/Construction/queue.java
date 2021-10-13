
public class queue {
    private int[] arr;
    private int front;
    private int back;

    private int noOfEle;
    private int MaxCapacity;

    queue(int size) {
        initialize(size);
    }

    queue() {
        this(10);
    }

    protected void initialize(int size) {
        this.noOfEle = 0;
        this.MaxCapacity = size;
        this.arr = new int[this.MaxCapacity];
        this.front = this.back = 0;
    }

    /***********************************************/

    public int size() {
        return this.MaxCapacity;
    }

    public int capacity() {
        return this.noOfEle;
    }

    /************************************************ */

    public void displayQueue() {

        for(int i = 0;i<this.noOfEle;i++){
            int idx = (idx + this.front) %this.MaxCapacity;

            System.out.print(this.arr[i] + " ");
        }

    }

    /*************************************************/
    protected void stackIsEmptyException() throws Exception {

        if (this.noOfEle == 0) {
            throw new Exception("Queue Empty Exception");
        }
    }

    protected void stackOverFlowException() throws Exception {

        if (this.noOfEle == this.MaxCapacity) {
            throw new Exception("Queue OverFlow Exception");
        }
    }

    /**********************************************/

    private void push_(int num) {

        this.arr[this.back] = num;
        this.back = (this.back +1) % this.noOfEle;
        this.noOfEle++;
    }

    public void push(int num) throws Exception {

        stackOverFlowException();
        push_(num);

    }

    /***************************************** */
    private int peek_() {

        return this.arr[this.front];
    }

    public int peek() throws Exception {
        stackIsEmptyException();

        return peek_();
    }

    /***************************************** */
    private int pop_() {

        int val = this.arr[this.front];
        this.front = (this.front + 1)% noOfEle;
        this.noOfEle--;
        return val;

    }

    public int pop() throws Exception {
        stackIsEmptyException();
        return pop_();
    }

}