//
// Created by Qiu Dongmin on 2019-06-27.
//

#include <algorithm>
#include <iostream>

using namespace std;

#include "wordBreak139.h"

using namespace wordBreak139;

bool Solution::wordBreak(string s, vector<string>& wordDict) {
    int sl = s.length();
    vector<bool> dp(sl + 1, false);
    dp[0]  = true;
    for (int i = 0; i < sl; i++) {
        for (int j = 0; j <= i; j++) {
            if (dp[j]) {
                string tmp = s.substr(j, i - j + 1);
                if (find(wordDict.begin(), wordDict.end(), tmp) != wordDict.end()) {
                    dp[i+1] = true;
                    break;
                }
            }
        }
    }
    return dp[sl];
}

void Solution::run() {
    vector<string> wordDict = {"leet", "code"};
    cout << this->wordBreak("leetcode", wordDict);
}

int main() {
    Solution s;
    s.run();
    return 0;
}