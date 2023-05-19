#include<bits/stdc++.h>
using namespace std;

int main(){
    long long n,k;
    cin>>n>>k;
    map<long long,long long>mp;
    for(long long i=0;i<n;i++){
        long long p;
        cin>>p;
        mp[p%k]++;
    }
    long long ans=0;
    ans+=mp[0];
    for(long long i=1;i<=(k-1)/2;i++){
        ans+=min(mp[i],mp[k-i]);
    }
    if(k%2==0) ans+=mp[k/2]/2;
    cout<<ans;
    return 0;
}