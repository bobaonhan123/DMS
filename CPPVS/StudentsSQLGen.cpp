#include<bits/stdc++.h>

using namespace std;

int main(){
    ifstream f1("hocsinhmoi.csv");
    ofstream f2("hocsinhSQL.txt");
    while(!f1.eof()){
        string s;
        getline(f1,s);
        f2<<"INSERT INTO Students VALUES("<<s<<");\n";
    }
    return 0;
}