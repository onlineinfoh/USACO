#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
	int tt; cin>>tt;
	while(tt--){
		int n; cin>>n;
		vector<vector<ll>> info(n, vector<ll>(3)); // ranks, heights, speeds
		for(int a = 0; a< n; a++) cin>>info[a][1];
		for(int a = 0; a< n; a++) cin>>info[a][2];
		for(int a = 0; a< n; a++) cin>>info[a][0];
		if(n == 1){
			cout<<0<<endl;
			continue;
		}

		sort(info.begin(), info.end());

		ll ans = 0;
		ll max_days = LLONG_MAX;

		for(int a = 0; a< n-1; a++){
			ll curHeight = info[a][1];
			ll curSpeed = info[a][2];
			ll nextHeight = info[a+1][1];
			ll nextSpeed = info[a+1][2];
			if(curHeight>nextHeight){
				if(curSpeed>=nextSpeed){
					;
				}
				else{
					if((curHeight-nextHeight)%(nextSpeed-curSpeed) == 0)
						max_days = min(max_days, (curHeight-nextHeight)/(nextSpeed-curSpeed)-1);
					else
						max_days = min(max_days, (curHeight-nextHeight)/(nextSpeed-curSpeed));
				}
			}
			else{
				if(curSpeed<=nextSpeed){
					ans = LLONG_MAX;
					break;
				}
				else{
					ans = max(ans, (nextHeight-curHeight) / (curSpeed-nextSpeed) + 1 );
				}
			}
		}

		if(ans == LLONG_MAX || ans>max_days){
			cout<<-1<<endl;
			continue;
		}

		cout<<ans<<endl;

		/*
		for(int a = 0; a< n; a++) cout<<info[a][1]<<" "; cout<<endl;
		for(int a = 0; a< n; a++) cout<<info[a][2]<<" "; cout<<endl;
		for(int a = 0; a< n; a++) cout<<info[a][0]<<" "; cout<<endl;
		*/
	}
}