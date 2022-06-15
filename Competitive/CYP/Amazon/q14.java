import java.util.ArrayList;

public class q14 {

    public static void burningChilds(Node root , int target ,int block,List<List<Integer>> time , int t){

        if(root == null || block) return ;

        if(t==time.size()){
            time.add(new ArrayList<>());
        }

        time.get(t).add(root.val);

        burningChilds(root.left, target, block, time, t+1);
        burningChilds(root.right, target, block, time, t+1);

    }


    public static int minTime(Node root , int target , List<List<Integer>> time){
        if(root==null) return -1;

        if(root.data == target){
            burningChilds(root, target, null,time,0);
            return 1;
        }

        int left = minTime(root.left, target,time);
        int right = minTime(root.right, target,time);

        if(left>=0){

            burningChilds(root, target,root.left,time,left);
            return left+1;
        }

        if(right>=0){

            burningChilds(root, target,root.right,time,right);
            return right+1;

        }

        return -1;
    }

    public static int minTime(Node root, int target) {
        

        List<List<Integer>> time = new ArrayList<>();

        minTime(root, target, time);

        return time.size()-1;


    }

    
}
