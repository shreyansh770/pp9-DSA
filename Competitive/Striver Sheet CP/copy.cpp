#include <bits/stdc++.h>
#define ll long long
#define pb push_back
#define fr(a, b) for (int i = a; i < b; i++)
#define rep(i, a, b) for (int i = a; i < b; i++)
#define mod 1000000007
#define inf (1LL << 60)
#define all(x) (x).begin(), (x).end()
#define prDouble(x) cout << fixed << setprecision(10) << x
#define triplet pair<ll, pair<ll, ll>>
#define fast_io                       \
    ios_base::sync_with_stdio(false); \
    cin.tie(NULL)
using namespace std;

vector<int> tree[200001];
ll subtreeAns[200001];
ll ans[200001];
int subtreeSize[200001];

void preprocessing(int src, int par)
{
    int numOfNodes = 1;
    ll ansForSubtree = 0;
    for (int child : tree[src])
    {
        if (child != par)
        {
            preprocessing(child, src);
            numOfNodes += subtreeSize[child];
            ansForSubtree += subtreeSize[child] + subtreeAns[child];
        }
    }
    subtreeSize[src] = numOfNodes;
    subtreeAns[src] = ansForSubtree;
}

void solve(int src, int par, ll par_ans, int totalNodes)
{
    ans[src] = subtreeAns[src] + (par_ans + (totalNodes - subtreeSize[src]));

    for (int child : tree[src])
    {
        if (child != par)
            solve(child, src, ans[src] - (subtreeAns[child] + subtreeSize[child]), totalNodes);
    }
}

int main()
{
    //    fast_io;
    //    ll t,n,m,x,i,j,k,q;
    cin >> t;
    //t = 1;
    while(t--)
    {
    int n;
    cin >> n;
    int m;
    cin >> m;
    vector<vector<int>> a(n, vector<int>(m));
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
            cin >> a[i][j];
    }
    int ans = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            int sum = 0;
            int r1 = i, c1 = j;
            while (r1 >= 0 and r1 <= (n - 1) and c1 >= 0 and c1 <= (m - 1))
            {
                sum += a[r1][c1];
                r1--, c1--;
            }
            r1 = i, c1 = j;
            while (r1 >= 0 and r1 <= (n - 1) and c1 >= 0 and c1 <= (m - 1))
            {
                sum += a[r1][c1];
                r1--, c1++;
            }
            r1 = i, c1 = j;
            while (r1 >= 0 and r1 <= (n - 1) and c1 >= 0 and c1 <= (m - 1))
            {
                sum += a[r1][c1];
                r1++, c1--;
            }
            r1 = i, c1 = j;
            while (r1 >= 0 and r1 <= (n - 1) and c1 >= 0 and c1 <= (m - 1))
            {
                sum += a[r1][c1];
                r1++, c1++;
            }
            sum -= a[i][j];
            sum -= a[i][j];
            sum -= a[i][j];
            ans = max(ans, sum);
        }
    }
    cout << ans << endl;
       }
    //    return 0;
}