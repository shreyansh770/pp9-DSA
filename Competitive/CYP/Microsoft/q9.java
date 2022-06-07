public class q9 {

    int ans = 0;
    int help(Node root , int tar){
  
        if(root==null){
            return 0;
        }

        int sum = 0;
        int lsum = help(root.left,tar);
        int rsum = help(root.right, tar);

        sum = lsum + root.data + rsum;
        if(sum==tar){
            ans++;
        }

        return sum;

    }

    int countSubtreesWithSumX(Node root, int X)
    {

        if(root==null) return 0;

        help(root,X);
        return ans;
    }
}
