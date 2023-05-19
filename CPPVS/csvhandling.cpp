#include<bits/stdc++.h>

using namespace std;

int main(){
    ifstream f1("hocsinh.csv");
    ofstream f2("hocsinhmoi.csv");
    set<string> check;
    while(!f1.eof()){
        string s;
        string res="";
        getline(f1,s);
        int pos;
        for(int i=1;i<s.size();i++){
            if(s[i]==','){
                pos=i-1;
                break;
            }
        }
        for(int i=1;i<pos;i++){
            res+=s[i];
        }
        if(!check.count(res)){
            check.insert(res);
            f2<<s<<endl;
        }
    }    
    return 0;
}