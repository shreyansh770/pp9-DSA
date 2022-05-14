import java.util.*;

public class q15 {

    // here we have to figure out for a alphabet in string how many other alphabets
    // come before it
    // so we can allot a no of the alphabet that this many characters come before
    // you
    // and after printing all those alphabet you can be printed
    public String findOrder(String[] dict, int N, int K) {
        // Write your code here

        StringBuilder sb = new StringBuilder();

        int[] alphBefMe = new int[26];

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {

            String first = dict[i];
            String sec = dict[i + 1];

            int f = 0;
            int s = 0;

            while (f < first.length() && s < sec.length()) {

                char cf = first.charAt(f);
                char cs = sec.charAt(s);

                if (cf != cs) {
                    alphBefMe[cs - 'a']++;
                    graph.get(cf - 'a').add(cs - 'a');
                    break;
                }

                f++;
                s++;

            }

        }

        // topological sort

        LinkedList<Integer> q = new LinkedList<>();

        for(int i=0;i<K;i++){
            if(alphBefMe[i]==0) q.addLast(i);
        }

        while(q.size()!=0){

            int top = q.removeFirst();

            sb.append(top+'a'); // convert to char and then add

            for(int nbr : graph.get(top)){

                alphBefMe[nbr]--;

                if(alphBefMe[nbr]==0){
                    q.addLast(nbr);
                }
            }
        }

        return sb.toString();

    }
}
