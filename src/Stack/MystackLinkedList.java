package Stack;

/**
 * 链表实现为链式栈,头插法
 */
public class MystackLinkedList {
    private Node top = null;

    public void push(int value) {
        Node newNode = new Node(value, null);
        // 判断是否栈空
        if (top == null) {
            top = newNode;
        } else {
            //头插法
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 我用-1表示栈中没有数据。
     */
    public int pop() {
        if (top == null) return -1;
        int value = top.data;
        //删除头结点
        top = top.next;
        return value;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
