#include <bits/stdc++.h>
using namespace std;

int main()
{
    int t;
    cin >> t;
    //t = 1;
    while(t--)
    {
    int n;
    cin >> n;
    int m;
    cin >> m;
    vector<vector<int>> arr(n, vector<int>(m));
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
            cin >> arr[i][j];
    }
    int res = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            int add = 0;
            int r1 = i, c1 = j;
            while (r1 >= 0 and r1 <= (n - 1) and c1 >= 0 and c1 <= (m - 1))
            {
                add += arr[r1][c1];
                r1--, c1--;
            }
            r1 = i, c1 = j;
            while (r1 >= 0 and r1 <= (n - 1) and c1 >= 0 and c1 <= (m - 1))
            {
                add += arr[r1][c1];
                r1--, c1++;
            }
            r1 = i, c1 = j;
            while (r1 >= 0 and r1 <= (n - 1) and c1 >= 0 and c1 <= (m - 1))
            {
                add += arr[r1][c1];
                r1++, c1--;
            }
            r1 = i, c1 = j;
            while (r1 >= 0 and r1 <= (n - 1) and c1 >= 0 and c1 <= (m - 1))
            {
                add += arr[r1][c1];
                r1++, c1++;
            }
            add -= arr[i][j];
            add -= arr[i][j];
            add -= arr[i][j];
            res = max(res, add);
        }
    }
    cout << res << endl;
       }
       
       return 0;
}