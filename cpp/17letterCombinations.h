//
// Created by Qiu Dongmin on 2019-06-25.
//

#ifndef CPP_17LETTERCOMBINATIONS_H
#define CPP_17LETTERCOMBINATIONS_H

#include <string>
#include <vector>
#include <map>
using namespace std;

namespace p17 {
    class Solution {
    public:
        vector<string> letterCombinations(string digits);
        void dfs(map<char, string>& table, vector<string>& res, string& digits, int index, string tmp);
        void run();
    };
}

#endif //CPP_17LETTERCOMBINATIONS_H
