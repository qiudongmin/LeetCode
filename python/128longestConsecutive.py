#!/usr/bin/python
# coding: utf-8
__author__ = 'qiudongmin'


class Solution(object):

    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        hash_dict = {}
        max_length = 0

        for num in nums:
            if num not in hash_dict:
                left = hash_dict.get(num - 1, 0)
                right = hash_dict.get(num + 1, 0)
                current_length = left + right + 1

                if current_length > max_length:
                    max_length = current_length

                hash_dict[num] = current_length
                hash_dict[num - left] = current_length
                hash_dict[num + right] = current_length

        return max_length


if __name__ == "__main__":
    s = Solution()
    print s.longestConsecutive([100, 4, 200, 1, 3, 2])
