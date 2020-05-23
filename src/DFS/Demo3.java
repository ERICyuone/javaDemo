package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2-9
 * 3-21
 */
public class Demo3 {

    public static void main(String[] args) {
        int n = 2;///////
        List<String> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        String str = "ABC";

        method(list, stack, str, n);
        int ns = foo(list);
        System.out.println(ns);

    }

    public static int foo(List<String> list) {//剪树枝
        int cnt = list.size();
        String[] all = {"ABC", "ACB", "BAC", "BCA", "CAB", "CBA"};
        for (int i = 0; i < list.size(); i++) {
            for (String str : all) {
                int index = list.get(i).indexOf(str);
                if (index != -1) {
                    cnt--;
                    break;
                }
            }

        }
        return cnt;
    }

    public static void method(List<String> list, Stack<Character> stack, String str, int n) {
        if (n == 0) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < stack.size(); i++) {
                builder.append(stack.get(i));

            }
            list.add(builder.toString());
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            method(list, stack, str, n - 1);
            stack.pop();

        }
    }


}
