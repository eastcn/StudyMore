package LeetCode.demo415;

/**
 * @Classname addString
 * @Description TODO
 * @Date 2020/8/4 12:01 上午
 * @Created by East
 */
public class addString {
    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.89%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了91.31%的用户
     * 字符串相加，双指针遍历，按每个位置的数相加，即模拟两数的竖式相加, 少的位数补做0
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addString(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int add = 0;
        int x = num1.length() - 1, y = num2.length() - 1;
        while (x >= 0 || y >= 0 || add > 0) {
            int i = x >= 0 ? num1.charAt(x) - '0' : 0;
            int j = y >= 0 ? num2.charAt(y) - '0' : 0;
            stringBuilder.append((i + j + add) % 10);
            add = (i + j + add) / 10;
            x--;
            y--;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addString("19", "0"));
    }
}
