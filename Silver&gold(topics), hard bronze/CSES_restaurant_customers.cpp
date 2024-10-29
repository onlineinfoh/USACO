#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
	// freopen("div7.in", "r", stdin); freopen("div7.out", "w", stdout);
    // freopen("file.in", "r", stdin);

    ll n; cin>>n;
    vector<pair<ll,ll>> order;
    for(ll i = 0; i < n; i++){
        ll a, b; cin>>a>>b;
        order.push_back({a, 1});
        order.push_back({b, -1});
    }
    sort(order.begin(), order.end());
    ll ans = 0;
    ll curSum = 0;
    for(int i = 0; i < order.size();i++) {
        curSum += order[i].second;
        ans = max(ans, curSum);
    }
    cout<<ans;
    return 0;
}