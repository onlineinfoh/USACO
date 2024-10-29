#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
	// freopen("div7.in", "r", stdin); freopen("div7.out", "w", stdout);
    freopen("file.in", "r", stdin);

    ll n,m; cin>>n>>m;
    vector<ll> A(n);
    vector<ll> B(n);
    for(ll i = 0; i < n; i++) cin>>A[i]>>B[i];

    vector<ll> start(m+1); 
    vector<ll> end(m+1);
    for(int i = 0; i < n; i++) start[A[i]]++; // A represents the start of each range
    for(int i = 0; i < n; i++) end[B[i]]++; // B represents the end of each range

    vector<ll> ans(m*2+2);

    for(ll a = 0; a <= m; a++){
        for(ll b = 0; b <= m; b++){
            // Use the idea of difference sum

            ans[a+b] += start[a]*start[b];
            // Values that satisfy the k are starting to be accounted

            ans[a+b+1] -= end[a]*end[b]; 
            // Values that are satisfied at a+b but become not satisfied, therefore this value is subtracted for index a+b+1 
        }
    }

    for(ll i=1; i<=2*m; i++) ans[i] += ans[i-1];

    for(ll i = 0; i<= 2*m; i++) cout<<ans[i]<<endl;
    return 0;
}