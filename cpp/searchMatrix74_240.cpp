//
// Created by Qiu Dongmin on 2019-07-16.
//

#include "searchMatrix74_240.h"

using namespace searchMatrix74_240;

bool Solution::searchMatrixI(vector<vector<int>>& matrix, int target) {
    int m = matrix.size();
    if (m == 0)
        return false;
    int n = matrix[0].size();

    // 二分查找
    int left = 0, right = m * n - 1;
    int pivotIdx, pivotElement;
    while (left <= right) {
        pivotIdx = (left + right) / 2;
        pivotElement = matrix[pivotIdx / n][pivotIdx % n];
        if (target == pivotElement)
            return true;
        else {
            if (target < pivotElement)
                right = pivotIdx - 1;
            else
                left = pivotIdx + 1;
        }
    }
    return false;
}

bool Solution::searchMatrixII(vector<vector<int>>& matrix, int target) {
    int row = matrix.size() - 1;
    int col = 0;
    while (row >= 0 && col < matrix[0].size()) {
        if (matrix[row][col] == target)
            return true;
        else if (matrix[row][col] > target)
            row--;
        else
            col++;
    }
    return false;
}

void Solution::run() {

}

int main() {
    Solution s;
    s.run();
    return 0;
}