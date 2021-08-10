import java.util.*;

public class sudokuSet {

    public static class pair {
        int r = 0;
        int c = 0;

        pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static boolean isValidToPlaceNumber(char[][] board, int r, int c, int num) {
        // row
        for (int i = 0; i < 9; i++)
            if (board[r][i] - '0' == num)
                return false;

        // col
        for (int i = 0; i < 9; i++)
            if (board[i][c] - '0' == num)
                return false;

        // mat
        // yaha pe hum find kar rahe hai ki vo board
        // ke kon se 3*3 ke matrix ko belong kar raha hai
        // aur uska staring index nikal rahe hai
        r = (r / 3) * 3;
        c = (c / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[r + i][c + j] - '0' == num)
                    return false;
            }
        }

        return true;
    }

    public static boolean solveSudoku(char[][] board, int idx, ArrayList<pair> arr) {
        if (idx == arr.size()) {
            return true;
        }

        pair p = arr.get(idx);
        int r = p.r;
        int c = p.c;

        for (int num = 1; num <= 9; num++) {
            if (isValidToPlaceNumber(board, r, c, num)) {
                board[r][c] = (char) (num + '0');
                if (solveSudoku(board, idx + 1, arr))
                    return true;
                board[r][c] = '.';
            }
        }

        return false;
    }

    public static void solveSudoku(char[][] board) {
        ArrayList<pair> arr = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    arr.add(new pair(i, j)); // i * 9 + j
                }
            }
        }

        solveSudoku(board, 0, arr);
    }

    // using bits

    // row col and mat me ek int store hoga jiska
    // binary form ke under '1' ka index humne vo number
    // de rahah ho jo ki already sudoku me hai
    // humo row , col aur mat pe jo number hai unse mtlb nhi hai
    // unke binary form se hai // ^ krne pe vo change hote rahenge

    public static int[] row, col;
    public static int[][] mat;

    public static boolean solveSudoku_Bits(char[][] board, int idx, ArrayList<pair> arr) {

        if (idx == arr.size()) {
            return true;
        }

        pair p = arr.get(idx);
        int r = p.r;
        int c = p.c;

        for (int i = 1; i <= 9; i++) {
            int mask = (1 << i);
            if ((row[r] & mask) == 0 && (col[c] & mask) == 0 && (mat[r / 3][c / 3] & mask) == 0) {
                board[r][c] = (char) (i + '0');
                row[r] ^= mask;
                col[c] ^= mask;
                mat[r / 3][c / 3] ^= mask;

                if (solveSudoku_Bits(board, idx + 1, arr)) {
                    return true;
                }
                board[r][c] = '.';
                row[r] ^= mask;
                col[c] ^= mask;
                mat[r / 3][c / 3] ^= mask;
            }

        }

        return false;
    }

    public void solveSudoku_Bits(char[][] board) {
        row = new int[9];
        col = new int[9];
        mat = new int[3][3];
        ArrayList<pair> arr = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int mask = 0;
                if (board[i][j] != '.') {
                    mask = 1 << (board[i][j] - '0');
                    row[i] ^= mask;
                    col[j] ^= mask;
                    mat[i / 3][j / 3] ^= mask;
                } else {
                    arr.add(new pair(i, j));
                }
            }
        }

        solveSudoku_Bits(board, 0, arr);
    }

    public boolean isValidSudoku(char[][] board) {

        row = new int[9];
        col = new int[9];
        mat = new int[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                int mask = 0;

                if (board[i][j] != '.') {
                    mask = 1 << (board[i][j] - '0'); // 1<<5;
                    if ((row[i] & mask) == 0 && (col[j] & mask) == 0 && (mat[i / 3][j / 3] & mask) == 0) {
                        row[i] ^= mask;
                        col[j] ^= mask;
                        mat[i / 3][j / 3] ^= mask;
                    } else {
                        return false;
                    }
                }

            }
        }

        return true;
    }

    // ----------------------------------------------------------------

    public static int strToInt(String str, HashMap<Character, Integer> charIntMap) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res = res * 10 + charIntMap.get(str.charAt(i));
        }

        return res;
    }

    public static void Cryptarithmetic(String unique, int idx, HashMap<Character, Integer> charIntMap,
            boolean[] usedNumbers, String s1, String s2, String s3) {

        if (idx == unique.length()) {
            int x = strToInt(s1, charIntMap);
            int y = strToInt(s2, charIntMap);
            int z = strToInt(s3, charIntMap);

            if (x + y == z) {
                for (int i = 0; i < 26; i++) {
                    char ch = (char) (i + 'a');
                    if (charIntMap.containsKey(ch)) {
                        System.out.print(ch + "-" + charIntMap.get(ch) + " ");
                    }
                }

                System.out.println();
            }

            return;
        }

        char ch = unique.charAt(idx);

        // 10 option khol diye
        for (int num = 0; num < 10; num++) {
            if (!usedNumbers[num]) {
                usedNumbers[num] = true;
                charIntMap.put(ch, num);

                Cryptarithmetic(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);

                charIntMap.remove(ch);
                usedNumbers[num] = false;
            }

        }

    }

    public static void Cryptarithmetic_main() {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s3 = scn.nextLine();

        HashMap<Character, Integer> charIntMap = new HashMap<>();
        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
            if (!charIntMap.containsKey(s1.charAt(i))) {
                charIntMap.put(s1.charAt(i), -1);
                unique += s1.charAt(i);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!charIntMap.containsKey(s2.charAt(i))) {
                charIntMap.put(s2.charAt(i), -1);
                unique += s2.charAt(i);
            }
        }

        for (int i = 0; i < s3.length(); i++) {
            if (!charIntMap.containsKey(s3.charAt(i))) {
                charIntMap.put(s3.charAt(i), -1);
                unique += s3.charAt(i);
            }
        }

        boolean[] usedNumbers = new boolean[10];
        Cryptarithmetic(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
    }

    // 2 set of equal sum

    // ye ncr vale method se bhi ho jaenge

    public static int equalSet(int[] arr, int idx, int sum1, String set1, int sum2, String set2) {

        if (idx == arr.length) {
            if (sum1 == sum2) {
                System.out.println(set1 + " = " + set2);
                return 1;
            }

            return 0;
        }

        int count = 0;
        count += equalSet(arr, idx + 1, sum1 + arr[idx], set1 + arr[idx] + " ", sum2, set2);
        count += equalSet(arr, idx + 1, sum1, set1, sum2 + arr[idx], set2 + arr[idx] + " ");
        return count;
    }

    public static void ksubsets(int[] arr, int idx, int[] subsetSum, ArrayList<ArrayList<Integer>> ans) {

        if (idx == arr.length) {
            int val = subsetSum[0];

            for (int i = 1; i < subsetSum.length; i++) {
                if (val != subsetSum[i]) {
                    return;
                }
            }

            for (ArrayList<Integer> e : ans) {
                System.out.print(e + " ");
            }

            System.out.println();
            return;
        }

        for (int i = 0; i < subsetSum.length; i++) {

            boolean isLeader = false;
            if (ans.get(i).size() == 0)
                isLeader = true;

            subsetSum[i] += arr[idx];
            ans.get(i).add(arr[idx]);

            ksubsets(arr, idx + 1, subsetSum, ans);

            subsetSum[i] -= arr[idx];
            ans.get(i).remove(ans.get(i).size() - 1);

            if (isLeader)
                break;
        }
    }

    public static void equalSet(int[] arr, int idx, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++)
            ans.add(new ArrayList<>());

        int sum = 0;
        for (int ele : arr)
            sum += ele;

        if ((sum & k) != 0)
            return;

        int[] subsetSum = new int[k];
        ksubsets(arr, 0, subsetSum, ans);

    }

    public static void equalSet_main(int[] arr) {
        // equalSet(arr,0,0,"",0,""); // this will give mirror images
        equalSet(arr, 1, 10, "10 ", 0, ""); // here we will fix one elem in on of the sets so that no mirror image is
                                            // formed
    }

    public static int counter = 1;

    public static void kPartition(int n, int idx, int k, ArrayList<ArrayList<Integer>> ans) {

        if (idx > n) {

            for (ArrayList<Integer> e : ans) {
                if (e.size() == 0)
                    return;
            }

            System.out.print(counter + ". ");
            for (ArrayList<Integer> e : ans) {
                System.out.print(e + " ");
            }
            counter++;
            System.out.println();

            return;
        }

        for (ArrayList<Integer> a : ans) {

            boolean isLeader = false;
            if (a.size() == 0) {
                isLeader = true;
            }

            a.add(idx);

            kPartition(n, idx + 1, k, ans);

            a.remove(a.size() - 1);

            if (isLeader) {
                break;
            }

        }

    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80 };
        equalSet_main(arr);
    }
}
