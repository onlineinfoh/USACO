// Source: https://usaco.guide/general/io
#include <cstdio>

#include <bits/stdc++.h>
using namespace std;
#include<vector>
# include<algorithm>
typedef long long ll;

int main() {
	//freopen("revegetate.in", "r", stdin);
	//freopen("revegetate.out", "w", stdout);

	ll pasture, cows;

	cin >> pasture >> cows;

	ll A[160];
	ll B[160];

	for(int a = 0; a< cows; a++){
		int one, two, hold;
		cin >> one >> two;

		if(one>two){
			hold = one;
			one = two;
			two = hold;
		}

		A[a] = one;  // if want to use 0-index, must change the input 
		B[a] = two;  // (--one, --two)

	}
	ll ans[pasture+1]; // not 0-index (because the input pastures are not 0-index)
	for(int b = 1; b<= pasture; b++){
		for(int i = 1; i<=4; i++){
			bool ok = true;
			for(int c = 0; c< cows; c++){
				if(B[c] == b){
					if(i == ans[A[c]]){
						ok = false;
					}
				}
			}
			if(ok){
				ans[b] = i;
				break;
			}
		}
	}

	for(int x = 1; x<= pasture; x++){
		cout<<ans[x]<<"";
	}

	return 0;
}