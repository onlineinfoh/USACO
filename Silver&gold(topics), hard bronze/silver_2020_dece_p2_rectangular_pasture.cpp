#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
	// freopen("div7.in", "r", stdin); freopen("div7.out", "w", stdout);
    // freopen("file.in", "r", stdin);

    ll n; cin>>n;
    set<int> seen_x, seen_y;
    vector<ll> x(n);
    vector<ll> y(n);
    unordered_map<ll, ll> X_value_rank, Y_value_rank;
    for(ll i = 0; i < n; i++) {
        cin >> y[i] >> x[i];
    }

    // Coordinate compression
    // Essentially, we replace each x and y values with their rank in their respective sorted value array.
    vector<ll> X_holder = x;
    vector<ll> Y_holder = y;
    sort(x.begin(), x.end());
    sort(y.begin(), y.end());
    for(ll i = 0; i < n; i++) X_value_rank[x[i]] = i;
    for(ll i = 0; i < n; i++) Y_value_rank[y[i]] = i;
    // Replace the original x and y values with their compressed ranks.
    for(ll i = 0; i < n; i++) x[i] = X_value_rank[X_holder[i]];
    for(ll i = 0; i < n; i++) y[i] = Y_value_rank[Y_holder[i]];

    vector<vector<ll>> coordinates(n, vector<ll>(n));
    for(ll i = 0; i < n; i++) coordinates[y[i]][x[i]] = 1;

    // Print out the coordinates so that 0,0 is bottom left and n,n is top right.
    // string out = "";
    // for(ll i = 0; i < n; i++) {
    //     string holder = "";
    //     for(ll j = 0; j < n; j++)
    //         holder += to_string(coordinates[i][j])+" ";
    //     out = holder+"\n"+out;
    // }
    // cout<<out;

    // Two prefix sums for the number of 1s above any given points and below any given points, respectively.
    vector<vector<ll>> prefixSum(n, vector<ll>(n));

    // Calculate the number of 1s from (0,0) to (i,j)
    for(ll i = 1; i < n; i++) prefixSum[i][0] = prefixSum[i-1][0] + coordinates[i][0] == 1;
    for(ll j = 1; j < n; j++) prefixSum[0][j] = prefixSum[0][j-1] + coordinates[0][j] == 1;
    for(ll i = 1; i < n; i++){
        for(ll j = 1; j < n; j++){
            prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + coordinates[i][j];
        }
    }

    // Print out the prefix sums so that 0,0 is bottom left and n,n is top right.
    // cout<<"\n";
    // out = "";
    // for(ll i = 0; i < n; i++) {
    //     string holder = "";
    //     for(ll j = 0; j < n; j++)
    //         holder += to_string(prefixSum[i][j])+" ";
    //     out = holder+"\n"+out;
    // }
    // cout<<out;

    ll ans = 0;

    for(ll i = 0; i < n; i++){
        for(ll j = i+1; j<n; j++){
            ll i1 = min(y[i], y[j]);
            ll i2 = max(y[i], y[j]);
            ll j1 = min(x[i], x[j]);
            ll j2 = max(x[i], x[j]);
            ll num_ones_above = 0;
            ll num_ones_below = 0;
            if(i1 >0){
                num_ones_below = prefixSum[i1-1][j2] - prefixSum[i1-1][j1]; 
            }
            if(i2 < n) {
                num_ones_above = prefixSum[n-1][j2] - prefixSum[n-1][j1] - prefixSum[i2][j2] + prefixSum[i2][j1];
            }

            ans+=(num_ones_above+1)*(num_ones_below+1);
        }
    }

    ans+= n + 1;

    cout<<ans;

    return 0;
}