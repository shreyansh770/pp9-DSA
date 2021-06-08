public class dynamicStack extends stack{
 
    public dynamicStack(){
        super();
    }

    public dynamicStack(int size){
        super(size);
    }

    @Override
    public void push(int data) throws Exception{
        /* if super.fun()  is called than the function from parent class will be called*/
        /* super.push(data); -> this will call push from parent function*/

        if(super.size() == super.maxSize()){
            int[] temp = new int[super.size()];
            int idx = super.size()-1;
            while(super.size() != 0){
                  temp[idx--] = super.pop();
            }

            super.initilize(super.maxSize() * 2);

            for(int ele :temp) super.push(ele);
        }

        super.push(data);
    }

}
