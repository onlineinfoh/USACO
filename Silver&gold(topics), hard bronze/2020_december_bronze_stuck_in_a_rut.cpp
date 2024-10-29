#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
	// freopen("split.in", "r", stdin); freopen("split.out", "w", stdout);
    // freopen("file.in", "r", stdin);

    ll n; cin>>n;
    vector<pair<ll,ll>> coordinates(n);
    vector<vector<ll>> East;
    vector<vector<ll>> North;

    for(ll i = 0; i < n; i++) {
        string s; cin>>s;
        ll x, y; cin>>x>>y;
        coordinates[i] = {x, y};
        if(s == "E") East.push_back({x,y,i});  // x, y, cow index
        else North.push_back({x,y,i});
    }

    vector<vector<ll>> collisions;

    for(auto i: East) {
        for(auto j: North) {
            ll xTime = j[0] - i[0];
            ll yTime = i[1] - j[1];
            if(xTime < 0 || yTime < 0) continue;
            if(xTime == yTime) continue;
            if(xTime > yTime) collisions.push_back({xTime, i[2], j[2], 0});  // i collides into j's path
                                                                // 1 for north cow collides into east cow

            else collisions.push_back({yTime, j[2], i[2], 1});  // j collides into i's path
                                                                // 1 for north cow collides into east cow
        }
    }

    sort(collisions.begin(), collisions.end());

    ll inf = 1e18;
    vector<ll> stopTime(n, inf);

    for(auto v: collisions) {
        if(stopTime[v[1]] == inf && stopTime[v[2]] == inf) {
            stopTime[v[1]] = v[0];
        }
        // the cow i is colliding into has stopped earlier
        else if(stopTime[v[1]] == inf){
            // Colliding cow is moving to the east
            if(!v[3]){
                ll moveTime = stopTime[v[2]];
                ll start = coordinates[v[2]].second;
                ll end = start + moveTime;
                if(coordinates[v[1]].second <= end && coordinates[v[1]].second >= start) stopTime[v[1]] = v[0];
            }
            // Colliding cow is moving to the north
            else{
                ll moveTime = stopTime[v[2]];
                ll start = coordinates[v[2]].first;
                ll end = start + moveTime;
                if(coordinates[v[1]].first <= end && coordinates[v[1]].first >= start) stopTime[v[1]] = v[0];
            }
        }
    }

    for(int i = 0; i < n; i++){
        if(stopTime[i] == inf) cout<<"Infinity"<<endl;
        else cout<<stopTime[i]<<endl;
    }
    return 0;
}