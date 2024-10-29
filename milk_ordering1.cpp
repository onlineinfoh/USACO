#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("milkorder.in", "r", stdin); freopen("milkorder.out", "w", stdout);

	int n, m, k; cin>>n>>m>>k;
	vector<int> order(m);
	for(int a = 0; a< m; a++) cin>>order[a];
	vector<int> taken(105, -1);
	for(int a = 0; a< k; a++){
		int x, y; cin>>x>>y;
		if(x==1){
			cout<<y;
			return 0;
		}
		taken[y] = x;
	}

	for(int i = 1; i<=n; i++){
		if(taken[i] == -1){
			int mark = i;
			i++;
			while(taken[i] == -1){
				i++;
				if(i>=103){
					cout<<mark;
					return 0;
				}
			}
			int length_available = i-mark;

			auto it = find(order.begin(), order.end(), 1);
			auto it2 = find(order.begin(), order.end(), taken[i]);
			int one = distance(order.begin(), it);
			int two = distance(order.begin(), it2);

			if(it!=order.end() && it2 == order.end()){
				int dis = distance(order.begin(), it);
				if(length_available==dis){
					for(int z = 0; z< dis; z++) order.erase(order.begin());
					continue;
				}
			}

			if(find(order.begin(), order.end(), taken[i]) == order.end()){
				cout<<mark;
				return 0;
			}

			int counter = 0;
			while(order[0]!=taken[i]){
				if(order[0] == 1){
					cout<<mark+counter;
					return 0;
				}
				counter++;
				order.erase(order.begin());
			}
			order.erase(order.begin());
			if(one > two){
				continue;
			}
			if(length_available<=counter){
				;
			}
			else{
				cout<<mark;
				return 0;
			}
		}
	}


	// auto it = find(order.begin(), order.end(), 5);
	// cout<<distance(order.begin(), it);
}