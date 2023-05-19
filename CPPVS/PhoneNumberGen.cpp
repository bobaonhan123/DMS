#include<bits/stdc++.h>

using namespace std;

int main(){
    set<string> check;
    ofstream f1("PhoneNumber.txt");
    srand(time(NULL));
    for(int i=0;i<1501;i++){
        string s="0";
        while(check.count(s))
        {
        for(int i=0;i<10;i++){
            s+=(rand()%10+'0');
        }
        }
        check.insert(s);
        if(s!="0")
            f1<<"'"<<s<<"'"<<endl;
    }
    return 0;
}