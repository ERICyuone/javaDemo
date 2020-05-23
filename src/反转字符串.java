import java.util.Stack;

public class 反转字符串 {


    public void reverseString(char[] s) {
       /* Stack<Character> stack = new Stack<Character>();
        int size=s.length;
        for(int i=0;i<size;i++){
            stack.push(s[i]);
        }
        int j=0;
        while(!stack.empty()){
            s[j]=stack.pop();
            j++;
        }*/
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char t = s[i];
            s[i++] = s[j];
            s[j--] = t;
        }
    }
}
