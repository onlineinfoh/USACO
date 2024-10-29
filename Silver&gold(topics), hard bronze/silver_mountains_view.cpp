#include <bits/stdc++.h>
using namespace std;
using ll = long long;

bool cmp(pair<ll,ll> a, pair<ll,ll> b) {
    if (a.first == b.first) return b.second<a.second;
    return a.first < b.first;
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
	freopen("mountains.in", "r", stdin); freopen("mountains.out", "w", stdout);
    // freopen("file.in", "r", stdin);

    ll n; cin>>n;

    vector<pair<ll,ll>> bases(n);
    for(ll i = 0; i < n; i++) {
        ll x, y; cin>>x>>y;
        bases[i] = {x-y, x+y};
    }
    sort(bases.begin(), bases.end(),cmp);

    ll ans = 0;
    ll last = -1e18;
    for(ll i = 0; i < n; i++) {
        if(bases[i].second > last) {
            ans++;
            last = bases[i].second;
        }
    }
    cout<<ans<<'\n';
}