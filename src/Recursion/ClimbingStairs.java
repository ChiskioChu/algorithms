package Recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 70.爬楼梯
 * 题目描述：假设你正在爬楼梯。需要 n 阶你才能到达楼顶
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 解题思路：实际为斐波那契数列，根据第一步走出1步还是两步，写出递归公式：f[n]=f[n-1]+f[n-2]
 * 递归会造成重复数据的计算，所以方法一利用Map缓存计算过的值，n为key，值为value；
 * 方法二为非递归的方法，其实仍然为上述的递归公式，他的上一个结果和上上个结果相加，
 * 只需要在赋值的时候，记录上就可以了，然后相加时再替换
 */
public class ClimbingStairs {
    class Solution1 {
        Map<Integer,Integer> map = new HashMap<>();
        public int climbStairs(int n) {
            if(n == 1){
                map.put(1,1);
                return 1;
            }
            if(n == 2){
                map.put(2,2);
                return 2;
            }
            if(map.containsKey(n))return map.get(n);
            int ret = climbStairs(n-1)+climbStairs(n-2);
            map.put(n,ret);
            return ret;
        }
    }
    class Solution2 {
        public int climbStairs(int n) {
            int result = 0;
            int f1 = 1;
            int f2 = 2;
            if (n == 1) {
                return f1;
            }
            if (n == 2) {
                return f2;
            }
            for (int i = 3; i <= n; i++) {
                result = f1 + f2;//上上次情况+上次情况
                f1 = f2;//变成上次情况
                f2 = result;//变成这次情况
            }
            return result;
        }
    }
}
