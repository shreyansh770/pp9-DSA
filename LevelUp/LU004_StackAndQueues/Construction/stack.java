package Construction;
public class stack{
    private int[] arr;
    private int tos;

    private int noOfEle;
    private int MaxCapacity;

    stack(int size){
       initialize(size);
    }

    stack(){
        this(10);
    }


    protected void initialize(int size){
        this.noOfEle = 0;
        this.MaxCapacity = size;
        this.arr = new int[this.MaxCapacity];
        this.tos = -1;
    }

    /***********************************************/

    public int size(){
        return this.MaxCapacity;
    }

    public int capacity(){
        return this.noOfEle;
    }

    /************************************************ */

    public void displayStack(){
        for(int i=this.tos;i>=0;i--){
            System.out.print(this.arr[i]+ " ");
        }
    }

    /*************************************************/
    protected void stackIsEmptyException() throws Exception{

        if(this.noOfEle == 0){
            throw new Exception("Stack Empty Exception");
        }
    }

    protected void stackOverFlowException() throws Exception{

        if(this.noOfEle == this.MaxCapacity){
            throw new Exception("Stack OverFlow Exception");
        }
    }

    /**********************************************/

    private void push_(int num){

        this.arr[++this.tos] = num;
        this.noOfEle++;
    }

    public void push(int num) throws Exception{

          stackOverFlowException();
          push_(num);

    }

    /***************************************** */
    private int peek_(){

        return this.arr[this.tos];
    }

    public int peek() throws Exception{
         stackIsEmptyException();

         return peek_();
    }

    /***************************************** */
    private int pop_(){
          
        int val =  this.arr[this.tos--];
        this.noOfEle-- ;
        return val;

    }

    public int pop() throws Exception{
        stackIsEmptyException();
        return pop_();
    }


}