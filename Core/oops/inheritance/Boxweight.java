package oops.inheritance;

public class Boxweight extends Box {
    
    double weight ;

    public Boxweight(){
        this.weight=-1;
        // this.l=1; // private
    }

    Boxweight(Boxweight other){
         // this will not throw an error cause syntactically this is
         // Box old = other // which is possible 
        super(other);
    }

    Boxweight(double l , double h  ,double w , double weight){
        super(l,h,w);
        this.weight = weight;
        //super(l,h,w); // error
    }
}
