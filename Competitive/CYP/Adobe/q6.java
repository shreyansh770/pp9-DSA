import java.util.ArrayList;

public class q6 {

    public void rec(int lc , int rc , int n , String s , List<String> res){
        if(rc>lc || lc>n) return;

        if(rc==lc && lc==n){
            res.add(s);
            return;
        }

        rec(lc+1,rc,n,s+"(",res);
        rec(lc,rc+1,n,s+")",res);
    }

    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> res = new ArrayList<>();

        rec(0,0,n,"",res);

        return res;
    }
}
