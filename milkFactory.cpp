// Source: https://usaco.guide/general/io
#include <cstdio>
#include <bits/stdc++.h>
using namespace std;
#include<vector>
# include<algorithm>
typedef long long ll;

vector<vector<int>> edges(105); // one-way

int dfs(int num){
	int hold = 0;
	if(edges[num].empty()) return hold;
	for(int n: edges[num]){
		hold++;
		hold+=dfs(n);
	}
	return hold;
}

int main() {
	freopen("factory.in", "r", stdin);
	freopen("factory.out", "w", stdout);
	int len;
	cin>>len;
	for(int hi = 0; hi< len-1; hi++){
		int a, b;
		cin>>a>>b;
		edges[b].push_back(a);
	}

	for(int i = 1; i< 105; i++){
		if(dfs(i) == len-1){
			cout<<i;
			return 0;
		}
	}

	cout<< -1;
	return 0;
}
