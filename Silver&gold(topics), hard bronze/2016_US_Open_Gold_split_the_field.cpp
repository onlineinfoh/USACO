#include <bits/stdc++.h>
using namespace std;
using ll = long long;

struct Point{
    ll x, y;
};

bool compareX(const Point& a, const Point& b) {
        return a.x < b.x;
    }

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
	freopen("split.in", "r", stdin); freopen("split.out", "w", stdout);
    // freopen("file.in", "r", stdin);

    ll maxY = -1;
    ll minY = 1e10;

    ll n; cin>>n;
    vector<Point> coordinates(n);
    for(ll i = 0; i < n; i++) {
        ll x, y; cin>>x>>y;
        maxY = max(maxY, y);
        minY = min(minY, y);
        coordinates[i].x = x;
        coordinates[i].y = y;
    }

    sort(coordinates.begin(), coordinates.end(), compareX);

    vector<ll> X; for(auto p:coordinates) X.push_back(p.x);
    vector<ll> Y; for(auto p:coordinates) Y.push_back(p.y);

    vector<ll> XMinPrefix(n); XMinPrefix[0] = X[0];
    vector<ll> XMinSuffix(n); XMinSuffix[n-1] = X[n-1];
    vector<ll> YMinPrefix(n); YMinPrefix[0] = Y[0];
    vector<ll> YMinSuffix(n); YMinSuffix[n-1] = Y[n-1];
    vector<ll> XMaxPrefix(n); XMinPrefix[0] = X[0];
    vector<ll> XMaxSuffix(n); XMinSuffix[n-1] = X[n-1];
    vector<ll> YMaxPrefix(n); YMinPrefix[0] = Y[0];
    vector<ll> YMaxSuffix(n); YMinSuffix[n-1] = Y[n-1];
    for(ll i = 1; i < n; i++) {
        XMinPrefix[i] = min(XMinPrefix[i-1], X[i]);
        YMinPrefix[i] = min(YMinPrefix[i-1], Y[i]);
        XMaxPrefix[i] = max(XMaxPrefix[i-1], X[i]);
        YMaxPrefix[i] = max(YMaxPrefix[i-1], Y[i]);
    }
    for(ll i = n-2; i >= 0; i--) {
        XMinSuffix[i] = min(XMinSuffix[i+1], X[i]);
        YMinSuffix[i] = min(YMinSuffix[i+1], Y[i]);
        XMaxSuffix[i] = max(XMaxSuffix[i+1], X[i]);
        YMaxSuffix[i] = max(YMaxSuffix[i+1], Y[i]);
    }

    ll ans = 0;

    ll tot = (X[n-1] - X[0]) * (maxY - minY);

    for(ll i = 0; i < n-1; i++) {
        ll area = (YMaxPrefix[i] - YMinPrefix[i]) * (X[i] - X[0]) + (YMaxSuffix[i+1] - YMinSuffix[i+1]) * (X[n-1] - X[i+1]);
        // cout<<area<<endl;
        ans = max(ans, tot - area);
    }



    // Do horizontal search as well

    for(auto& p : coordinates) swap(p.x, p.y);

    sort(coordinates.begin(), coordinates.end(), compareX);

    X.clear(); for(auto p:coordinates) X.push_back(p.x);
    Y.clear(); for(auto p:coordinates) Y.push_back(p.y);

    XMinPrefix[0] = X[0];
    XMinSuffix[n-1] = X[n-1];
    YMinPrefix[0] = Y[0];
    YMinSuffix[n-1] = Y[n-1];
    XMinPrefix[0] = X[0];
    XMinSuffix[n-1] = X[n-1];
    YMinPrefix[0] = Y[0];
    YMinSuffix[n-1] = Y[n-1];
    for(ll i = 1; i < n; i++) {
        XMinPrefix[i] = min(XMinPrefix[i-1], X[i]);
        YMinPrefix[i] = min(YMinPrefix[i-1], Y[i]);
        XMaxPrefix[i] = max(XMaxPrefix[i-1], X[i]);
        YMaxPrefix[i] = max(YMaxPrefix[i-1], Y[i]);
    }
    for(ll i = n-2; i >= 0; i--) {
        XMinSuffix[i] = min(XMinSuffix[i+1], X[i]);
        YMinSuffix[i] = min(YMinSuffix[i+1], Y[i]);
        XMaxSuffix[i] = max(XMaxSuffix[i+1], X[i]);
        YMaxSuffix[i] = max(YMaxSuffix[i+1], Y[i]);
    }

    for(ll i = 0; i < n-1; i++) {
        ll area = (YMaxPrefix[i] - YMinPrefix[i]) * (X[i] - X[0]) + (YMaxSuffix[i+1] - YMinSuffix[i+1]) * (X[n-1] - X[i+1]);
        // cout<<area<<endl;
        ans = max(ans, tot - area);
    }

    cout<<ans;

    cout<<(-1==false);

    return 0;
}