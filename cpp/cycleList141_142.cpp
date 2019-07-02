//
// Created by Qiu Dongmin on 2019-06-27.
//

#include "cycleList141_142.h"

using namespace cycleList141_142;

bool Solution::hasCycle(ListNode* head) {
    ListNode* fast;
    ListNode* slow;
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

ListNode* Solution::detectCycle(ListNode* head) {
    ListNode* fast;
    ListNode* slow;
    fast = head;
    slow = head;
    while (fast != nullptr && fast->next->next != nullptr) {
        fast = fast->next->next;
        slow = slow->next;
        if (fast == slow) {
            fast = head;
            while (fast != slow) {
                fast = fast->next;
                slow = slow->next;
            }
            return fast;
        }
    }
    return nullptr;
}

void Solution::run() {
    this->hasCycle(nullptr);
    this->detectCycle(nullptr);
}

int main() {
    Solution s;
    s.run();
    return 0;
}