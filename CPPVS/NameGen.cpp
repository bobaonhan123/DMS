#include<bits/stdc++.h>

using namespace std;

int main(){
    ifstream f1("Ho.csv");
    ifstream f2("TenDem.csv");
    ifstream f3("Ten.csv");
    ofstream f4("Hovaten.txt");
    vector<string>Ho;
    vector<string>TenDem;
    vector<string>Ten;
    while(!f1.eof()){
        string s;
        getline(f1,s);
        Ho.push_back(s);
        
    }
    while(!f2.eof()){
        string s;
        getline(f2,s);
        TenDem.push_back(s);
        
    }
    while(!f3.eof()){
        string s;
        getline(f3,s);
        Ten.push_back(s);
    }
    srand(time(NULL));
    for(int i=0;i<1500;i++){
        string s=Ho[rand() % Ho.size()]+" "+TenDem[rand() % TenDem.size()]+" "+Ten[rand()%Ten.size()];
        if(s[0]==' ') s.erase(0,1);
        f4<<s<<endl;
    }
    return 0;
}