#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
	ll n; cin>>n;
	string s; cin>>s;
	vector<ll> range(n);
	for(int a = 0; a< n; a++) cin>>range[a];
	vector<ll> GpreSum(n+1);
	vector<ll> HpreSum(n+1);
	ll Gtot = 0;
	ll Htot = 0;
	for(int a = 1; a<= n; a++){
		if(s[a-1] == 'G'){
			GpreSum[a] = 1;
			Gtot++;
		}
		else{
			HpreSum[a] = 1;
			Htot++;
		}
	}
	for(int a = 1; a<= n; a++){
		GpreSum[a]+=GpreSum[a-1];
		HpreSum[a]+=HpreSum[a-1];
	}

	ll G_contains_its_breed = 0;
	ll H_contains_its_breed = 0;

	for(int a = 0; a< n; a++){
		if(s[a] == 'G'){
			if(GpreSum[range[a]]-GpreSum[a] == Gtot)
				G_contains_its_breed = a+1;
		}
		else{
			if(HpreSum[range[a]]-HpreSum[a] == Htot)
				H_contains_its_breed = a+1;
		}
	}

	ll ans = 0;

	// Be careful with the indexing
	for(int a = 0; a< n; a++){
		if(s[a] == 'G'){
			if(G_contains_its_breed == a+1){
				if(H_contains_its_breed && H_contains_its_breed>a+1){
					ans++;
				}
			}
			else{
				if(H_contains_its_breed && H_contains_its_breed<=range[a] && H_contains_its_breed>a+1){
					ans++;
				}
			}
		}
		else{
			if(H_contains_its_breed == a+1){
				if(G_contains_its_breed && G_contains_its_breed>a+1){
					ans++;
				}
			}
			else{
				if(G_contains_its_breed && G_contains_its_breed<=range[a] && G_contains_its_breed>a+1){
					ans++;
				}
			}
		}
	}

	cout<<ans;

	//cout<<G_contains_its_breed<<endl<<H_contains_its_breed;
}