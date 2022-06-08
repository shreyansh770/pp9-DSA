signed main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n, k;
        cin >> n >> k;
        vector<int> a(n+1);
        string s;
        cin >> s;
        for (int i = 0; i < n; i++)
            a[i + 1] = a[i] + (s[i] == 'B');

        int ans = n;
        for (int i = k; i <= n; i++)
            ans = min(ans, k - (a[i] - a[i - k]));

        cout << ans << '\n';
    }

    return 0;
}