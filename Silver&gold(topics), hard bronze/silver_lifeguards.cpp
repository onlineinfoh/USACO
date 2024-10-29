#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {

    ios_base::sync_with_stdio(false); cin.tie(NULL);
	freopen("lifeguards.in", "r", stdin); freopen("lifeguards.out", "w", stdout);
    // freopen("file.in", "r", stdin);

    ll n; cin>>n;
    vector<vector<ll>> events;
    for(ll i = 0; i < n; i++) {
        ll x, y; cin>>x>>y;
        --x; --y;
        events.push_back({x, 1, i}); // start
        events.push_back({y, 0, i}); // end
    }

    sort(events.begin(), events.end());

    if(n == 1){
        cout<<0<<'\n';
        return 0;
    }

    set<ll> working;
    ll ans = 0;

    vector<ll> work_alone(n);

    ll prev = 0;
    ll tot = 0;

    for(ll i = 0; i < events.size(); i++) {
        if(working.size()) tot += events[i][0] - prev;
        if(working.size() == 1){
            work_alone[*working.begin()] += events[i][0] - prev;
        }

        if(events[i][1]) working.insert(events[i][2]);
        else working.erase(events[i][2]);
        prev = events[i][0];
    }

    for(ll i = 0; i < n; i++) ans = max(ans, tot-work_alone[i]);
    cout<<ans<<'\n';

    return 0;
}