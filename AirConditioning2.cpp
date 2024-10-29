#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int ans = INT_MAX;

bool ok(vector<int>& prev, vector<int>& vec) {
    for (int a = 0; a < 103; a++) {
        if (vec[a] > prev[a]) return false;
    }
    return true;
}

vector<vector<bool>> generateBoolCombinations(int n) {
    vector<vector<bool>> combinations;
    int totalCombinations = 1 << n; // 2^n combinations

    // Loop through all possible combinations
    for (int i = 0; i < totalCombinations; ++i) {
        vector<bool> combination(n);

        // Generate the combination for the current number 'i'
        for (int j = 0; j < n; ++j) {
            combination[j] = (i & (1 << j)) != 0;
        }

        combinations.push_back(combination);
    }

    return combinations;
}

int main() {
	int n, m; cin>>n>>m;
	vector<int> vec(103);
	while(n--){
		int x, y, val; cin>>x>>y>>val;
		for(int a = x; a<= y; a++) vec[a] = val;
	}
	vector<vector<int>> ACs(1); // inner vector is 0-indexed
	for(int i = 0; i< m; i++){
		int a, b, c, d; cin>>a>>b>>c>>d;
		ACs.push_back({a, b, c, d});
	}
    vector<vector<bool>> combinations = generateBoolCombinations(m);
    for(vector<bool> v: combinations){
        vector<int> tem(103);
        int curCost = 0;
        for(int a = 0; a< m; a++){
            if(v[a]){
                for(int x = ACs[a+1][0]; x<= ACs[a+1][1]; x++){
                    tem[x] += ACs[a+1][2];
                }
                curCost+=ACs[a+1][3];
            }
        }
        if(ok(tem, vec)) ans = min(ans, curCost);
    }
    cout<<ans;
}