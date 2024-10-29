#include <bits/stdc++.h>
using namespace std;
using ll = long long;

struct point{
    ll x, y, index;
    ll height_sum;
    ll width_sum;
};

int main() {

    ios_base::sync_with_stdio(false); cin.tie(NULL);
	// freopen("triangles.in", "r", stdin); freopen("triangles.out", "w", stdout);
    freopen("file.in", "r", stdin);

    ll n; cin>>n;
    vector<point> points(n);
    vector<vector<pair<ll,ll>>> y_values_at_each_x(20005); // <y value, index>
    vector<vector<pair<ll,ll>>> x_values_at_each_y(20005); // <x value, index>
    for(ll i = 0; i < n; i++) {
        cin>>points[i].x>>points[i].y; 
        points[i].x+=10000; points[i].y+=10000;
        y_values_at_each_x[points[i].x].push_back({points[i].y, i});
        x_values_at_each_y[points[i].y].push_back({points[i].x, i});
        points[i].index = i; 
    }

    for(ll i = 0; i < 20005; i++) {
        if(y_values_at_each_x[i].empty()) continue;
        sort(y_values_at_each_x[i].begin(), y_values_at_each_x[i].end());

        for(auto p: y_values_at_each_x[i]) {
            ll sum = 0;
            ll cur_index = p.second;
            ll cur_y_value = p.first;
            for(auto p2: y_values_at_each_x[i]) sum+=abs(p2.first - cur_y_value);
            points[cur_index].height_sum = sum;
        }
    }

    for(ll i = 0; i < 20005; i++) {
        if(x_values_at_each_y[i].empty()) continue;
        sort(x_values_at_each_y[i].begin(), x_values_at_each_y[i].end());

        for(auto p: x_values_at_each_y[i]) {
            ll sum = 0;
            ll cur_index = p.second;
            ll cur_x_value = p.first;
            for(auto p2: x_values_at_each_y[i]) sum+=abs(p2.first - cur_x_value);
            points[cur_index].width_sum = sum;
        }
    }

    ll ans = 0;
    ll MOD = 1e9+7;

    for(point p : points) ans+= (p.height_sum%MOD * p.width_sum%MOD)%MOD;

    cout<<ans<<'\n';

    return 0;
}