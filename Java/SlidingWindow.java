/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class SlidingWindow {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC").equals("BANC"));
        System.out.println(minWindow("a", "a").equals("a"));
        System.out.println(minWindow("a", "aa").equals(""));
    }

    public static String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1] > 0)
                counter--;
            map[c1]--;
            end++;
            while (counter == 0) { // valid window, now try to reduce it
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0)
                    counter++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
