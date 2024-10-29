#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const ll inf = 1e18;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
	// freopen("mountains.in", "r", stdin); freopen("mountains.out", "w", stdout);
    // freopen("file.in", "r", stdin);

    ll n, q; cin>>n>>q;
    vector<string> inputs(n);
    for(ll i = 0; i < n; i++) cin>>inputs[i];

    vector<ll> groups(n+5);
    ll group_count = 0;

    for(ll i = 0; i < n; i++){
        if(i%2==0) groups[i] = group_count;
        if(inputs[i] == "or") group_count++;
    }

    vector<ll> true_groups(n+5,1);

    // FUCKKKKKKKKK
    for(ll i = 0; i< n; i+=2) true_groups[groups[i]]*=(inputs[i]=="true");

    // for(ll i = 0; i < n; i++) cout<<i<<": "<<groups[i]<<"\n";

    ll first_true = inf, last_true = -1;

    // cout<<true_groups[groups[0]]<<" ";

    for(ll i = 0; i< n; i+=2) if(true_groups[groups[i]]==1){
        if(first_true == inf) first_true = groups[i];
        // cout<<first_true;
        last_true = groups[i];
    }

    vector<pair<ll,ll>> false_groups(n+5, {inf,-1}); // first false within a group, last false within a group

    for(ll i = 0; i< n; i+=2){
        if(inputs[i] == "false"){
            if(false_groups[groups[i]].first == inf) false_groups[groups[i]].first = i;
            false_groups[groups[i]].second = i;
        }
    }

    while(q--){
        ll l, r; cin>>l>>r; --l; --r;
        ll left_group = groups[l];
        ll right_group = groups[r];
        string want; cin>>want;

        if(first_true<left_group || last_true>right_group){
            cout<<(want=="true"?"Y":"N");
            continue;
        }
        
        if(want=="false"){
            cout<<"Y";
            continue;
        }

        ll l_false = false_groups[groups[l]].first;
        ll r_false = false_groups[groups[r]].second;
        if(l_false<l || r_false>r){
            cout<<"N"; 
            // cout<<false_groups[l].first;
            // cout<<((r_false>r && (r_false!=inf)));
        }
        else cout<<"Y";
    }
    return 0;
}