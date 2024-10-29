#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const ll inf = 1e18;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
	// freopen("backforth.in", "r", stdin); freopen("backforth.out", "w", stdout);
    // freopen("file.in", "r", stdin);

    ll n,q; cin>>n>>q;

    vector<ll> requirements(105);

    for(ll i = 0; i< n; i++){
        ll s, t; cin>>s>>t;
        ll c; cin>>c;
        for(ll x = s; x<=t; x++){
            requirements[x] += c;
        }
    }

    vector<vector<ll>> ACs(q); // <start,end,cool down amount,cost>
    for(ll i = 0; i< q; i++){
        ll s, t, c, d; cin>>s>>t>>c>>d;
        ACs[i] = {s,t,c,d};
    }

    ll ans = 1e18;
    for(ll i = 0; i< (1<<q); i++){
        bool ok = true;
        ll poss = 0;
        vector<ll> tem(105);
        for(ll j = 0; j< q; j++){
            if((1<<j) & i){
                ll s = ACs[j][0];
                ll t = ACs[j][1];
                ll cd = ACs[j][2];
                ll c = ACs[j][3];
                poss+=c;
                for(ll x = s; x<= t; x++) tem[x]+=cd;
            }
        }
        for(ll j = 0; j< 100; j++) if(tem[j]<requirements[j]) ok = false;
        if(ok){
            ans = min(poss, ans);
        }
    }
    cout<<ans;

    return 0;
}