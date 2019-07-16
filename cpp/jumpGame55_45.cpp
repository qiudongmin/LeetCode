//
// Created by Qiu Dongmin on 2019-07-16.
//

#include "jumpGame55_45.h"

using namespace jumpGame55_45;

bool Solution::canJump(vector<int>& nums) {
    int length = nums.size();
    if (length < 2)
        return true;
    vector<bool> dp(length, false);
    dp[length - 1] = true;
    for (int i = length - 2; i >= 0; i--) {
        int far = i + min(nums[i], length-1);
        for (int j = far; j > i; j--) {
            if (dp[j]) {
                dp[i] = true;
                break;
            }
        }
    }
    return dp[0];
}

bool Solution::tanxin(vector<int>& nums) {
    int maxp = 0;
    int length = nums.size();
    for (int i = 0; i < length; i++) {
        if (i > maxp)
            return false;
        maxp = max(maxp, i + nums[i]);
        if (maxp >= length - 1)
            return true;
    }
    return false;
}

int Solution::jump(vector<int>& nums) {
    int start = 0;
    int reach = 0;
    int maxp = 0;
    int steps = 0;
    while (reach < nums.size()-1) {
        for (int i = start; i <= reach; i++) {
            maxp = max(maxp, nums[i] + i);
        }
        start = reach + 1;
        reach = maxp;
        steps++;
    }
    return steps;
}

void Solution::run() {
    vector<int> nums = {1,0};
    cout << this->canJump(nums) << endl;
}

int main() {
    Solution s;
    s.run();
    return 0;
}