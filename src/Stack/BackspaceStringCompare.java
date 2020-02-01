package Stack;

import java.util.Stack;

/**
 * 844.比较含退格的字符串
 * 题目描述：字符串中含有'#'，遇到'#'，则向前退一格，例"a#b"等价于"b"
 * 思路：两个字符串放到两个栈中，不等于'#'就压入栈，遇到'#'就pop()，
 * 注意判断栈是否为空。
 */
public class BackspaceStringCompare {
        public boolean backspaceCompare(String S, String T) {
            if(S == null && T == null)return true;

            //char的包装类Character
            Stack<Character> stackS = new Stack<Character>();
            Stack<Character> stackT = new Stack<Character>();

            //提取字符串的元素
            for(char c:S.toCharArray()){
                if(c != '#'){
                    stackS.push(c);
                }
                else{
                    if(stackS.isEmpty()) continue;
                    stackS.pop();
                }
            }
            for(char c:T.toCharArray()){
                if(c != '#'){
                    stackT.push(c);
                }
                else{
                    if(stackT.isEmpty()) continue;
                    stackT.pop();
                }
            }
            return stackS.equals(stackT);
        }
}
