#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {

    ios_base::sync_with_stdio(false); cin.tie(NULL);
	freopen("badmilk.in", "r", stdin); freopen("badmilk.out", "w", stdout);
    // freopen("file.in", "r", stdin);

    ll n,m,d,s; cin>>n>>m>>d>>s;   // people, milks, drink events, get sick time

    vector<vector<pair<ll,ll>>> milks(m+1);

    for(ll i = 1; i <= d; i++){
        ll person, milk_type, drink_time; cin>>person>>milk_type>>drink_time;
        bool found = false;
        for(auto& p: milks[milk_type]){
            if(p.second == person){
                found = true;
                p.first = min(drink_time, p.first);
            }
        }

        if(!found) milks[milk_type].push_back({drink_time, person});
    }

    unordered_map<ll,ll> get_sick; // person: get sick time

    vector<bool> tot_sick(n+1, false);

    for(ll i = 1; i <= s; i++){
        ll person, sick_time; cin>>person>>sick_time;
        get_sick[person] = sick_time;
        tot_sick[person] = true;
    }

    // for(auto p: milks[1]) cout<<"Person: "<<p.second<<", time: "<<p.first<<endl;

    vector<ll> potential_bad_milk;

    for(ll i = 1; i<=m; i++){
        bool ok = true;

        vector<bool> make_sick(n+1);
        for(auto p: milks[i]){
            if(get_sick.find(p.second)== get_sick.end()) continue;
            make_sick[p.second] = true;
            if(p.first >= get_sick[p.second]) ok = false;
        }
        for(ll j = 1; j <= n; j++) if(tot_sick[j]) if(!make_sick[j])  ok = false;
        // for(ll j = 1; j <= n; j++) cout<<"Cow "<<i<<": "<<tot_sick[j]<<" "<<make_sick[j]<<"\n";

        if(ok) potential_bad_milk.push_back(i);
    }

    ll ans = 0;

    for(ll i = 0; i < potential_bad_milk.size(); i++){
        ll cur_milk = potential_bad_milk[i];
        ans = max(ans, (ll)milks[cur_milk].size());
    }

    cout<<ans<<'\n';

    return 0;

    return 0;
}