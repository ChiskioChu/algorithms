package Stack;

import java.util.Stack;

/**
 * 20.Leetcode 有效的括号
 * 解题思路：后来出现的左括号先被匹配
 * 利用栈的先进后出，后进先出，故选用栈这个数据结构
 *
 */
public class ValidParentheses {
        public boolean isValid(String s) {
            if(s.isEmpty())
                return true;
            Stack<Character> stack=new Stack<Character>();
            for(char c:s.toCharArray()){
                if(c=='(')
                    stack.push(')');
                else if(c=='{')
                    stack.push('}');
                else if(c=='[')
                    stack.push(']');
                else if(stack.empty()||c!=stack.pop())
                    return false;
            }
            if(stack.empty())
                return true;
            return false;
    }
}
