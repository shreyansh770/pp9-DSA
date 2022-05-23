#include <bits/stdc++.h>
using namespace std;

   
 
   
    
   
  


 const int mod = 1e9 + 7;     
 long long power(long long x, long long  y)  {   
     if(y==0) {
         return 1;
     }
     ll small = power(x,y/2);
     small = (small*small)%mod;  
     if(y%2) small=(x*small)%mod;
     return small;
 }    
     
 long long getInv(long long x)  { 
     return power(x,mod-2);  
 }
 
 bool isPalindrome(string s)  {
      int end = s.size() - 1;
    int bgn = 0;
   
    while(bgn < end)
    {
        if(s[bgn++] != s[end--]) {
            return false;
        }
        
       
    }
    return true;
}

 string need_string(string& s, int idx) {
     int sz = s.size();
            string f = s.substr(0,idx);
            f = f + s.substr( idx + 1 , sz - idx - 1);
            return f;
 }


void rec(string curr,long long cnt, long long& x, long long& y)
{
    
    if(curr == "") {
        
        y++;
        x = x+cnt;
        x++;
        y = y%mod;
        x = x%mod;
        
        return;
    }
    
    if(isPalindrome(curr)) {
        cnt++;
        cnt = cnt%mod;
    }
    
    for(int i=0; i < (int)curr.size(); i++)
    {
        string ncurr = need_string(curr,i);
        rec(ncurr,cnt,x,y);
    }
    return;
}
 

     int main() 
    {
         ios :: sync_with_stdio(false); 
        cin.tie(0);
    cout.tie(0); 
       
     
        long long t=1;
       cin>>t;
     
        for(int T = 1; T< t+1; ++T)
        {
          cout<<"Case #"<<T<<": ";
          
        int n;
        string s;
        cin >> n >> s;
        long long  x =0;
        long long  y = 0;
        int len = s.size();
        for(int i=0; i< (int)s.size() ; i++)   {
            
            string sub = need_string(s,i);
          
            rec(sub,0,x,y);
        }
       
       
        long long res = getInv(y);
        res = (res*x)%mod;
        
        cout<<res<<"\n"; 
         
          
        }
     
        return 0;
    }


