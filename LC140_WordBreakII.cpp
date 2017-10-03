#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <unordered_map>

using namespace std;

vector<string> helper(string s, unordered_map<string, vector<string> >mp, unordered_set<string> dict, int len);
int main(){
    cout << "input dictionary end with 0" << endl;
    string str; 
    unordered_set<string> set;
    unordered_map<string, vector<string> > map;
    int maxLen = 0;
    while(1){
        cin >> str;
        if(str[0] == '0') break;
        set.insert(str);
        maxLen = max(maxLen, (int)str.length());
    }
    cout << "maxLen = " << maxLen << endl;
    cout << "input target string: " << endl;
    string target;
    cin >> target;
    vector<string> res = helper(target, map, set, maxLen);
    if(res.size() == 0){
        cout << "no solution" << endl;
        return 0;
    }
    for(string str : res){
        cout << str << endl;
    }
    return 0;
}

vector<string> helper(string s, unordered_map<string, vector<string> >mp, unordered_set<string> dict, int len){
    vector<string> res;
    if(s.length() == 0) return res;
    if(mp.find(s)!=mp.end()) return mp[s];
    if(dict.find(s) != dict.end()) res.push_back(s);
    int bound = min((int)s.length(), len);
    vector<string> subRes;
    for(int i = 1; i <= bound; ++i){
        string str = s.substr(0, i);
        if(dict.find(str) != dict.end()){
            subRes = helper(s.substr(i), mp, dict, len);
            for(string sub : subRes){
                res.push_back(str + " " + sub);
            }
        }
    }
    mp[s] = res;  // cache both successful and failed cases
    return res;
}
