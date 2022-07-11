package oops.inheritance;

public class Boxweight extends Box {
    
    double weight ;

    public Boxweight(){
        this.weight=-1;
        // this.l=1; // private
    }

    public Boxweight(int l , int h  ,int w , int weight){
        super(l,h,w);
        this.weight = weight;
    }
}
