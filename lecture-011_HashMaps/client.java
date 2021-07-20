public class client {

    public static void test(){
        hashMap map = new hashMap();

        map.put(100, 1);
        map.put(200, 4);
        map.put(300, 1);
        map.remove(100);

        System.out.println(map.keySet());
    }

    public static void main(String[] args) {
        test();
    }
    
}
