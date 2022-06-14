public class q7 {
    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        // add code here.
        int left_min_idx = 0;
        int right_max_idx = n-1;
        
        if(n<3) return new ArrayList<>();
        
        int[] left_min = new int[n];
        int[] right_max = new int[n];
        
        left_min[0] = -1;
        right_max[n-1] = -1;
        
        
        for(int i=1;i<n;i++){
            
            if(arr.get(i) > arr.get(left_min_idx)){
                left_min[i] = left_min_idx;
            }else{
                left_min[i] = -1;
                left_min_idx = i; // next possible smallest element on left
            }
            
        }
        
        for(int i= n-2;i>=0;i--){
            
            if(arr.get(i) < arr.get(right_max_idx)){
                right_max[i] = right_max_idx;
            }else{
                right_max[i] = -1;
                right_max_idx = i;
            }
        }
        
        
        ArrayList<Integer> res = new ArrayList<>();
        
        
        for(int i=0;i<n;i++){
            if(left_min[i]!=-1 && right_max[i]!=-1){
                
                // System.out.print(left_min[i] +" "+ right_max[i]);
                
                 res.add(arr.get(left_min[i]));
                res.add(arr.get(i));
                res.add(arr.get(right_max[i]));
                // return res;
                break;
            }
        }
        
        
        
        return res;
        
        
        
    }
}
