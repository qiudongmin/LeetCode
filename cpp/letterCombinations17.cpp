//
// Created by Qiu Dongmin on 2019-06-25.
//

#include "letterCombinations17.h"
using namespace letterCombinations17;

vector<string> Solution::letterCombinations(string digits) {
    map<char, string> table = {{'2', "abc"}, {'3', "def"}, {'4', "ghi"}, {'5', "jkl"},
                               {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}};
    vector<string> res;
    this->dfs(table, res, digits, 0, "");
    return res;
}

void Solution::dfs(map<char, string>& table, vector<string>& res, string& digits, int index, string tmp) {
    int n = digits.size();
    string si = table[digits[index]];
    int ni = si.size();
    for (int i = 0; i < ni; i++) {
        tmp += si[i];
        if (index == n - 1) {
            res.push_back(tmp);
        }
        else {
            this->dfs(table, res, digits, index + 1, tmp);
        }
        tmp = tmp.substr(0, index);
    }
}

void Solution::run() {
    this->letterCombinations("23");
}

int main() {
    Solution s;
    s.run();
    return 0;
}