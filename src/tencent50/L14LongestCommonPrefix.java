package tencent50;

/**
 * 最长公共子串
 */
public class L14LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
//        int minLen = Integer.MAX_VALUE;
//        for (String str : strs) {
//            if (str.length() < minLen) {
//                minLen = str.length();
//            }
//        }  没有必要先求minLen
        char temp;
        for (int i = 0; i < strs[0].length(); i++) {
            temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() > i) {
                    if (temp != strs[j].charAt(i)) {
                        return strs[0].substring(0, i);
                    }
                } else {
                    return strs[j];
                }
            }
        }
        // return ""; //无法通过"d", "d", "d" 用例
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}).equals("fl"));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}).equals(""));
        System.out.println(longestCommonPrefix(new String[]{"dog"}).equals("dog"));
        System.out.println(longestCommonPrefix(new String[]{"dog", "c"}).equals(""));
        System.out.println(longestCommonPrefix(new String[]{"dog", "d"}).equals("d"));
        System.out.println(longestCommonPrefix(new String[]{"d", "d", "d"}).equals("d"));
        System.out.println(longestCommonPrefix(new String[]{"d", "db", "dbc"}).equals("d"));
        System.out.println(longestCommonPrefix(new String[]{"dba", "dbac", "dbad"}).equals("dba"));
        System.out.println(longestCommonPrefix(new String[]{}).equals(""));
    }
}
