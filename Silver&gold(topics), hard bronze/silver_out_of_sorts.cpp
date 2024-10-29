#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const ll inf = 1e18;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
	freopen("sort.in", "r", stdin); freopen("sort.out", "w", stdout);
    // freopen("file.in", "r", stdin);

    ll n; cin>>n;
    vector<pair<ll,ll>> input(n); // <value, index>
    for(ll i = 0; i < n; i++){
        cin>>input[i].first;
        input[i].second = i;
    }

    sort(input.begin(), input.end());

    ll ans = 0;

    for(ll i = 0; i < n; i++) ans = max(ans, input[i].second-i);
    // Key Point: only calculate the points that move from back to front
    // this avoid having overestimation from points that move from front to back

    cout<<ans+1<<"\n";
    
    return 0;
}