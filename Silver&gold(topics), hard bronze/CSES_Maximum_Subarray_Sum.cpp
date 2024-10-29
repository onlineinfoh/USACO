#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
	// freopen("div7.in", "r", stdin); freopen("div7.out", "w", stdout);
    // freopen("file.in", "r", stdin);

    ll n;cin>>n;
    ll curPrefix = 0;
    ll miniPrefix = 1e10;
    ll ans = -1e10;
    while(n--){
        ll num; cin>>num; curPrefix+=num;
        ans = max(ans, curPrefix - miniPrefix);
        ans = max(ans, curPrefix);
        miniPrefix = min(miniPrefix, curPrefix);
    }
    cout<<ans;
}