#include<bits/stdc++.h>

using namespace std;

int main(){
    ifstream f1("Hovaten.txt");
    ofstream f2("Hotenmoi.txt");
    while(!f1.eof()){
        string s;
        getline(f1,s);
        f2<<"'"<<s<<"'\n";
    }
    return 0;
}