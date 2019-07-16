//
// Created by Qiu Dongmin on 2019-07-16.
//

#include "wordSearch79.h"

using namespace wordSearch79;

bool Solution::exist(vector<vector<char>>& board, string word) {
    if (board.size() == 0 || word.length() == 0)
        return false;

    int m = board.size();
    int n = board[0].size();
    vector<vector<bool>> visited(m, vector<bool>(n, false));
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] == word[0]) {
                if (dfs(board, i, j, word, 0, visited))
                    return true;
            }
        }
    }
    return false;
}

bool Solution::dfs(vector<vector<char>>& board, int x, int y, string& word, int index, vector<vector<bool>>& visited) {
    if (index == word.length())
        return true;
    if (x < 0 || x >= board.size() || y < 0 || y >= board[0].size() || visited[x][y])
        return false;
    if (board[x][y] == word[index]) {
        visited[x][y] = true;
        const int directions[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int k = 0; k < 4; k++) {
            if (dfs(board, x+directions[k][0], y+directions[k][1], word, index+1, visited))
                return true;
        }
        visited[x][y] = false;
    }
    return false;
}

void Solution::run() {
    vector<vector<char>> board = {{'a'},
                                  {'a'}};
    string word = "aaa";
    cout << this->exist(board, word) << endl;
}

int main() {
    Solution s;
    s.run();
    return 0;
}