import java.util.List;

/**
 * @Classname dmeo
 * @Description TODO
 * @Date 2020/8/20 2:02 下午
 * @Created by East
 */
public class dmeo {
    public String demo(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i > 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();

    }

    static public int demo2(int x) {
        int start1 = 1, start2 = 2, sum;
        for (int i = 0; i < x; i++) {
            sum = start1 + start2;
            start1 = start2;
            start2 = sum;
        }
        return start1;
    }

    static public int demo3(int x) {
        // 1 2 3 5 8 13
        int r = 1;
        if (x > 1) {
            r = demo3(x - 1) + demo3(x - 2);
        }
        return r;
    }

    class person {
        String firstName;
        String lastName;
    }

    public void Sorted(List<person> list) {
        for (int i = 0; i < list.toArray().length; i++) {
            for (int j = i; j < list.toArray().length; j++) {

            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(demo2(3));
        for (int i = 1; i < 10; i++) {
            System.out.println(demo3(i));
        }
    }
}
