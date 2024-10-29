#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("taming.in", "r", stdin); freopen("taming.out", "w", stdout);

	int n; cin>>n;
	vector<int> vec(n);
	for(int a = 0; a< n; a++) cin>>vec[a];
	if(vec[0] != 0 && vec[0] != -1){
		cout<<-1;
		return 0;
	}
	vec[0] = 0;
	for(int a = 1; a< n; a++){
		if(vec[a] == -1 ) continue;
		if(vec[a-vec[a]] == -1 || vec[a-vec[a]] == 0){
			int counter = 0;
			for(int i = a-vec[a]; i<= a; i++){
				vec[i] = counter;
				counter++;
			}
		}
		else{
			cout<<-1;
			return 0;
		}
	}
	int mini = 0;
	int add = 0;
	for(int i: vec){
		mini+=i==0;
		add+=i==-1;
	}
	cout<<mini<<" "<<mini+add;
}