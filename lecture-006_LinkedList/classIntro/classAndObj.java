public class classAndObj {

    public static class phone {
        String brand;
        String model;
        String color;
        int ram;
        int storage;
        int battery;

        phone(String brand, String model, String color, int ram, int storage, int battery) {
            this.brand = brand;
            this.model = model;
            this.color = color;
            this.ram = ram;
            this.storage = storage;
            this.battery = battery;
        }

        // constructor overloading
        //@Override // -> this will tell the program our intentions ->this will reduce the
                  // probablity of mistake in constructor overriding
        phone(String brand, String model, String color, int storage, int battery) {
            this.brand = brand;
            this.model = model;
            this.color = color;
            this.storage = storage;
            this.battery = battery;
        }

    }

    public static void main(String[] args) {

        phone ph1 = new phone("iphone", "X Pro", "Black", 16, 128, 10000);

        // ph1 will be created on the stack that will store the address of the object
        // that will be formed on the heap

        // System.out.println(ph1); ->address "this" will also have the same address
    }

}