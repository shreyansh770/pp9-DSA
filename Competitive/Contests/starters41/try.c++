#include <iostream>
using namespace std;

int main() {
      int n;
      cin >> n;
      
      int permu[n];
      
      for(int i=0;i<n;i++) {
          P[i] = i + 1;
      }
      
      int arr[n]={};

      int left;
      int right;
      int pIdx;
      for(int i=0;i<(n/2)+1;i++){

          left  = n - 2*i - 1;
          right = n - 2*i - 2;
          pIdx = n-i+1;

          arr[left] = perm[pIdx];
          arr[right] = permu[i];
      }
      
      for(auto e : AN) {
         cout << e << " ";
      }
      
      cout << endl;
}