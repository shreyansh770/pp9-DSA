import java.util.*;

public class unionFind {

    int[] par; // leader
    int[] size;

    public int findPar(int u) {
        if (par[u] == u) {
            return u;
        }

        int ans = findPar(par[u]);

        par[u] = ans;

        return ans;
    }

    // merging on the basis of size
    // component with greater size will become parent
    public void merge(int p1, int p2) {

        if (size[p1] < size[p2]) {
            par[p1] = p2;
            size[p2] = size[p1] + size[p2];
        } else {
            par[p2] = p1;
            size[p1] = size[p2] + size[p1];
        }
    }

    public int union_find(int n, int[][] edges) {

        par = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int p1 = findPar(u);
            int p2 = findPar(v);

            if (p1 != p2) {
                merge(p1, p2);// joining possible disjoint sets
            }
        }

        int no_of_components = 0;

        for (int i = 0; i < n; i++) {
            int p = findPar(i);
            if (i == p) {
                no_of_components++;
            }
        }

        return no_of_components;

    }

    // 684

    // int[] par; // leader
    // int[] size;

    public int findPar_(int u) {
        if (par[u] == u) {
            return u;
        }

        int ans = findPar(par[u]);

        par[u] = ans;

        return ans;
    }

    public void merge_(int p1, int p2) {

        if (size[p1] < size[p2]) {
            par[p1] = p2;
            size[p2] = size[p1] + size[p2];
        } else {
            par[p2] = p1;
            size[p1] = size[p2] + size[p1];
        }
    }

    // find the edge which we can break to form disjoint sets or where the edge
    // forms a cycle
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i < n; i++) {
            par[i] = i;
            size[i] = 1;
        }

        int[] ans = new int[2];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int p1 = findPar_(u);
            int p2 = findPar_(v);

            if (p1 == p2) {
                ans[0] = u;
                ans[1] = v;
            }

            if (p1 != p2) {
                merge_(p1, p2);
            }
        }

        return ans;

    }

    // 1319
    // no of edges should be atleast noc-1
    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1)
            return -1;

        par = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
            size[i] = 1;
        }

        for (int[] e : connections) {

            int p1 = findPar(e[0]);
            int p2 = findPar(e[1]);

            if (p1 != p2) {
                merge(p1, p2);
            }
        }

        int comp = 0;

        for (int i = 0; i < n; i++) {
            int p = findPar(i);
            if (p == i)
                comp++;
        }

        return comp - 1;

    }

    // 1601

    // here we will make component with the characters of s and t with parent being
    // lexigraphically smallest character among them
    // after forming these components we will find the best equivalce for str
    public String smallestString(String s, String t, String str) {

        par = new int[26];

        for (int i = 0; i < 26; i++) {
            par[i] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            int v = t.charAt(i) - 'a';

            int p1 = findPar(u);
            int p2 = findPar(v);

            // merging
            if (p1 != p2) {
                // make lexiographically smallest the parent
                par[p1] = Math.min(p1, p2);
                par[p2] = Math.min(p1, p2);
            }

        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int u = str.charAt(i) - 'a';

            int p = findPar(u);
            char ch = (char) ('a' + p);
            res.append(ch);
        }

        return res.toString();

    }

    // 695

    public int maxAreaOfIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        par = new int[n * m];
        size = new int[n * m];

        for (int i = 0; i < n * m; i++) {
            par[i] = i;
            int x = i / m;
            int y = i % m;
            if (grid[x][y] == 1) {
                size[i] = 1;
            }

        }
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {

                    int p1 = findPar(i * m + j);

                    for (int[] d : dir) {
                        int r = i + d[0];
                        int c = j + d[1];

                        if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1) {
                            int p2 = findPar(r * m + c);

                            // here we are always making p1 the parent of p2
                            if (p1 != p2) {
                                par[p2] = p1;
                                size[p1] += size[p2];
                            }
                        }
                    }
                }
            }
        }

        int area = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int p = findPar(i * m + j);
                if (p == i * m + j) {
                    area = Math.max(area, size[i * m + j]);
                }
            }
        }

        return area;

    }

    // 990

    int findPar02(int u) {
        if (par[u] == u)
            return u;

        return par[u] = findPar02(par[u]);
    }

    public boolean equationsPossible(String[] equations) {
        par = new int[26];

        for (int i = 0; i < 26; i++) {
            par[i] = i;
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int p1 = findPar02(eq.charAt(0) - 'a');
                int p2 = findPar02(eq.charAt(3) - 'a');

                if (p1 != p2) {
                    par[p1] = p2;
                }
            }

        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int p1 = findPar02(eq.charAt(0) - 'a');
                int p2 = findPar02(eq.charAt(3) - 'a');

                if (p1 == p2) {
                    return false;
                }
            }

        }
        return true;
    }

    // 1202

    public void descOrder(char[] s) {
        Arrays.sort(s);
        reverse(s);
    }

    public void reverse(char[] a) {
        int i, n = a.length;
        char t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();

        par = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        for (List<Integer> p : pairs) {
            int p1 = findPar(p.get(0));
            int p2 = findPar(p.get(1));

            if (p1 != p2) {

                par[p1] = p2;
            }
        }

        HashMap<Integer, String> map = new HashMap<>(); // here we are keeping the index(par) and characters that can be
                                                        // placed at that index

        // storing all the possible characters that can come at p
        for (int i = 0; i < n; i++) {
            int p = findPar(i);
            if (map.containsKey(p)) {
                map.put(p, map.get(p) + s.charAt(i)); // if parent is already present add the new chara

            } else {
                map.put(p, "");
                map.put(p, map.get(p) + s.charAt(i));

            }
        }

        // here because we want our end string to be lexiographically smallest
        // we are sorting it and reversing (bcoz we want to out smallest ch to be in the
        // end so that once we have used it we can remove it so that we wont use it
        // again)
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            char[] ch = entry.getValue().toCharArray();
            descOrder(ch);
            String res = new String(ch);

            map.put(entry.getKey(), res);
        }

        // sb to store the final string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int p = findPar(i);

            String res = map.get(p);
            sb.append(res.charAt(res.length() - 1)); // apppending the smallest character possible a
            StringBuilder nw = new StringBuilder(res);
            nw.deleteCharAt(nw.length() - 1); // removing the used character
            map.put(p, nw.toString());
        }

        return sb.toString();

    }

    // 721
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        HashMap<String, Integer> euid = new HashMap<>(); // email vs unique id
        HashMap<String, String> etn = new HashMap<>(); // email vs name

        par = new int[10001]; // 1000 names * 10 email id with each name
        for (int i = 0; i <= 10000; i++) {
            par[i] = i;
        }

        int uid = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {

                String email = account.get(i);

                if (!euid.containsKey(email)) {
                    euid.put(email, uid);
                    uid++;
                }

                etn.put(email, name);

                // the first email(p1) will be the parent of all other emails in the group
                // which will imply that they belong to the same group
                int p1 = findPar(euid.get(account.get(1)));
                int p2 = findPar(euid.get(email));

                if (p1 != p2) {
                    par[p2] = p1;
                }

            }
        }

        List<List<String>> ans = new ArrayList<>();
        HashMap<Integer, List<String>> res = new HashMap<>(); // store all the emails corresponding wrt to their
                                                              // parents

        for (Map.Entry<String, Integer> eid : euid.entrySet()) {

            int id = eid.getValue();

            int p = findPar(id); // finding parent of all uni id
            if (!res.containsKey(p)) {
                res.put(p, new ArrayList<>());
                res.get(p).add(eid.getKey());
            } else {
                res.get(p).add(eid.getKey());
            }
        }

        for (Map.Entry<Integer, List<String>> pte : res.entrySet()) {
            List<String> emails = pte.getValue();

            Collections.sort(emails);
            emails.add(0, etn.get(emails.get(0))); // inserting user name in the front
            ans.add(emails);

        }

        return ans;
    }

    // 839
    HashMap<String, String> parent;

    public String findPar(String s) {

        if (parent.get(s) == s)
            return s;

        String p = findPar(parent.get(s));
        parent.put(s, p);
        return p;

    }

    // if char of s1 snd s2 are not similar at more than two points than they cant
    // be similar
    public boolean isSimilar(String s1, String s2) {

        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 2)
                    return false;
            }
        }

        return diffCount == 2;
    }

    public int numSimilarGroups(String[] strs) {

        parent = new HashMap<>();
        // string vs parent
        for (String s : strs) {
            parent.put(s, s); // intially everyone is itself's parent
        }

        for (int i = 0; i < strs.length; i++) {
            String p1 = findPar(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {

                if (isSimilar(strs[i], strs[j])) {
                    String p2 = findPar(strs[j]);
                    if (p1 != p2) {
                        parent.put(p1, p2);
                    }

                }

            }
        }

        int groups = 0;

        for (String s : strs) {
            String p = findPar(s);

            if (s == p) {
                groups++;
            }
        }

        return groups;

    }

    // 1168

    // C++ CODE GRAPH_CLASS07 -< 3:20:20

    public static class Edge {
        int nbr;
        int w;

        Edge(int nbr, int w) {
            this.nbr = nbr;
            this.w = w;
        }
    }

    // since we are given 1 bases indexing we are considering 0 position to have
    // connection with all the houses
    // with the cost of that pipeline = price to install well at that house
    // that means if we have connection between ith house and 0 => that house has
    // installed a well
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        ArrayList<int[]> allPipes = new ArrayList<>();
        for (int[] a : pipes)
            allPipes.add(a);
        for (int i = 0; i < wells.length; i++)
            allPipes.add(new int[] { 0, i + 1, wells[i] }); // conneting wells

        Collections.sort(allPipes, (a, b) -> {
            return a[2] - b[2];
        });

        par = new int[n + 1];
        int ans = 0;

        for (int i = 0; i <= n; i++) {
            par[i] = i;
        }

        for (int[] e : allPipes) {
            int u = e[0], v = e[1], w = e[2];
            int p1 = findPar(u), p2 = findPar(v);
            if (p1 != p2) {
                par[p1] = p2;
                ans += w;
            }
        }

        return ans;
    }

    // 1584

    public int manhattan_dist(int[] pt1, int[] pt2) {

        return Math.abs(pt1[0] - pt2[0]) + Math.abs(pt1[1] - pt2[1]);
    }

    // here [[],[],[]] -> rather than considering each point inside 1d array of 2d
    // array
    // we have connected indexes of each 1-D array
    public int minCostConnectPoints(int[][] points) {

        List<int[]> graph = new ArrayList<>();
        int n = points.length;

        par = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);

        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        // finding the distnace for i form each j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int md = manhattan_dist(points[i], points[j]);
                graph.add(new int[] { i, j, md });
            }
        }

        // kruskals
        graph.sort((a, b) -> {
            return a[2] - b[2]; // sorting on the basis of md
        });

        // for(int[] e : graph){
        // for(int i : e){
        // System.out.print(i+" ");
        // }
        // System.out.println();
        // }

        int cost = 0;
        for (int[] e : graph) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            int p1 = findPar(u);
            int p2 = findPar(v);

            if (p1 != p2) {
                if (size[p2] <= size[p1]) {
                    par[p2] = p1;
                    size[p1] += size[p2];
                } else {
                    par[p1] = p2;
                    size[p2] += size[p1];
                }

                cost += w;
            }
        }

        return cost;
    }

    // 305
    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {

        if (operators == null)
            return new ArrayList<>();
        int[][] grid = new int[n][m];

        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        int count = 0;
        List<Integer> ans = new ArrayList<>();

        par = new int[n * m];

        for (int i = 0; i < n * m; i++) {
            par[i] = i;
        }

        for (int i = 0; i < operators.length; i++) {
            int px = operators[i].x;
            int py = operators[i].y;

            if (grid[px][py] == 1) {
                ans.add(count);
                continue;
            }

            grid[px][py] = 1;
            count++;
            int p1 = findPar(px * m + py);
            for (int[] d : dirs) {
                int x = px + d[0];
                int y = py + d[1];

                if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1) {
                    int p2 = findPar(x * m + y);

                    if (p1 != p2) {
                        par[p2] = p1;
                        count--; // since two components merge they form single components so no of comp dec
                    }
                }
            }
            ans.add(count);
        }

        return ans;
    }

    // w/o extra space
    public List<Integer> numIslands2_(int n, int m, Point[] operators) {

        if (operators == null)
            return new ArrayList<>();

        par = new int[n * m];

        Arrays.fill(par, -1);

        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        int count = 0;
        List<Integer> ans = new ArrayList<>();

        for (Point op : operators) {
            int px = op.x;
            int py = op.y;

            if (par[px * m + py] != -1) {
                ans.add(count);
                continue;
            }

            // px[i]!=-1 denotes there is an island

            par[px * m + py] = px * m + py;
            count++;
            int p1 = findPar(px * m + py);
            for (int[] d : dirs) {
                int x = px + d[0];
                int y = py + d[1];

                if (x >= 0 && y >= 0 && x < n && y < m && par[x * m + y] != -1) {
                    int p2 = findPar(x * m + y);

                    if (p1 != p2) {
                        par[p2] = p1;
                        count--; // since two components merge they form single components so no of comp dec
                    }
                }
            }
            ans.add(count);

        }

        return ans;

    }

    // 924
    public int minMalwareSpread(int[][] graph, int[] initial) {

        // UNION FIND

        int n = graph.length;
        par = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && i!=j) {
                    int p1 = findPar(i);
                    int p2 = findPar(j);

                    if (p1 != p2) {
                        merge(p1, p2); // merging on the basis of size
                    }
                }
            }
        }


        // now stopping the malware spread

        // if a component has more than one infected node than there is no effect of removing either of the node from that component 
        // so we are maitaing a freq array that will keep a check on the same

        int[] fre = new int[n];

        for(int i=0;i<initial.length;i++){
            int p = findPar(initial[i]);

            fre[p]++;
        }


        // checking which node we can remove

        int remIdx = -1;
        int maxSpread = 0;
        for(int i=0;i<initial.length;i++){

              int p = findPar(initial[i]);

              if(fre[p]>1 ) continue;

              if(size[p] == maxSpread){
                  remIdx = Math.min(remIdx,initial[i]);
              }

              if(size[p] > maxSpread){
                    maxSpread = size[p];
                    remIdx = initial[i];
              }
        }

        // if every component has more that one infected node => stopping malware spread is not possible

        return remIdx;

    }
}
