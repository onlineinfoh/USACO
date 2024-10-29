// Source: https://usaco.guide/general/io

#include <bits/stdc++.h>
using namespace std;

int counter = 0;

void dfs(int cur, vector<vector<int>>& conn, vector<bool>& vis){
	if(vis[cur]) return;
	vis[cur] = 1;
	counter++;
	for(int nei: conn[cur]){
		dfs(nei,conn,vis);
	}
}

int main() {
	freopen("moocast.in", "r", stdin); freopen("moocast.out", "w", stdout);
	int n; cin>>n;
	vector<vector<int>> input(n+1); // (x, y, power)
	for(int a = 1; a<=n; a++){
		int x, y, p; cin>>x>>y>>p;
		input[a].push_back(x);
		input[a].push_back(y);
		input[a].push_back(p);
	}
	vector<vector<int>> conn(n+1);

	for(int a = 1; a<= n; a++){
		for(int b = a+1; b<=n; b++){
			double one_x = input[a][0], one_y = input[a][1], one_power = input[a][2];
			double two_x = input[b][0], two_y = input[b][1], two_power = input[b][2];
			double dis = sqrt(abs(one_x-two_x) * abs(one_x-two_x) + abs(one_y-two_y) * abs(one_y-two_y));
			if(dis<=one_power) conn[a].push_back(b);
			if(dis<=two_power) conn[b].push_back(a);
		}
	}
	int ans = -1;
	for(int a = 1; a<= n; a++){
		vector<bool> vis(n+1);
		dfs(a,conn,vis);
		ans = max(ans, counter);
		counter = 0;
	}
	cout<<ans;
	/*
	for(int a = 1; a<= n; a++){
		cout<<a<<": ";
		for(int i: conn[a]) cout<<i<<" ";
		cout<<endl;
	}
	*/
}
