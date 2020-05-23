import java.util.Stack;

public class 验证回文字符串 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }


    public static boolean isPalindrome(String s) {

        if(s == null || s.length()==0){
            return true;
        }
        s = s.toLowerCase();
        StringBuilder stringBuilder2 = new StringBuilder();
        Stack<Character> stack =new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='a'&&s.charAt(i)<='z' )||(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                stack.push(s.charAt(i));
                stringBuilder2.append(s.charAt(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.empty()){
            stringBuilder.append(stack.pop());
        }
        if(stringBuilder.toString().equals(stringBuilder2.toString()))return true;
        return false;
    }





}
