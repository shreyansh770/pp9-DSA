public class q7 {
    string FirstNonRepeating(string A){
        // Code here
        map<char,int>m;
        string s;
        deque<char>q;
        
        int i=0;
        while(i<A.length())
        {
            q.push_back(A[i]);
            m[A[i]]++;
            if(A[i]==q.front())
            {
                if(m[A[i]]>1)
                {
                    while(m[q.front()]>1)
                    q.pop_front();
                    if(q.empty())
                    s.push_back('#');
                    else
                    s.push_back(q.front());
                }
                else
                s.push_back(q.front());
            }
            else
            {
                while(m[q.front()]>1)
                q.pop_front();
                if(q.empty())
                s.push_back('#');
                else
                s.push_back(q.front());
            }
            i++;
        }
        
        return s;
    }
}
