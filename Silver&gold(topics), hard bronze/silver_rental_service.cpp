#include <bits/stdc++.h>
using namespace std;
using ll = long long;

bool compare(pair<ll, ll> a, pair<ll, ll> b) {
    return a.second > b.second;
}

int main() {

    ios_base::sync_with_stdio(false); cin.tie(NULL);
	// freopen("rental.in", "r", stdin); freopen("rental.out", "w", stdout);
    freopen("file.in", "r", stdin);

    ll size = 1e6+2;

    ll n, m, k; cin>>n>>m>>k;

    vector<ll> productions(size);
    vector<ll> rent(size);
    vector<pair<ll,ll>> price;
    for(ll i = 0; i < n; i++) cin>>productions[i];
    for(ll i = 0; i < m; i++){
        ll a, b; cin>>a>>b;
        price.push_back({a, b}); // gallons, price per gallon
    }
    for(ll i = 0; i < k; i++) cin>>rent[i];

    sort(rent.begin(), rent.end(), greater<ll>());

    vector<ll> profits_by_rent(size);
    for(ll i = 0; i < size; i++) profits_by_rent[i+1] = rent[i];
    for(ll i = 1; i < size; i++) profits_by_rent[i] += profits_by_rent[i-1];

    vector<ll> profits_by_using(size);

    sort(productions.begin(), productions.end(), greater<ll>());

    sort(price.begin(), price.end(), compare);

    ll j = 0;
    for(ll i = 0; i < size; i++) {
        ll gallons = 0;
        while(productions[i] != 0 && j<m && price[j].first > 0) {
            gallons = min(productions[i], price[j].first);
            productions[i] -= gallons;
            price[j].first -= gallons;
            profits_by_using[i+1] += gallons * price[j].second;
            if(j<m && price[j].first==0) j++;
            // if(i==1) cout<<gallons<<" ";
        }
    }

    // cout<<profits_by_using[2]<<" ";

    for(ll i = 2; i < size; i++) profits_by_using[i] += profits_by_using[i-1];

    ll ans = 0;
    for(ll i = 0; i <= n; i++) ans = max(ans, profits_by_rent[i] + profits_by_using[n-i]);
    
    cout<<ans<<'\n';

    return 0;
}