import java.util.*;

public class HashMap {

    private class Node {
        Interger key = null;
        Integer value = null;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] Buckets; // array of linked list
    private int tNoofNodes = 0;
    private int bucketLen = 0;

    // Constructor================================

    private void intilize(int size) {
        Buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            Buckets[i] = new LinkedList<>();
        }

        this.tNoofNodes = 0;
    }

    HashMap() {
        intilize(10);
    }

    // Data Members====================================

    // Basic Functions=================================

    public int size() {

    }

    public boolean isEmpty() {

    }

    // Exception=======================================
    private void underFlowException() throws Exception {
        if (this.tNoofNodes == 0)
              throw new Exception("Hashmap UnderFlowException");
    }  
    // DS Function=====================================

    public void put(Integer key, Integer value) {

    }

    public Integer get(Integer key) {
        LinkedList<Node> node = getGroup(key);

        int gs = node.size();

        while (gs-- > 0) {
            if (node.getFirst().key == key) {
                break;
            }

            node.addLast(node.removeFirst());
        }

        return node.getFirst().value;

    }

    public Integer remove(Integer key) throws Exception{

        underFlowException();

        LinkedList<Node> node = getGroup(key);

        int gs = node.size();

        while (gs-- > 0) {
            if (node.getFirst().key == key) {
                LinkedList<Node> ans = node.removeFirst();
                break;

            }

            node.addLast(node.removeFirst());
        }

        return ans.value;
    }


    public Integer getOrDefault(Integer key , Integer defVal){
        if(constainKey(key)){
            return get(key);
        }else{
            return defVal;
        }
    }

    // unordered
    public boolean constainKey(Integer key) {

        LinkedList<Node> node = getGroup(key);

        int gs = node.size();
        boolean res = false;

        while (gs-- > 0) {
            if (node.getFirst().key == key) {
                res = true;
                break;
            }

            node.addLast(node.removeFirst());
        }

        return res;

    }

    public LinkedList<Node> getGroup(Integer key) {
        int hc = getHashCode(key);
        return Buckets[hc];
    }

    private int getHashCode(Interger key) {
        return Maths.abs(key.hashCode()) % bucketLen; // in built java hashCode generator
    }

}
