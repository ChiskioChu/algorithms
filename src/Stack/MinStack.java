package Stack;

import java.util.Stack;

/**
 * 155.题目描述：添加寻找栈中最小元素
 * 使用两个栈维护数据，其中一个存放最小数
 *
 * 入栈 3
 * |   |    |   |
 * |   |    |   |
 * |_3_|    |_3_|
 * stack  minStack
 *
 * 入栈 5 ， 5 大于 minStack 栈顶，不处理
 * |   |    |   |
 * | 5 |    |   |
 * |_3_|    |_3_|
 * stack  minStack
 *
 * 入栈 2 ，此时右边的 minStack 栈顶就保存了当前最小值 2
 * | 2 |    |   |
 * | 5 |    | 2 |
 * |_3_|    |_3_|
 * stack  minStack
 *
 * 出栈 2，此时右边的 minStack 栈顶就保存了当前最小值 3
 * |   |    |   |
 * | 5 |    |   |
 * |_3_|    |_3_|
 * stack  minStack
 *
 * 出栈 5，右边 minStack 不处理
 * |   |    |   |
 * |   |    |   |
 * |_3_|    |_3_|
 * stack  minStack
 *
 * 出栈 3
 * |   |    |   |
 * |   |    |   |
 * |_ _|    |_ _|
 * stack  minStack
 *
 */
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(!minstack.isEmpty()){
            int popm = minstack.peek();
            if(popm >= x){
                minstack.push(x);
            }
        }else{
            minstack.push(x);
        }

    }

    public void pop() {
        int pop = stack.peek();
        int popm = minstack.peek();
        if(pop == popm){
            minstack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */