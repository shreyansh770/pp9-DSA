import java.util.*;

public class recursion01 {

               /*****************************/

     
    public static void printDecreasing(int a, int b) {

        if (a > b)
            return;

        printDecreasing(a + 1, b);

        System.out.println(a);

    }

                  /*****************************/

    public static void printIncreasingDecreasing(int a, int b) {

        if (a > b)
            return;

        System.out.println(a);

        printIncreasingDecreasing(a + 1, b);

        System.out.println(a);

    }

                 /*****************************/
     
    public static void oddEven(int a, int b) {

        if (a > b)
            return;

        if (a % 2 != 0)
            System.out.println(a);

        oddEven(a + 1, b);

        if (a % 2 == 0)
            System.out.println(a);

    }

             /*****************************/

    public static int factorial(int n) {

        if (n == 0)
            return 1;

        return n * factorial(n - 1);

    }
            /*****************************/

    public static int power(int a, int b) {

        if (b == 0)
            return 1;

        return a * power(a, b - 1);
    }

              /*****************************/

    // O(logn)
    public static int powerBtr(int x, int n) {
        if (n == 0)
            return 1;

        int xpown = powerBtr(x, n / 2);
        int xn = xpown * xpown; // a^6 = (a^3)(a^3) // a^7 = (a^3)(a^3).a

        if (n % 2 == 1)
            xn = xn * x;

        return xn;
    }

             /*****************************/

    public static void printArray(int[] arr, int s) {

        if (s == arr.length)
            return;

        System.out.println(arr[s]);

        printArray(arr, s + 1);

    }

                  /*****************************/    

    public static void printArrayReverse(int[] arr, int s) {
        if (s == arr.length)
            return;
        printArrayReverse(arr, s + 1);
        System.out.println(arr[s]);
    }

               /*****************************/

    public static int maximum(int[] arr, int idx) {

        if (idx >= arr.length)
            return -(int) 1e9;

        int maxVal = maximum(arr, idx + 1);
        return Math.max(maxVal, arr[idx]);

    }

             /*****************************/

    public static int minimum(int[] arr, int idx) {
        if (idx >= arr.length)
            return (int) 1e9;

        int maxVal = minimum(arr, idx + 1);
        return Math.min(maxVal, arr[idx]);
    }

            /*****************************/

    public static boolean find(int[] arr, int data, int idx) {

        if (idx == arr.length)
            return false;
        if (arr[idx] == data)
            return true;

        boolean res = false;

        res = res || find(arr, data, idx + 1);

        return res;
    }

             /*****************************/

    public static int firstIndex(int[] arr, int data, int idx) {

        if (idx == arr.length)
            return -1;
        if (arr[idx] == data)
            return idx;

        return firstIndex(arr, data, idx + 1);

    }


                    /*****************************/

    public static int lastIndex(int[] arr, int data, int idx) {
        if (idx >= arr.length)
            return -1;

        int ans = lastIndex(arr, data, idx + 1);
        if (ans != -1)
            return ans;

        return arr[idx] == data ? idx : -1;
    }

               /*****************************/

    public static int[] allIndex(int[] arr, int data, int idx, int count) {

        if (idx >= arr.length)
            return new int[count];

        if (arr[idx] == data)
            count++;

        int[] ans = allIndex(arr, data, idx + 1, count);

        if (arr[idx] == data) {
            ans[count - 1] = idx;
        }

        return ans;
    }


                   /*****************************/

    public static ArrayList<String> subsequnce(String str, int idx) {

        if (idx == str.length()) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(idx);

        ArrayList<String> recAns = subsequnce(str, idx + 1);

        ArrayList<String> myAns = new ArrayList<>(recAns);

        for (String s : recAns)
            myAns.add(ch + s);

        return myAns;

    }

                /*****************************/

    public static int subsequnce02(String str, int idx, String asf, ArrayList<String> ans) {

        if (idx == str.length()) {
            ans.add(asf);
            return 1;
        }

        int count = 0;
        char ch = str.charAt(idx);
        count += subsequnce02(str, idx + 1, asf + ch, ans);
        count += subsequnce02(str, idx + 1, asf, ans);
        return count;

    }

                 /*****************************/

    public static String[] nokiaKeys = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static int nokiaKeyPad(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        char ch = str.charAt(0);
        String code = nokiaKeys[ch - '0'];

        for (int i = 0; i < code.length(); i++) {
            count += nokiaKeyPad(str.substring(1), ans + code.charAt(i));
        }

        return count;

    }

                

    public static ArrayList<String> nokiaKeyPad(String str) {

        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        ArrayList<String> recAns = nokiaKeyPad(str.substring(1));
        ArrayList<String> myAns = new ArrayList<>();

        String code = nokiaKeys[ch - '0'];

        for (int i = 0; i < code.length(); i++) {
            for (String s : recAns) {
                myAns.add(code.charAt(i) + s);
            }
        }

        return myAns;

    }

                /*****************************/

    public static int stairPath(int n, String psf, ArrayList<String> ans) {

        if (n == 0) {
            ans.add(psf);
            return 1;
        }

        if (n < 0)
            return 0;

        int count = 0;
        for (int i = 1; i <= n && n - i >= 0; i++) {
            count += stairPath(n - i, psf + i, ans);
        }

        return count;
    }

    public static ArrayList<String> stairPath(int n) {
        if (n == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myans = new ArrayList<>();
        for (int i = 1; i <= 3 && n - i >= 0; i++) {
            ArrayList<String> recAns = stairPath(n - i);
            for (String s : recAns)
                myans.add(s + i);
        }

        return myans;
    }

              /*****************************/

    public static ArrayList<String> boardPath(int n) {
        if (n == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myans = new ArrayList<>();
        for (int i = 1; i <= 6 && n - i >= 0; i++) {
            ArrayList<String> recAns = boardPath(n - i);
            for (String s : recAns)
                myans.add(s + i);
        }

        return myans;
    }


               /*****************************/

    public static ArrayList<String> boardPath(int[] arr, int n) {
        if (n == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myans = new ArrayList<>();
        for (int i = 0; i <= arr.length && n - arr[i] >= 0; i++) {
            ArrayList<String> recAns = boardPath(arr, n - arr[i]);
            for (String s : recAns)
                myans.add(s + arr[i]);
        }

        return myans;
    }

             /*****************************/

    public static int Maze3(int sr, int sc, int er, int ec, String ans, int[][] dir, String[] dirS) {

        if (sr == er && sc == ec) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];// dest for single steps
            int c = sc + dir[d][1];// dest for single steps

            if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                count += Maze3(r, c, er, ec, ans + dirS[d], dir, dirS);
            }
        }

        return count;
    }

    // bottomUp approach
    public static void JumpPaths(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS) {

        int n = board.length - 1;
        int m = board[0].length - 1;

        if (sr == n && sc == m) {
            System.out.println(ans);
            return;
        }

        board[sr][sc] = 1;

        for (int d = 0; d < dir.length; d++) {
            // ek direction me sare possible radius
            for (int rad = 1; rad <= Math.max(n, m); rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r < board.length && c < board[0].length)// false -> boundary se bhar->rad
                                                                                // expansion stop
                {
                    if (board[r][c] == 0)// false ->path is block
                    {
                        JumpPaths(r, c, board, ans + rad + dirS[d], dir, dirS);
                    }

                } else {
                    break;
                }
            }

        }

    }


                  /*****************************/

    public static void ratInMaze(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS,
            ArrayList<String> res) {
        if (sr == board.length - 1 && sc == board[0].length - 1) {
            res.add(ans);
            return;
        }

        board[sr][sc] = 0;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 1) {
                ratInMaze(r, c, board, ans + dirS[d], dir, dirS, res);
            }
        }

        board[sr][sc] = 1;
    }

    public static ArrayList<String> findPath(int[][] arr, int n) {
        // Your code here
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        String[] dirS = { "D", "U", "R", "L" };
        ArrayList<String> res = new ArrayList<>();
        if (n == 0 || arr[n - 1][n - 1] == 0 || arr[0][0] == 0)
            return res;
        ratInMaze(0, 0, arr, "", dir, dirS, res);
        Collections.sort(res);
        return res;
    }


                     /*****************************/

    public static void ratInMazeMul(int sr, int sc, int[][] board, String ans, int[][] dir, String[] dirS,
            int[][] maze) {
        int n = board.length - 1;
        int m = board[0].length - 1;
        if (sr == n && sc == m) {
            System.out.println(ans);
            return;
        }

        board[sr][sc] = 1;

        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= Math.max(n, m); rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
                    if (board[r][c] == 0 && maze[r][c] == 0) {
                        ratInMazeMul(r, c, board, ans + rad + dirS[d], dir, dirS, maze);
                    }

                } else {
                    break;
                }
            }
        }

        board[sr][sc] = 0;
    }


                      /*****************************/

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 77 };
        // String str = "abc";

        ArrayList<String> ans = new ArrayList<>();
        System.out.println(boardPath(10));

    }
}
