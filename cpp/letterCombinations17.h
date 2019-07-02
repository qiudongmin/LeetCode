//
// Created by Qiu Dongmin on 2019-06-25.
//

#ifndef CPP_LETTERCOMBINATIONS17_H
#define CPP_LETTERCOMBINATIONS17_H

#include <iostream>
#include <vector>
#include <string>
#include <map>

using namespace std;

namespace letterCombinations17 {
    class Solution {
    public:
        vector<string> letterCombinations(string digits);
        void dfs(map<char, string>& table, vector<string>& res, string& digits, int index, string tmp);
        void run();
    };
}

#endif //CPP_LETTERCOMBINATIONS17_H
