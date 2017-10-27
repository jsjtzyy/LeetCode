/********************** MAX, MIN VALUE *******************************/
#include<climits>
INT_MAX = ~(1 << 31)   // for 64bit machine
INT_MIN = 1 << 31      // for 64bit machine
UINT_MAX = (uint)(~0)  // 32 bit all equal 1
LONG_MAX
LONG_MIN
ULONG_MAX

/******************** string, char, integer conversion ***************/
[int to string]         to_string(num);
[string to int]         stoi(s);            // i.e.  int val = stoi("1024");
[char to string]        string(1, ch); 
[charr array to string] string(charArr);

/********************** string ***************************/
In C++ string is mutable

string(char[] chArr) or string(char* chArr);  // string constructor
string(int n, char ch);                       // string constructor with n characters of ch

string str = "1234";
str[i];                                       // access i th character
str.size();  or str.length();
str.substr(start);                            // [start,  )              
str.substr(start, length);                    // [start, start + length - 1]       str doesn't change 

str.append("abc");
str.append(1, 'a');                          // append character
size_t found = str.find("ab");               // return pos where "ab" first occur in str.  NOTE: the return pos is size_t !!!
if (found!=string::npos)  cout << "found";   // 

str.erase(2);                                // erase substring starting from 2.   [2, )    str changes !!!!!!!!!  str = "12"
str.erase(pos, length);                      // erase length characters starting from pos 
str.insert(2, "sz");                         // insert characters starting from pos 2.      str changes !!!!!!!!!
str.replace(pos, len, "newStr");             // replace substring starting from pos with length = len as "newStr"

str1.compare(str2);                          // 0 equal; -1 str1 comes first in lexicographic order
void reverse(str.begin(), str.end());        // reverse string.       str changes!!!!!!!!!!  no return value

#include <sstream>                        // similar to StringBuilder in Java
stringstream ss;
ss << "year" << ' ' << 2017;              // accept char, string and number(int, float, double)
ss.str();                                 // convert sstream to string

string input = "abc,def,ghi";             // to implement the function like split(",") in Java
istringstream ss(input);
string token;

while(getline(ss, token, ',')) {            // if the delimiter is '\' we should use '\\' to explicitly specify the delimiter
    cout << token << '\n';
}

/********************** array ***************************/
int nums[10] = {0};
[array to vector]  vector<int> vec(&nums[0], &nums[10]);

/********************** vector ***************************/
#include <vector>
vector<int> v;
vector<int> v(size, 0);   // create a vector with length of size and initialize all elements to 0;
vector<vector<int>> v(N, vector<int>(M, 0)); //initialize N * M 2d vector to zero

int val = v[i];           // random access
v.empty();                // return bool to indicate empty or not
v.push_back(e);           // insert element to end
v.pop_back();             // delete last element
v.clear();
v.front();                // return first element
v.erase(v.begin() + 5);   // delete 6th element;
v.insert(v.begin(), var)  // insert var in first position
v.begin();                // return iterator pointing to first element;    
v.end();                  // return iterator pointing to null behind last element;

for(vector<int>::iterator it = myvector.begin() ; it != myvector.end(); ++it)
{
    cout << *it << endl;
}

v.resize(num);                      // resize the length of vector
v.resize(num, val);                 // resize vector by using val to padding  (default is 0);
                                    // resize(num, val) can be used for constructor in class;

#include <algorithm>
sort(v.begin(), v.end());           // sort vector and from min to max by default

struct cmp{
    bool operator() (int x, int y){
        return x > y;               // descending order
    }
} cmpObj;
sort(v.begin(), v.end(), cmpObj);   // sort with self-defined comparator

/********************** unordered_map, map, unordered_set, set ***************************/
#include<unordered_map>
unordered_map<int, string> Map;                         // O(1) or constant time complexity
#include<map>
map<int, string> treeMap;                               // O(logN) time complexity

Map[1] = "one";                                         // insert     equivalent to map.put(key, val)
string str = Map[1];                                    // get        equivalent to map.get(key)
if(Map.find(1) != Map.end()) cout << Map[1] << endl;    // search key equivalent to map.containsKey(key)
Map.erase(1);                                           // delete     equivalent to map.remove(key)

unordered_map<int, string>::iterator it = Map.find(1);  // find by key
if(iter != Map.end()) cout << iter->second; 
else cout << "not found"; 

for(iter = Map.begin(); iter != Map.end(); ++iter)
    cout << iter->first << iter->second <<end;          // traverse

Map.erase("one");                                       // delete
Map.empty();
Map.size();

unordered_set<int> Set; 
Set.insert(val);
Set.erase(val);
Set.erase(iterator);
Set.size();
Set.empty();
if(Set.find(1) != Set.end()) cout << "found" << endl;   // find val  equivalent to set.contains(val)
for(iter = Set.begin(); iter != Set.end(); ++iter)      // traverse
    cout << *iter <<endl;

set<int>::iterator it = Set.upper_bound(val);           //Return iterator pointing to first element after val             > val
set<int>::iterator it = Set.lower_bound(val);           //Return iterator pointing to first element not goes before val   >= val

struct cmp{
    bool operator()(Node* a, Node* b){
        return (a->val) < (b->val);
    }
};
set<Node*, cmp> s;                                      //intialize ordered set with comparator

/********************** stack, queue, heap, deque ***************************/
#include <stack>
#include <queue>
#include <priority_queue>
stack<int> s;
queue<int> q;
s.top();                                       // access the top element
s.push();
s.pop();
q.front();                                     // access the first element in queue
q.pop();                                       // does not return element !!!!!
q.empty();

priority_queue<int> pq;                        // max heap by default
pq.push(val);
pq.top();                                      // access first element
pq.pop();                                      // pop out first value, does not return element !!!!!

struct cmp{
  bool operator()(Node* a, Node* b){
    return a -> x > b -> x;                    // build min heap               
  }
};

priority_queue<Node*, vector<Node*>, cmp> pq;  // NOTE:  the format is different for sort function!!!
pq.push(new Node(1, 2));

#include<deque>
deque<int> dq (2,0);
dq.push_back(1);
dq.push_front(-1);
cout << dq[0] << endl;

/************************* pair / make_pair *******************************/
#include <utility>
pair<int, int> pr;
pr = make_pair(2, 3);             // generate pair
cout << pr.first << endl;         // access first value
cout << pr.second << endl;        // access second value

/************************* rand / srand ***********************************/
#include<stdlib.h>
#include<time.h>
srand((unsigned)time(0));  // initialize rand seed
(rand()%(b-a))+ a;         // random number from [a, b)
(rand()%(b-a+1))+ a;       // random number from [a, b]
(rand()%(b-a))+ a + 1;     // random number from (a, b)
rand() % len + a;          // [a, len + a)
rand()/double(RAND_MAX);   // random floating number from [0.0, 1.0]
// c++ 11 supports default_random_engine
default_random_engine eng;
eng() % len;               // [0, len)

/************************* math ***********************************/
#include <math.h>
M_PI                       // pi in math
cos(theta * M_PI / 180.0)  // cos takes angle in rad as input
acos(-1) = M_PI;           // acos output is angle in rad
sqrt()                     // compute square root
round()                    // round floating value to closest integer
pow(n, k);                 // compute n^k

/************************* Format Output ***********************************/
#include <iomanip>
const double value = 12.3456789;
cout << setprecision(4) << value << endl;   // 改成4精度，所以输出为12.35
cout << fixed << setprecision(4) << value << endl; // 加了fixed意味着是固定点方式显示，所以这里的精度指的是小数位，输出为12.3457

/************************* swap reference / pointer ***********************/
In bfs, we use two queues in Java. Similarly, we can swap two containers in C++
cur.swap(next);     // swap cur and next reference;  两个容器的交换，可以用于map, set, queue, vector等

In cpp, the operator precedence is:  () > []  > *  >  >>  > &
        that is: Function call > Array subscripting > Dereference > Bitwise shift > Bitwise AND

/************************ rotate ***************************/
rotate (Iterator first, Iterator middle, Iterator last);
// Rotates elements in the range [first,last), the element pointed by middle becomes the new first element.

Example:
for (int i=1; i<10; ++i) vec.push_back(i);  // 1 2 3 4 5 6 7 8 9
rotate(vec.begin(),vec.begin()+3,vec.end());// 4 5 6 7 8 9 1 2 3

/************************ Node ***************************/
class ListNode{
public:
    int val;
    ListNode* next;
    ListNode(int val){
        this->val = val;
        this->next = NULL;
    }
};

class TreeNode{
public:
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int val){
        this->val = val;
        this->left = NULL;
        this->right = NULL;
    }
};

class TrieNode{
public:
    char ch; 
    bool isWord;
    TrieNode* next[26];
    TrieNode(char ch){
        this->ch = ch;
        this->isWord = false;
        memset(next, 0, sizeof(next));
    }
};

class Node{
public:
    int x;
    int y;
    Node(int x, int y){
        this->x;
        this->y;
    }
    friend operator < (Node& a, Node& b){
        return this.x - that.x;
    }
    void print(){
        cout<< this->x << this->y <<endl;
    }
};
/*********************** pointer **********************/

Node* p = new Node(x, y);
p -> x;                   // access class members;
p -> print();             // access class member function;
