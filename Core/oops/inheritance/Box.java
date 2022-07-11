package oops.inheritance;

public class Box {
   private double l;
    double w;
    double h;

    Box() {
        this.l = -1;
        this.w = -1;
        this.h = -1;
    }

    Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    Box(Box old){
        this.h = old.h;
        this.w = old.w;
        this.h = old.h;
    }


    public void info(){
        System.out.println("Running the box");
    }


}