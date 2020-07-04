package tencent50;

// TODO: 2019/12/28 复杂度 m + n
// 有更好方法 log N
public class L4findMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 != null) {
            return findMedian(nums2);
        }

        if (nums2 == null && nums1 != null) {
            return findMedian(nums1);
        }
        if (nums1.length > nums2.length) {
            return doFindMedianSortedArrays(nums2, nums1);
        } else {
            return doFindMedianSortedArrays(nums1, nums2);
        }

    }

    public static double doFindMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int index = 0;
        int left = 0;
        int right = 0;
        boolean flag = (nums1.length + nums2.length) % 2 == 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                left = right;
                right = nums1[i++];
                index++;
            } else {
                left = right;
                right = nums2[j++];
                index++;
            }
            if (index == (nums1.length + nums2.length) / 2 + 1) {
                if (flag) {
                    return (double) (left + right) / 2.0;
                } else {
                    return right;
                }
            }
        }

        while (j < nums2.length) {
            left = right;
            right = nums2[j++];
            index++;
            if (index == (nums1.length + nums2.length) / 2 + 1) {
                if (flag) {
                    return (double) (left + right) / 2.0;
                } else {
                    return right;
                }
            }
        }
        /**
         * if (nums1.length > nums2.length) {
         *             return doFindMedianSortedArrays(nums2, nums1);
         *         } else {
         *             return doFindMedianSortedArrays(nums1, nums2);
         *         }
         *         这一段根本没有用  还是num1和num2都要兜底
         */
        while (i < nums1.length) {
            left = right;
            right = nums1[i++];
            index++;
            if (index == (nums1.length + nums2.length) / 2 + 1) {
                if (flag) {
                    return (double) (left + right) / 2.0;
                } else {
                    return right;
                }
            }
        }
        return -1;
    }

    public static double findMedian(int[] nums) {
        if (nums.length % 2 == 0) {
            return (double)(nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;
        }
        return nums[nums.length / 2];
    }

    /** 凡是涉及到有序数组的  第一反应要是二分查询
     *
     * 因为一个常识：如果我们去掉数组比中位数小的k个数，再去掉比中位数大的k个数，得到的子数组的中位数和原来的中位数相同。
     *
     *
     * 一样的， 我们还是把这个两个数组来比较一下，不失一般性，我们假定B数组比A数组长一点。A的长度为n, B的长度为m。比较A[n/2]和B[m/2] 时候。类似的，我们还是分成几种情况来讨论：
     * a、如果A[n/2] == B[m/2]，那么很显然，我们的讨论结束了。A[n/2]就已经是中位数，这个和他们各自的长度是奇数或者偶数无关。
     * b、如果A[n/2]  <   B[m/2]，那么，我们可以知道这个中位数肯定不在[A[0]---A[n/2])这个区间内，同时也不在[B[m/2]---B[m]]这个区间里面。这个时候，我们不能冲动地把[A[0]---A[n/2])和[B[m/2]---B[m]]全部扔掉。我们只需要把[B[m-n/2]---B[m]]和[A[0]---A[n/2])扔掉就可以了。（如图所示的红色线框），这样我们就把我们的问题成功转换成了如何在A[n/2]->A[n]这个长度为 n/2 的数组和 B[1]-B[m-n/2]这个长度为m-n/2的数组里面找中位数了，问题复杂度即可下降了。
     * c、只剩下A[n/2] > B[m/2]，和b类似的，我们可以把A[n/2]->A[n]这块以及B[1]->B[n/2]这块扔掉了就行，然后继续递归。
     * @param args
     */
    public static void main(String[] args) {
       int[] nums1 = new int[] {1, 3};
       int[] nums2 = new int[] {2};
       System.out.println(findMedianSortedArrays(nums1, nums2));
       nums1 = new int[] {1, 2, 3, 5};
       nums2 = new int[] {2, 4};
       System.out.println(findMedianSortedArrays(nums1, nums2));
       nums1 = new int[] {0, 0};
       nums2 = new int[] {0, 0};
       System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
