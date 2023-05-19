#include<bits/stdc++.h>

using namespace std;

int main(){
    ifstream f1("Untitled1.csv");
    ofstream f2("SQL.txt");
    string s;
    while(!f1.eof()){
        getline(f1,s);
        f2<<"INSERT INTO Rooms(RoomNumber,Type,Gender,BuildingID) VALUES ("<<s<<");"<<endl;
    }
    return 0;
}