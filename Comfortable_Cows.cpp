// Source: https://usaco.guide/general/io

#include <bits/stdc++.h>
using namespace std;

int main() {
	int grid[1001][1001];
	bool happy[1001][1001];
	bool occupied[1001][1001];
	int count = 0;
	int T; cin>>T;
	while(T--){
		int x, y; cin>>x>>y;
		occupied[x][y] = true;
		int adj = 0;
		if(x-1>=0){
			grid[x-1][y]++;
			if(occupied[x-1][y]) adj++;
		}
		if(x+1<=1000){
			grid[x+1][y]++;
			if(occupied[x+1][y]) adj++;
		}
		if(y-1>=0){
			grid[x][y-1]++;
			if(occupied[x][y-1]) adj++;
		}
		if(y+1<=1000){
			grid[x][y+1]++;
			if(occupied[x][y+1]) adj++;
		}

		if(adj == 3) count++;
		if(adj == 4) count--;

		if(x-1>=0){
			if(occupied[x-1][y]&&!happy[x-1][y] && grid[x-1][y]==3){
				happy[x-1][y] = true;
				count++;
			}
			if(happy[x-1][y] && grid[x-1][y]==4){
				count--;
			}
		}
		if(x+1<=1000){
			if(occupied[x+1][y]&&!happy[x+1][y] && grid[x+1][y]==3){
				happy[x+1][y] = true;
				count++;
			}
			if(happy[x+1][y] && grid[x+1][y]==4){
				count--;
			}
		}
		if(y-1>=0){
			if(occupied[x][y-1]&&!happy[x][y-1] && grid[x][y-1]==3){
				happy[x][y-1] = true;
				count++;
			}
			if(happy[x][y-1] && grid[x][y-1]==4){
				count--;
			}
		}
		if(y+1<=1000){
			if(occupied[x][y+1]&&!happy[x][y+1] && grid[x][y+1]==3){
				happy[x][y+1] = true;
				count++;
			}
			if(happy[x][y+1] && grid[x][y+1]==4){
				count--;
			}
		}
		cout<<count<<endl;
	}
}
