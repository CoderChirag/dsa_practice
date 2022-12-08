//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution{
public:
	vector<string> AllPossibleStrings(string s){
	    // Code here
	    vector<string> res;
	    if(s.size() == 0){
	        res.push_back(" ");
	        return res;
	    }
	    for(int counter=0; counter<(1<<s.size()); counter++){
	        string str = "";
	        for(int j=0; j<s.size(); j++){
	            if(counter & (1<<j)) str+=s[j];
	        }
	        res.push_back(str);
	    }
	    res.erase(res.begin());
	    sort(res.begin(), res.end());
	    return res;
	}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string s;
		cin >> s;
		Solution ob;
		vector<string> res = ob.AllPossibleStrings(s);
		for(auto i : res)
			cout << i <<" ";
		cout << "\n";

	}
	return 0;
}
// } Driver Code Ends