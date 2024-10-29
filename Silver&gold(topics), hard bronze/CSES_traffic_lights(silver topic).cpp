#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const ll inf = 1e18;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
	// freopen("lineup.in", "r", stdin); freopen("lineup.out", "w", stdout);
    freopen("file.in", "r", stdin);

    ll n, m; cin>>n>>m;
    set<ll> a; a.insert(0); a.insert(n); 

    vector<ll> segments(m);
    for(ll& x : segments){cin>>x; a.insert(x);}

    ll prev = 0;
    ll maxi = 0;
    for(ll num: a){
        maxi = max(maxi, num-prev);
        prev = num;
    }

    vector<ll> ans;
    ans.push_back(maxi);

    for(ll num = m-1; num > 0; --num){
        auto r = a.upper_bound(segments[num]);
        a.erase(segments[num]);
        maxi = max(maxi,*r-*(--r));
        ans.push_back(maxi);
    }
    for(auto it = ans.end()-1; it >= ans.begin(); it--) cout<<*it<<" ";
    return 0;
}