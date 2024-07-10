// Source: https://usaco.guide/general/io

#include <cstdio>

#include <bits/stdc++.h>
using namespace std;
#include<vector>
# include<algorithm>

int main() {

	freopen("blist.in", "r", stdin);
	freopen("blist.out", "w", stdout);

	int len; cin >>len;
	
	vector<vector<int>> vec(len);

	for(int a = 0; a< len; a++){
		int one, two, thr;
		cin >> one >> two >> thr;

		vec[a].push_back(one);
		vec[a].push_back(two);
		vec[a].push_back(thr);
	}

	std::sort(vec.begin(), vec.end(), [](const std::vector<int>& a, const std::vector<int>& b) {
        return a[0] < b[0];
    });

	int ans = 0;
	vector<int> time(2000);
	for(int c = 0; c< 2000; c++){
		time[c] = 0;
	}

	for(vector<int> i: vec){
		int start = i[0];
		int end = i[1];
		int need = i[2];
		int avail = min(time[start], time[end]);

		int use = need - avail;

		if(use>0){
			ans+=use;
			for(int a = end+1; a<=1500; a++){
				time[a]+=use;
			}
			for(int b = start; b<= end; b++){
				time[b]-=avail;
			}
		}
		else if(use == 0){
			for(int a = start; a<= end; a++){
				time[a]-= need;
			}
		}
		else{
			for(int a = start; a<= end; a++){
				time[a]-=need;
			}
		}
	}
	cout<< ans;

	return 0;
}
