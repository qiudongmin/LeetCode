//
// Created by EDZ on 2019/7/2.
//

#include "myleetcode.h"

ListNode* ListNode::createList(vector<int>& nums) {
    ListNode dummHead(0);
    ListNode* p = &dummHead;
    for (int num : nums) {
        auto* tmp = new ListNode(num);
        p->next = tmp;
        p = p->next;
    }
    return dummHead.next;
}
