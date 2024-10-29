#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("art.in", "r", stdin); freopen("art.out", "w", stdout);

	int n; cin>>n;
	vector<vector<int>> vec(n);
	unordered_set<int> seen;
	for(int a = 0; a< n; a++){
		string s; cin>>s;
		for(char c: s){
			vec[a].push_back(c-'0');
			seen.insert(c-'0');
		}
	}
	unordered_set<int> not_ok;
	for(int a = 1; a<= 9; a++){
		if(seen.find(a) == seen.end()) continue;
		int low_x = 1000, low_y = 1000;
		int max_x = -1, max_y = -1;
		for(int i = 0; i< n; i++){
			for(int j = 0; j< n; j++){
				if(vec[i][j] == a){
					low_x = min(low_x, j);
					max_x = max(max_x, j);
					low_y = min(low_y, i);
					max_y = max(max_y, i);
				}
			}
		}
		for(int i = low_y; i<= max_y; i++){
			for(int j = low_x; j<=max_x; j++){
				if(vec[i][j] != a) not_ok.insert(vec[i][j]);
			}
		}
	}
	int ans = 0;
	for(int a = 1; a<=9; a++){
		if(seen.find(a)!= seen.end() && not_ok.find(a) == not_ok.end()) ans++;
	}
	cout<<ans;
}