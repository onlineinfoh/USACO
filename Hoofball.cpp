// Source: https://usaco.guide/general/io

#include <bits/stdc++.h>
using namespace std;

vector<int> vec;

int giveto(int i, int n){
	if(i == 0) return 1;
	if(i == n-1) return n-2;
	if(vec[i]-vec[i-1]<=vec[i+1]-vec[i]) return i-1;
	return i+1;
}

int main() {
	freopen("hoofball.in", "r", stdin); freopen("hoofball.out", "w", stdout);
	int n; cin>>n;
	for(int a = 0; a< n; a++){
		int num; cin>>num;
		vec.push_back(num);
	}
	sort(vec.begin(), vec.end());
	vector<int> receive(n);
	for(int a = 0; a< n; a++) receive[giveto(a, n)]++;
	int ans = 0;
	for(int a = 0; a< n; a++){
		if(receive[a] == 0) ans++;
		if(a<giveto(a, n) && giveto(giveto(a, n), n) == a && receive[a] == 1 && receive[giveto(a, n)] == 1) ans++;
	}
	cout<<ans;
}
