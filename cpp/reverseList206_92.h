//
// Created by EDZ on 2019/7/2.
//

#ifndef CPP_REVERSELIST206_92_H
#define CPP_REVERSELIST206_92_H

#include <iostream>

using namespace std;

#include "myleetcode.h"

namespace reverseList206_92 {
    class Solution {
    public:
        ListNode* reverseList(ListNode* head);
        ListNode* reverseBetween(ListNode* head, int m, int n);
        void run();
    };
}

#endif //CPP_REVERSELIST206_92_H
