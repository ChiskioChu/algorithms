package Recursion;

import java.util.ArrayList;

/**
 * 斐波那契数列问题
 * 由于直接递归的时间复杂度为O(2^n)，所以效率比较低
 * 方法一：自底向上，递推，开一个ArrayList挨个存储
 * 方法二：迭代+滚动变量，不需要存储前面每一个数据，只需知道上个和上上个，空间复杂度降为O(1)
 * 方法三：矩阵运算+快速幂：
 *          Xn = [An,An-1],X1 = [A1,A0];
 *          Q = [[1,1],[1,0]];
 *          则 Xn = (Xn-1) X (Q);
 *          可以得到：Xn = (X1) X (Q)^(n-2);
 *          由于元素从下标为0开始，所以为n-2次幂；
 *          最后得到 Xn，Xn向量的第一个元素就是An；
 * 方法四：未写出来，使用斐波那契数列的通项公式，n次幂用快速幂实现，时间复杂度为O(logn)
 */
public class Fibonacci {
    class Solution1 {
        public int fib(int N) {
            ArrayList<Integer> list = new ArrayList<Integer>();

            list.add(0,1);
            list.add(1,1);
            if(N == 0)return 0;
            if(N == 1)return 1;
            if(N == 2)return 1;

            for(int i = 3 ;i <= N;i++){
                list.add(i-1,list.get(i-2)+list.get(i-3));
            }
            return list.get(N-1);
        }
    }
    class Solution2 {
        public int fib(int N) {
            if(N == 1)return 1;
            if(N == 2)return 1;
            int result = 0;
            int f1 = 1;
            int f2 = 1;
            for(int i = 3;i <= N; i++){
                result = f1 + f2;
                f1 = f2;
                f2 = result;
            }
            return result;
        }
    }
    class Solution3 {
        public int fib(int N) {
            int[] x = {1,1};
            int[][] a = {{1,1},{1,0}};
            int[][] apow = matrix22_pow(a,N-2);
            int ret = apow[0][0]*x[0] + apow[1][0]*x[1];
            return ret;

        }
        public int[][] matrix22_mul(int[][] x,int[][] y){
            int[][] temp = {{0,0},{0,0}};
            temp[0][0] = x[0][0]*y[0][0] + x[0][1]*y[1][0];
            temp[0][1] = x[0][0]*y[0][1] + x[0][1]*y[1][1];
            temp[1][0] = x[1][0]*y[0][0] + x[1][1]*y[1][0];
            temp[1][1] = x[1][0]*y[0][1] + x[1][1]*y[1][1];
            return temp;
        }
        public int[][] matrix22_pow(int[][] x,int n){
            int[][] r = {{1,0},{0,1}};
            int[][] v = x;
            while(n > 0){
                if(n % 2 ==1){
                    r = matrix22_mul(r,v);
                    n -= 1;
                }
                v = matrix22_mul(v,v);
                n /= 2;
            }
            return r;
        }
    }
}
