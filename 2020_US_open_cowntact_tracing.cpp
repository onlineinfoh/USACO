#include <bits/stdc++.h>
using namespace std;

bool work(int start, int K, vector<int>& infection, vector<vector<int>>& interactions){
	vector<int> infection_times(infection.size());
	vector<int> tem(infection.size()); 
	tem[start] = 1;
	for(auto it: interactions){
		int one = it[1]; --one;
		int two = it[2]; --two;
		if(tem[one] == 1 && tem[two] == 1){
			infection_times[one]++;
			infection_times[two]++;
			continue;
		}
		if(tem[one] == 1){
			if(infection_times[one]<K) tem[two] = 1;
			infection_times[one]++;
		}
		else if(tem[two] == 1){
			if(infection_times[two]<K) tem[one] = 1;
			infection_times[two]++;
		}
	}
	return tem == infection;
}

int main() {
	freopen("tracing.in", "r", stdin);
	freopen("tracing.out", "w", stdout);
	int len, T; cin>>len>>T;
	string s; cin>>s;
	vector<vector<int>> interactions;
	for(int a = 0; a< T; a++){
		vector<int> tem; int v, b, n; cin>>v>>b>>n;
		tem.push_back(v);
		tem.push_back(b);
		tem.push_back(n);
		interactions.push_back(tem);
	}
	sort(interactions.begin(), interactions.end());
	vector<int> infection;
	for(char c: s) infection.push_back(c-'0');

	vector<bool> possI(infection.size());
	vector<bool> possK(252);
	for(int i = 0; i< infection.size(); i++){
		if(infection[i] == 0) continue;
		for(int j = 0; j<= 251; j++){
			if(work(i, j, infection, interactions)){
				possI[i] = true;
				possK[j] = true;
			}
		}
	}
	int ans = 0;
	int mini = 1e9;
	int maxi = 0;
	for(int i = 0; i<infection.size(); i++) if(possI[i]) ans++;
	for(int i = 0; i<=251; i++) if(possK[i]) mini = min(i, mini);
	for(int i = 0; i<=251; i++) if(possK[i]) maxi = max(i, maxi);
	cout<<ans<<" "<<mini<<" ";
	if(maxi == 251) cout<< "Infinity";
	else cout<< maxi;
}