package tencent50;

import java.util.*;

public class L15ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            int sum;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    List result = new ArrayList();
                    result.add(nums[i]);
                    result.add(nums[l]);
                    result.add(nums[r]);
                    resultList.add(result);

                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }
        return resultList;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resultList;
        }
        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer diff = 0 - nums[i] - nums[j];
                if (diffMap.containsKey(diff)) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[diffMap.get(diff)]);
                    result.add(nums[j]);
                    resultList.add(result);
                } else {
                    diffMap.put(nums[j], j);
                }
            }
        }
        deDuplicateResult(resultList);
        return resultList;
    }


    /**
     * 3ms 击败97%
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; map.put(numbers[i], i++))
            if (map.containsKey(target - numbers[i]))
                return new int[]{map.get(target - numbers[i]), i};
        return new int[]{0, 0};
    }

    /**
     * 4ms  击败75%
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }

        Map<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (diffMap.containsKey(diff)) {
                result[0] = diffMap.get(diff);
                result[1] = i;
            } else {
                diffMap.put(nums[i], i);
            }
        }
        return result;
    }

    private static void deDuplicateResult(List<List<Integer>> resultList) {

    }

    private static void testTwoSum() {
        for (int i : twoSum(new int[]{2, 7, 11, 15}, 9)) {
            System.out.print(i + ",");
        }

        for (int i : twoSum(new int[]{2, 7, 11, 15}, 100)) {
            System.out.print(i + ",");
        }
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
