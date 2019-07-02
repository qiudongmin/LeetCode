//
// Created by EDZ on 2019/7/1.
//

#ifndef CPP_MYLEETCODE_H
#define CPP_MYLEETCODE_H

#include <iostream>
#include <vector>

using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode* createList(vector<int>& nums);
};

#endif //CPP_MYLEETCODE_H
