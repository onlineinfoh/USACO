// Source: https://usaco.guide/general/io

#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;

int main() {
	// freopen("paintbarn.in", "r", stdin); freopen("paintbarn.out", "w", stdout);
	int n, k; cin>>n>>k;
	vector<vector<int>> grid(1005, vector<int> (1005));
	while(n--){
		int x1,y1,x2,y2; cin>>x1>>y1>>x2>>y2;
		--x2;--y2;
		for(int i = y1; i<=y2; i++) grid[i][x1]++;
		for(int i = y1; i<=y2; i++) grid[i][x2+1]--;
	}
	for(int i = 1; i< 1005; i++){
		for(int j = 1; j< 1005; j++){
			grid[i][j]+=grid[i][j-1];
			//cout<<grid[i][j]<<" ";
		}
		//cout<<endl;
	}
	unordered_map<int, int> um;
	for(int i = 1; i< 1005; i++){
		for(int j = 1; j< 1005; j++){
			um[grid[i][j]]++;
		}
	}
	cout<<um[k];
}
