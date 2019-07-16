//
// Created by Qiu Dongmin on 2019-07-16.
//

#ifndef CPP_WORDSEARCH79_H
#define CPP_WORDSEARCH79_H

#include <iostream>
#include <vector>
#include <string>

using namespace std;

namespace wordSearch79 {
    class Solution {
    public:
        bool exist(vector<vector<char>>& board, string word);
        bool dfs(vector<vector<char>>& board, int x, int y, string& word, int index, vector<vector<bool>>& visited);
        void run();
    };
}

#endif //CPP_WORDSEARCH79_H
