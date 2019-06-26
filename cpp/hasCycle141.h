//
// Created by Qiu Dongmin on 2019-06-27.
//

#ifndef CPP_HASCYCLE141_H
#define CPP_HASCYCLE141_H

#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

namespace hasCycle141 {
    class Solution {
    public:
        bool hasCycle(ListNode *head);
        void run();
    };
}

#endif //CPP_HASCYCLE141_H
