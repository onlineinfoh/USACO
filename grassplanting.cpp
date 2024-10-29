// Source: https://usaco.guide/general/io
#include <cstdio>

#include <bits/stdc++.h>
using namespace std;
#include<vector>
# include<algorithm>
typedef long long ll;

int main() {
	freopen("planting.in", "r", stdin);freopen("planting.out", "w", stdout);
	ll nodes;
	cin>>nodes;

	vector<vector<ll>> edges(100005);

	for(ll a = 0; a< nodes-1; a++){
		ll one, two;
		cin>>one>>two;
		edges[one].push_back(two);
		edges[two].push_back(one);
	}

	ll ans = 0;

	for(int j = 1; j<= nodes; j++){
		ll counter = 0;

		for(ll x: edges[j]){
			counter++;
		}

		ans = max(ans, counter);
	}

	cout<< ans+1;
	return 0;
}
