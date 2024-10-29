#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
	freopen("div7.in", "r", stdin); freopen("div7.out", "w", stdout);
    // freopen("file.in", "r", stdin);

    ll n;cin>>n;
    vector<ll> vec(n);
    for(ll i=0; i<n; i++) cin>>vec[i];
    for(ll i = 1; i<n; i++) vec[i] += vec[i-1];
    ll ans = 0;

    unordered_map<ll, ll> umap;
    umap[0] = -1;

    for(int i = 0; i<n; i++) {
        ll remainder = vec[i]%7;
        if(umap.find(remainder)!= umap.end()) ans = max(i - umap[remainder], ans);
        else umap[remainder] = i;
    }

    cout<<ans;

    return 0;
}