package tencent50;

public class L11MaxArea {

    //完全爆力法
    public static int maxArea1(int[] height) {
        int maxArea = 0;
        int area;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = Math.min(height[i], height[j]) * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    //无法通过 用例[2,3,4,5,18,17,6]
    public static int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        int area;

        for (int i = left; i < right; i++) {
            for (int j = right; j > left; j--) {
                area = Math.min(height[i], height[j]) * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
                while (height[j] <= height[right] && j > left) {
                    j--;
                }
            }
            while (height[i] < height[left] && i < right) {
                i++;
            }
        }
        return maxArea;
    }

    //双指针法，反证法证明
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int area;
        while (left < right) {
            area = Math.min(height[left], height[right]) * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }
            //if (left > right)
            if (height[left] > height[right]) {
               // right++;
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}) == 49);
        System.out.println(maxArea(new int[]{1, 8, 6}) == 6);
        System.out.println(maxArea(new int[]{6, 2}) == 2);
        System.out.println(maxArea(new int[]{6}) == 0);
        System.out.println(maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}) == 17);

    }
}
