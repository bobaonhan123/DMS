#include<bits/stdc++.h>

using namespace std;

int main(){
    ifstream f1("TenNu.txt");
    ifstream f2("HoTenKhongDau.txt");
    ofstream f3("gender.txt");
    int slnu=0;
    set<string>nu;
    while(!f1.eof()){
        string s;
        getline(f1,s);
        nu.insert(s);
    }
    while(!f2.eof()){
        string s;
        getline(f2,s);
        string res="";
        for(int i=s.size()-1;i>=0;i--){
            if(s[i]==' ') break;
            res=s[i]+res;
        }
        f3<<nu.count(res)<<endl;
        slnu+=nu.count(res);
    }
    cout<<slnu;
    return 0;
}