package com.muyi.leetcode.algorithms;

/**
 * @Classname leetcode_4_median_of_two_sorted_arrays
 * @Description 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * @Date 2021/4/15 下午8:25
 * @Created by muyi
 */
public class leetcode_4_median_of_two_sorted_arrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] l;
        int[] s;

        if(nums1.length > nums2.length){
            l = nums1;
            s = nums2;
        }else {
            s = nums1;
            l = nums2;
        }


        boolean isEvenNumber = false;

        if((s.length +l.length)%2 == 0){
            isEvenNumber = true;
        }

        int al = s.length +l.length ;


        int ll = 0;
        int sl = 0;
        double result = l[0];
        for(int i = 0; i<al ;i++){
            int n;
            if(sl >= s.length){
                n = l[ll];
                ll++;
            }else if(ll >= l.length){
                n = s[sl];
                sl++;
            }else if(l[ll] <= s[sl]){
                n = l[ll];
                ll++;
            }else {
                n = s[sl];
                sl++;
            }

            if(isEvenNumber){
                // 偶数
                if(al/2-i == 1){
                    result = n;
                    continue;
                }else if(al/2-i == 0){
                    return (result +n) /2;
                }
            }else {
                // 奇数
                if(al/2-i == 0) {
                    return n;
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};

        System.out.println(findMedianSortedArrays(nums1,nums2));

        nums1 = new int[]{1,2};
        nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));


        nums1 = new int[]{0,0};
        nums2 = new int[]{0,0};
        System.out.println(findMedianSortedArrays(nums1,nums2));



        nums1 = new int[]{};
        nums2 = new int[]{1};
        System.out.println(findMedianSortedArrays(nums1,nums2));



        nums1 = new int[]{2};
        nums2 = new int[]{};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
