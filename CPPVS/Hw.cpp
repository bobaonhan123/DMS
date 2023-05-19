#include<iostream>
#include<cmath>
using namespace std;
bool isPrime(int n){
    if(n<2) return false;
    for(int i=2;i<=sqrt(n);i++){
        if(n%i==0) return false;
    }
    return true;
}
int main(){
    int n;
    cin>>n;
    int a[100001];
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    int b[100001];
    int j=0;
    for(int i=0;i<n;i++){
        if(isPrime(a[i])){
            b[j]=a[i];
            j++;
        }
    }
    for(int i=0;i<j;i++){
        cout<<b[i]<<" ";
    }
    return 0;
}