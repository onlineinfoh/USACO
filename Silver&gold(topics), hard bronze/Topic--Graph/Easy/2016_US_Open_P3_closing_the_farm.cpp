// Source: https://usaco.guide/general/io

#include <bits/stdc++.h>
using namespace std;

void dfs(int cur, vector<vector<int>>& conn, vector<bool>& vis){
	if(vis[cur]) return;
	vis[cur] = 1;
	for(int nei: conn[cur]){
		dfs(nei,conn,vis);
	}
}

int main() {
	freopen("closing.in", "r", stdin); freopen("closing.out", "w", stdout);
	int n, m; cin>>n>>m;
	vector<vector<int>> conn(n+1);
	for(int a = 0; a< m; a++){
		int x, y; cin>>x>>y;
		conn[x].push_back(y);
		conn[y].push_back(x);
	}
	vector<int> to_remove(n);
	for(int a = 0; a< n; a++) cin>>to_remove[a];

	vector<bool> visitable(n+1, 1);
	visitable[0] = 0;

	vector<bool> vis(n+1);
	dfs(1,conn,vis);
	if(vis == visitable) cout<<"YES"<<endl;
	else cout<<"NO"<<endl;

	for(int a = 0; a< n-1; a++){
		int cur_remove = to_remove[a];
		visitable[cur_remove] = 0;
		vector<bool> tem(n+1);
		vis = tem;
		for(int nei: conn[cur_remove]){
			conn[nei].erase(remove(conn[nei].begin(), conn[nei].end(), cur_remove), conn[nei].end());
		}
		conn[cur_remove].clear();
		int start_point = -1;
		for(int i = 1; i<= n; i++) if(visitable[i]) start_point = i;
		dfs(start_point,conn,vis);
		if(vis == visitable) cout<<"YES"<<endl;
		else cout<<"NO"<<endl;
	}
}
