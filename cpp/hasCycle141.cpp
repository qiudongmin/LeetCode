//
// Created by Qiu Dongmin on 2019-06-27.
//

#include "hasCycle141.h"

using namespace hasCycle141;

bool Solution::hasCycle(ListNode *head) {
    if (head == nullptr) {
        return false;
    }
    ListNode *fast, *slow;
    fast = head;
    slow = head;
    while (fast != nullptr && fast->next != nullptr) {
        fast = fast->next->next;
        slow = slow->next;
        if (fast == slow) {
            return true;
        }
    }
    return false;
}

void Solution::run() {
    this->hasCycle(nullptr);
}

int main() {
    Solution s;
    s.run();
    return 0;
}