package Stack;

import java.util.Stack;

/**
 * Leetcode
 * 232.用栈实现队列
 * 题目描述：主要需要完成队列的入队和出队，队列为先进先出
 * 解题思路；一个栈维护数据，另外一个为辅助栈，两个栈相互倒，
 * 可以使得数据栈顺序为队列形式，即先进去的到栈顶，后进去的
 * 到栈底。
 * 即每次添加数据时，先将数据栈的所有数据pop到辅助栈，然后
 * 将新数据压入数据栈，再将辅助栈中的数据push到数据栈。
 */
public class ImplQueueUsingStacks {

        /** Initialize your data structure here. */
        private Stack<Integer> stack1;//数据栈
        private Stack<Integer> stack2;//辅助栈
        public ImplQueueUsingStacks() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if(stack1.isEmpty()){
                stack1.push(x);
                return;
            }
            //两个栈相互倒
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            //System.out.println(stack2.peek());
            stack1.push(x);
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            //System.out.println(stack1.peek());
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(stack1.isEmpty()){
                return -1;
            }
            //System.out.println(stack2.peek());
            return stack1.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack1.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty();
        }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

