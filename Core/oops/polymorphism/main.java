package oops.polymorphism;

public class main {
    public static void main(String[] args) {
        shapes s = new shapes();
        // circle c = new circle();
        shapes c = new circle(); // parrent ref , childs obj
        sqaure sq = new sqaure(); 
    
        c.area();
    }

}
