#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("outofplace.in", "r", stdin); freopen("outofplace.out", "w", stdout);

	int n; cin>>n;
	vector<int> vec(n);
	for(int a = 0; a< n; a++) cin>>vec[a];
	if(n == 2){
		if(vec[0]<=vec[1]) cout<<0;
		else cout<<1;
		return 0;
	}
	vector<int> tem = vec;
	sort(tem.begin(), tem.end());
	if(tem == vec){
		cout<<0;
		return 0;
	}
	int diff = -1;
	bool mini = true;
	for(int a = 2; a< n; a++){
		if(vec[a]<vec[a-1] && vec[a]<vec[a-2]){
			mini = true;
			diff = a;
		}
	}
	for(int a = 1; a<n-1; a++){
		if(vec[a]>vec[a-1] && vec[a]>vec[a+1] && vec[a+1]>=vec[a-1]){
			mini = false;
			diff = a;
		}
	}

	if(mini){
		unordered_set<int> set;
		set.insert(vec[0]);
		int a = 1;
		bool ok = true;
		for(a = 1; a< n; a++){
			if(vec[a]<vec[a-1]){
				ok = false;
				break;
			}
			set.insert(vec[a]);
		}
		if(ok){
			cout<<0;
			return 0;
		}
		int ans = 0;
		for(int i: set) if(i>vec[a]) ans++;
		cout<<ans;
	}
	else{
		unordered_set<int> set;
		set.insert(vec[n-1]);
		int a = n-2;
		bool ok = true;
		for(a = n-2; a>=0; a--){
			if(vec[a]>vec[a+1]){
				ok = false;
				break;
			}
			set.insert(vec[a]);
		}
		if(ok){
			cout<<0;
			return 0;
		}
		int ans = 0;
		for(int i: set) if(i<vec[a]) ans++;
		cout<<ans;
	}
}