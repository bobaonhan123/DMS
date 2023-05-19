#include<bits/stdc++.h>

using namespace std;

int main(){
    srand(time(NULL));
    ifstream f1("HoTenKhongDau.txt");
    ofstream f2("Email.txt");
    ofstream f3("School.txt");
    vector<string> MailTail;
    vector<string> cl;
    set<string> se;
    cl.push_back(".22git");
    for(int i=0;i<5;i++){
        cl.push_back(".22it");
        cl.push_back(".21it");
    }
    cl.push_back(".22gba");
    cl.push_back(".22ba");
    cl.push_back(".21ba");
    cl.push_back(".21git");

    for(int i=0;i<9;i++)
        MailTail.push_back("@vku.udn.vn");
    MailTail.push_back("@smp.udn.vn");
    while(!f1.eof()){
        string truong;
        string s;
        string res="";
        getline(f1,s);
        while(true);
        {
        int pos;
        for(int i=s.size()-1;i>=0;i--){
            if(s[i]==' '){
                pos=i;
                break;
            }
            if(s[i]>='A' && s[i]<='Z')
                s[i]+=32;
            res=s[i]+res;
        }
        for(int i=0;i<pos;i++){
            if(s[i]>='A' && s[i]<='Z'){
                res+=(s[i]+32);
            }
        }
        string tail=MailTail[rand() % MailTail.size()];
        
        if(tail[1]=='v'){
            res+=cl[rand() % cl.size()];
            truong="'VKU'";
        }
        else truong="'SMP'";
        res+=tail;
        if(!se.count(res)){
            se.insert(res);
            break;
        }
        srand(time(NULL));
        }
        f3<<truong<<endl;
        f2<<"'"<<res<<"'"<<endl;

    }
    return 0;
}