//
// Created by EDZ on 2019/7/2.
//

#include <vector>

using namespace std;

#include "reverseList206_92.h"

using namespace reverseList206_92;

ListNode* Solution::reverseList(ListNode* head) {
    ListNode* prev = nullptr;
    ListNode* curr = head;
    while (curr != nullptr) {
        ListNode* nextTemp = curr->next;
        curr->next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}

ListNode* Solution::reverseBetween(ListNode* head, int m, int n) {
    ListNode dummyHead(0);
    dummyHead.next = head;
    ListNode* prev = &dummyHead;
    ListNode* curr = head;
    for (int i = 1; i < m; i++) {
        prev = curr;
        curr = curr->next;
    }
    ListNode* before = prev;
    prev = curr;
    curr = curr->next;
    for (int i = m; i < n; i++) {
        ListNode* nextTemp = curr->next;
        curr->next = prev;
        prev = curr;
        curr = nextTemp;
    }
    before->next->next = curr;
    before->next = prev;
    return dummyHead.next;
}

void Solution::run() {
    ListNode p(0);
    vector<int> a({5});
    this->reverseList(p.createList(a));
    this->reverseBetween(p.createList(a), 1, 1);
}

int main() {
    Solution s;
    s.run();
    return 0;
}