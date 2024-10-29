#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const ll inf = 1e18;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
	freopen("diamond.in", "r", stdin); freopen("diamond.out", "w", stdout);
    //freopen("file.in", "r", stdin);

    ll n,k; cin>>n>>k;
    vector<ll> vec(n);
    for(ll i = 0; i < n; i++) cin>>vec[i];
    sort(vec.begin(), vec.end());

    vector<ll> reaching(1e5,1);

    for(ll l = 0, r = 0; l < n; l++){
        while (r < n && vec[r] - vec[l] <= k) {
            r++;
        }
        reaching[l] = r - l;
    }
    reaching[n-1] = 1;

    vector<ll> suffix_max(1e5);
    suffix_max[n-1] = 1;
    for(ll i = n-2; i >= 0; i--){
        suffix_max[i] = max(suffix_max[i+1], reaching[i]);
    }

    ll ans = 0;

    for(ll i = 0; i< n; i++){
        ans = max(ans, reaching[i] + suffix_max[i+reaching[i]]);
    }

    cout<<ans<<'\n';
    
    return 0;
}