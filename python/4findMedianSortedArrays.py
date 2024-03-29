#!/usr/bin/python
# coding: utf-8
__author__ = 'qiudongmin'


class Solution(object):

    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        m, n = len(nums1), len(nums2)
        if m > n:
            nums1, nums2, m, n = nums2, nums1, n, m
        if n == 0:
            return None
        imin, imax = 0, m
        half = (n + m + 1) / 2
        while imin <= imax:
            i = (imin + imax) / 2
            j = half - i
            if i > 0 and nums1[i - 1] > nums2[j]:
                imax = i - 1
            elif i < m and nums2[j - 1] > nums1[i]:
                imin = i + 1
            else:
                if i == 0:
                    max_of_left = nums2[j - 1]
                elif j == 0:
                    max_of_left = nums1[i - 1]
                else:
                    max_of_left = max(nums1[i - 1], nums2[j - 1])

                if (m + n) % 2 != 0:
                    return max_of_left

                if i == m:
                    min_of_right = nums2[j]
                elif j == n:
                    min_of_right = nums1[i]
                else:
                    min_of_right = min(nums1[i], nums2[j])

                return (max_of_left + min_of_right) / 2.0
        return None


if __name__ == "__main__":
    s = Solution()
    print s.findMedianSortedArrays([], [2,3])
