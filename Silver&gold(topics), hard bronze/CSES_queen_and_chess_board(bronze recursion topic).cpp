#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const ll inf = 1e18;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
	// freopen("sort.in", "r", stdin); freopen("sort.out", "w", stdout);
    // freopen("file.in", "r", stdin);

    vector<ll> vec = {0,1,2,3,4,5,6,7};

    vector<vector<ll>> board(8, vector<ll>(8));

    for(int i=0; i<8; i++){
        string s; cin>>s;
        for(int j=0; j<8; j++) board[i][j] = s[j]=='*';
    }

    ll ans = 0;

    do{
        bool ok = true;
        for(int i=0; i<8; i++){
            if(board[vec[i]][i]) ok = false;
        }

        vector<ll> combinations_of_diagonals(15);

        for(int i=0; i<8; i++){
            if(combinations_of_diagonals[vec[i]+i]) ok = false;
            combinations_of_diagonals[vec[i]+i] = 1;
        }

        combinations_of_diagonals = vector<ll>(15);

        for(int i=0; i<8; i++){
            if(combinations_of_diagonals[7-vec[i]+i]) ok = false;
            combinations_of_diagonals[7-vec[i]+i] = 1;
        }

        if(ok) ans++;
    }
    while(next_permutation(vec.begin(), vec.end()));

    cout<<ans<<'\n';

    return 0;
}